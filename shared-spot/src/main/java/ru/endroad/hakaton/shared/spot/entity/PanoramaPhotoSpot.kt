package ru.endroad.hakaton.shared.spot.entity

import ru.endroad.hakaton.shared.spot.R
import java.io.Serializable

data class PanoramaPhotoSpot(
	override val id: Long,
	override val position: Position,
	override val name: Text,
	val path: String,
) : Spot, Serializable {

	override val icon = Image(R.drawable.ic_icon_photo)
	override val category = Text(R.string.spot_category_photo)
}