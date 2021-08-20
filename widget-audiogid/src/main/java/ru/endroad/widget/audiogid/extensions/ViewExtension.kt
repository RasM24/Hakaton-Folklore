package ru.endroad.widget.audiogid.extensions

import android.widget.SeekBar

internal fun SeekBar.setOnProgressChangedFromUserListener(onProgressChanged: (Int) -> Unit) {
	setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
		override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
			if (fromUser) onProgressChanged(progress)
		}

		override fun onStartTrackingTouch(seekBar: SeekBar?) = Unit
		override fun onStopTrackingTouch(seekBar: SeekBar?) = Unit
	})
}