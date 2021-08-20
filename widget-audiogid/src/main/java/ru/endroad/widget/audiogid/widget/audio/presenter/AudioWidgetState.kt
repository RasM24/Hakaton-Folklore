package ru.endroad.widget.audiogid.widget.audio.presenter

sealed class AudioWidgetState {

	object Stopped : AudioWidgetState()
	object Playing : AudioWidgetState()
	object Paused : AudioWidgetState()
	//TODO Добавить ErrorState
}