package ru.endroad.hakaton.shared.spot.entity

import ru.endroad.hakaton.shared.spot.R
import java.io.Serializable

class ComicsSpot(
	override val id: Long,
	override val position: Position,
	override val name: Text,
	val image: Image,
) : Spot, Serializable {

	override val icon = Image(R.drawable.ic_icon_comic)
	override val category = Text(R.string.spot_category_toilet)
}