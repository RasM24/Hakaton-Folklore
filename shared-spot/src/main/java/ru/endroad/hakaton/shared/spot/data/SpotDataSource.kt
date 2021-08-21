package ru.endroad.hakaton.shared.spot.data

import ru.endroad.hakaton.shared.spot.R
import ru.endroad.hakaton.shared.spot.entity.Image
import ru.endroad.hakaton.shared.spot.entity.PanoramaPhotoSpot
import ru.endroad.hakaton.shared.spot.entity.Position
import ru.endroad.hakaton.shared.spot.entity.Sight
import ru.endroad.hakaton.shared.spot.entity.Text

class SpotDataSource {

	private companion object {

		private val sightSpotOpera = Sight(0, Position(56.008627, 92.868377), Text(R.string.sight_opera), Image(R.drawable.photo_sight_opera))
	}

	fun getPhotoSpotList(): List<PanoramaPhotoSpot> = listOf(panoramaSpot1, panoramaSpot2, panoramaSpot3, panoramaSpot4, panoramaSpot5, panoramaSpot6)

	fun getSightList(): List<Sight> = listOf(sightSpotOpera)
}