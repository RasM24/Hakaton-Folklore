package ru.endroad.hakaton.shared.spot.remote

import ru.endroad.hakaton.shared.spot.R
import ru.endroad.hakaton.shared.spot.entity.Image
import ru.endroad.hakaton.shared.spot.entity.Position

data class RemoteSpot(
	val id: Long,
	val name: String,
	val type: SpotType,
	val position: Position,
)

enum class SpotType(val icon: Image) {
	Audio(Image(R.drawable.ic_icon_audio)),
	Comic(Image(R.drawable.ic_icon_comic)),
	Meal(Image(R.drawable.ic_icon_meal)),
	Parking(Image(R.drawable.ic_icon_parking)),
	Photo(Image(R.drawable.ic_icon_photo)),
	Toilet(Image(R.drawable.ic_icon_toilet)),
}