package ru.endroad.widget.audiogid.widget.audio.presenter

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import ru.endroad.widget.audiogid.domain.MediaPlayerWrapper
import ru.endroad.widget.audiogid.entity.Audio

class AudioWidgetViewModel(
	private val context: Context, //TODO низзя
	private val audio: Audio,
) : ViewModel() {

	internal val state = MutableStateFlow<AudioWidgetState>(AudioWidgetState.Stopped)

	@Deprecated("Не должно быть такого кода во viewModel")
	val currentPosition = MutableStateFlow(0)

	private val mediaPlayer: MediaPlayerWrapper = MediaPlayerWrapper()

	@Deprecated("Не должно быть такого кода во viewModel")
	private val playAudio
		get() = state.value is AudioWidgetState.Playing

	init {
		//TODO Не должно быть такого кода во viewModel
		viewModelScope.launch {
			while (true) {
				if (playAudio) {
					mediaPlayer.progress.let { currentPosition.emit(it) }
				}
				delay(100)
			}
		}
	}

	internal fun notice(event: AudioWidgetEvent) {
		when (event) {
			AudioWidgetEvent.ChangeState -> if (playAudio) notice(AudioWidgetEvent.Stop) else notice(AudioWidgetEvent.Start)
			AudioWidgetEvent.Stop        -> stopAudio()
			is AudioWidgetEvent.Seek     -> mediaPlayer.seekTo(event.percent)
			is AudioWidgetEvent.Start    -> mediaPlayer.playAudio(
				context,
				audio = audio,
				onStartAudio = { state.tryEmit(AudioWidgetState.Playing) },
				onStopAudio = { state.tryEmit(AudioWidgetState.Stopped) },
			)
		}
	}

	private fun stopAudio() {
		mediaPlayer.pause()
		state.tryEmit(AudioWidgetState.Stopped)
	}

	override fun onCleared() {
		notice(AudioWidgetEvent.Stop)
		super.onCleared()
	}
}