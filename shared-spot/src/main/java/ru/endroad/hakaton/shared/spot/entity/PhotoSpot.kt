package ru.endroad.hakaton.shared.spot.entity

import ru.endroad.hakaton.shared.spot.R

data class PhotoSpot(
	override val id: Long,
	override val position: Position,
) : Spot {

	override val icon = Image(R.drawable.ic_spot_photo)
	override val category = Text(R.string.spot_category_photo)
}