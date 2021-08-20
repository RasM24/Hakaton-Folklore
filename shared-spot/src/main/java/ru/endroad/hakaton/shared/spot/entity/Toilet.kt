package ru.endroad.hakaton.shared.spot.entity

import ru.endroad.hakaton.shared.spot.R

data class Toilet(
	override val id: Long,
	override val position: Position,
) : Spot {

	override val icon = Image(R.drawable.ic_spot_toilet)
	override val category = Text(R.string.spot_category_toilet)
}