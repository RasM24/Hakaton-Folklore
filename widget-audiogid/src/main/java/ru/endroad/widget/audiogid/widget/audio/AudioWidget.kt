package ru.endroad.widget.audiogid.widget.audio

import android.content.Context
import android.util.AttributeSet
import android.widget.FrameLayout
import android.widget.ProgressBar
import android.widget.SeekBar
import androidx.lifecycle.coroutineScope
import androidx.lifecycle.findViewTreeLifecycleOwner
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import ru.endroad.widget.audiogid.R
import ru.endroad.widget.audiogid.entity.Audio
import ru.endroad.widget.audiogid.widget.audio.presenter.AudioWidgetEvent
import ru.endroad.widget.audiogid.widget.audio.presenter.AudioWidgetState
import ru.endroad.widget.audiogid.widget.audio.presenter.AudioWidgetViewModel

class AudioWidget @JvmOverloads constructor(
	context: Context,
	attributeSet: AttributeSet? = null,
	defStyleAttr: Int = 0,
	defStyleRes: Int = 0
) : FrameLayout(context, attributeSet, defStyleAttr, defStyleRes) {

	private val loadProgress: ProgressBar
	private val audioProgress: SeekBar

	private val lifecycleScope get() = findViewTreeLifecycleOwner().let(::requireNotNull).lifecycle.coroutineScope

	init {
		inflate(context, R.layout.audio_widget, this)

		loadProgress = findViewById(R.id.audio_widget_load_progress)
		audioProgress = findViewById(R.id.audio_widget_audio_progress)

	}

	//ОСТОРОЖНО, ГОВНОКОД
	private lateinit var viewModel: AudioWidgetViewModel

	//ОСТОРОЖНО, ГОВНОКОД
	fun setAudio(audio: Audio, stateListener: (AudioWidgetState) -> Unit) {
		viewModel = AudioWidgetViewModel(context, audio)

		viewModel.state
			.onEach { stateListener(it) }
			.onEach { render(it) }
			.launchIn(lifecycleScope)

		//TODO перенести эти данные в AudioWidgetState.Playing
		viewModel.currentPosition
			.onEach { setSeekBarProgress(it) }
			.launchIn(lifecycleScope)


		setOnSeekListener { viewModel.notice(AudioWidgetEvent.Seek(it)) }
	}

	@Deprecated("Избавится от флага")
	private var seekAudio = false

	private fun render(state: AudioWidgetState) {
		when (state) {
			AudioWidgetState.Stopped -> Unit
			AudioWidgetState.Paused  -> Unit

			AudioWidgetState.Loading -> {
				loadProgress.visibility = VISIBLE
			}

			AudioWidgetState.Playing -> {
				loadProgress.visibility = GONE
				audioProgress.visibility = VISIBLE
			}
		}
	}

	private fun setOnSeekListener(onSeekListener: (Int) -> Unit) {
		audioProgress.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
			override fun onProgressChanged(seekBar: SeekBar, i: Int, b: Boolean) = Unit
			override fun onStartTrackingTouch(seekBar: SeekBar) {
				seekAudio = true
			}

			override fun onStopTrackingTouch(seekBar: SeekBar) {
				onSeekListener(seekBar.progress)
				seekAudio = false
			}
		}
		)
	}

	private fun setSeekBarProgress(progress: Int) {
		if (!seekAudio) audioProgress.progress = progress
	}

	fun changeState() {
		viewModel.notice(AudioWidgetEvent.ChangeState)
	}
}