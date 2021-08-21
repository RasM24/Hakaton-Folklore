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
	Building(Image(R.drawable.ic_icon_building)),
	Water(Image(R.drawable.ic_icon_water)),
	Stone(Image(R.drawable.ic_icon_stone)),
}