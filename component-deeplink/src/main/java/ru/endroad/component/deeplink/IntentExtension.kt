package ru.endroad.component.deeplink

import android.app.Activity
import android.content.Intent
import android.net.Uri

val Activity.deeplink: Deeplink?
	get() = intent?.takeIf(::isDeeplink)
		?.data
		?.let(::toDeeplink)

fun isDeeplink(intent: Intent): Boolean =
	intent.action == Intent.ACTION_VIEW

fun toDeeplink(uri: Uri): Deeplink? =
	runCatching { Deeplink(requireNotNull(uri.path), uri.queryParameters) }.getOrNull()

//TODO оптимизировать
private val Uri.queryParameters: DeeplinkParameters
	get() = queryParameterNames.associateWith(::getQueryParameter)