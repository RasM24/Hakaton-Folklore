package ru.endroad.hakaton.shared.spot.entity

import ru.endroad.hakaton.shared.spot.R

data class Sight(
	override val id: Long,
	override val position: Position,
	val name: Text,
	val headImage: Image,
) : Spot {

	override val icon = Image(R.drawable.ic_spot_sight)
	override val category = Text(R.string.spot_category_sight)
}