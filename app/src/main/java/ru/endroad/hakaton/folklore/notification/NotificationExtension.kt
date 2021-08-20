package ru.endroad.hakaton.folklore.notification

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.app.TaskStackBuilder
import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.media.RingtoneManager
import android.net.Uri
import android.os.Build
import androidx.core.app.NotificationCompat
import ru.endroad.hakaton.folklore.R
import ru.endroad.hakaton.folklore.application.SingleActivity
import kotlin.random.Random

private val vibrationPattern = longArrayOf(100, 200, 300, 400, 500, 400, 300, 200, 400)

private const val channelName = "clientNotification"
private const val channelId = "clientNotification"

private val randomNotificationId get() = Random.nextInt()

fun Context.launchNotification(builder: NotificationBuilder.() -> Unit) {
	NotificationBuilder()
		.apply(builder)
		.build(this)
		.let { notification -> getNotificationManager().notify(randomNotificationId, notification) }
}

private fun Context.getNotificationManager(): NotificationManager {
	val notificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
	if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
		val mChannel = NotificationChannel(channelId, channelName, NotificationManager.IMPORTANCE_DEFAULT)
		mChannel.enableLights(true)
		mChannel.lightColor = Color.RED
		notificationManager.createNotificationChannel(mChannel)
	}

	return notificationManager
}

private fun NotificationBuilder.build(context: Context): Notification {
	val intent = context.createDeeplink(url = requireNotNull(deepLink)).let(context::createPendingIntentForNotification)

	return NotificationCompat.Builder(context, "channelId")
		.setSmallIcon(R.mipmap.ic_launcher)
		.setContentTitle(title)
		.setContentText(message)
		.setAutoCancel(true)
		.setNumber(1)
		.setSound(RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION))
		.setVibrate(vibrationPattern)
		.setWhen(System.currentTimeMillis())
		.setContentIntent(intent)
		.build()
}

private fun Context.createDeeplink(url: String): Intent =
	Intent(this, SingleActivity::class.java)
		.apply {
			action = Intent.ACTION_VIEW
			data = Uri.parse(url)
		}

private fun Context.createPendingIntentForNotification(intent: Intent): PendingIntent? =
	TaskStackBuilder.create(this)
		.apply { addNextIntent(intent) }
		.getPendingIntent(0, PendingIntent.FLAG_UPDATE_CURRENT)