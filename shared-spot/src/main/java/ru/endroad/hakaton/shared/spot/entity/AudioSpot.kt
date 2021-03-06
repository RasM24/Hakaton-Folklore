package ru.endroad.hakaton.shared.spot.entity

import ru.endroad.hakaton.shared.spot.R

data class AudioSpot(
	override val id: Long,
	override val position: Position,
	override val name: Text,
	val headImage: Image,
) : Spot {

	override val icon = Image(R.drawable.ic_icon_audio)
	override val category = Text(R.string.spot_category_sight)
}