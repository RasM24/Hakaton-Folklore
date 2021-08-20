package ru.endroad.widget.audiogid.domain

import android.content.Context
import android.media.MediaPlayer
import ru.endroad.widget.audiogid.entity.Audio

class MediaPlayerWrapper {

	private var mediaPlayer: MediaPlayer? = null

	val progress: Int get() = mediaPlayer?.let { 100 * it.currentPosition / it.duration } ?: 0

	fun seekTo(percent: Int) {
		mediaPlayer?.run { seekTo(percent * duration / 100) }
	}

	@Deprecated("Не передавать контекст")
	fun playAudio(
		context: Context,
		audio: Audio,
		onStartAudio: () -> Unit,
		onStopAudio: () -> Unit,
	) {
		if (mediaPlayer != null) {
			mediaPlayer?.start()
			onStartAudio()
		} else {
			mediaPlayer = MediaPlayer.create(context, audio.rawId)
			mediaPlayer?.isLooping = false
			mediaPlayer?.start()
			mediaPlayer?.setOnCompletionListener { onStopAudio() }
			onStartAudio()
		}
	}

	fun pause() {
		mediaPlayer?.pause()
	}
}