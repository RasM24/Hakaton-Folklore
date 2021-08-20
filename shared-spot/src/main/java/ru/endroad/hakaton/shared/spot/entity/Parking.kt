package ru.endroad.hakaton.shared.spot.entity

import ru.endroad.hakaton.shared.spot.R

data class Parking(
	override val id: Long,
	override val position: Position,
) : Spot {

	override val icon = Image(R.drawable.ic_spot_parking)
	override val category = Text(R.string.spot_category_parking)
}