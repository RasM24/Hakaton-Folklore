package ru.endroad.widget.audiogid.widget.audio.presenter

sealed class AudioWidgetEvent {

	@Deprecated("Временное события, до полноценного выделения виджета")
	object ChangeState : AudioWidgetEvent()

	object Start : AudioWidgetEvent()
	object Stop : AudioWidgetEvent()
	class Seek(val percent: Int) : AudioWidgetEvent()
}