package ru.endroad.hakaton.feature.interactive.view

import android.view.View
import com.google.android.material.floatingactionbutton.FloatingActionButton
import ru.endroad.component.common.BaseBottomSheetFragment
import ru.endroad.hakaton.feature.interactive.R
import ru.endroad.widget.audiogid.entity.Audio
import ru.endroad.widget.audiogid.widget.audio.AudioWidget
import ru.endroad.widget.audiogid.widget.audio.presenter.AudioWidgetState

class AudiogidBottomSheet : BaseBottomSheetFragment() {

	override val layout = R.layout.audiogid_fragment

	private lateinit var audioWidget: AudioWidget

	override fun setupViewComponents(parent: View) {
		setupAudioWidget(parent)
	}

	private fun setupAudioWidget(parent: View) {
		val fabAudio = parent.findViewById<FloatingActionButton>(R.id.fab_audio)
		audioWidget = parent.findViewById(R.id.audio_widget)
		val audio = Audio(R.raw.audio_kraevedcheski)

		audioWidget.setAudio(audio) {
			when (it) {
				AudioWidgetState.Stopped -> fabAudio.setImageResource(R.drawable.ic_play)
				AudioWidgetState.Playing -> fabAudio.setImageResource(R.drawable.ic_pause)
				AudioWidgetState.Paused  -> fabAudio.setImageResource(R.drawable.ic_play)
			}
		}

		fabAudio.setOnClickListener { audioWidget.changeState() }
	}

	override fun onDestroy() {
		super.onDestroy()
		audioWidget.stop()
	}
}