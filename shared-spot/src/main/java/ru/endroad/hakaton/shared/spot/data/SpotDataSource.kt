package ru.endroad.hakaton.shared.spot.data

import ru.endroad.hakaton.shared.spot.R
import ru.endroad.hakaton.shared.spot.entity.Image
import ru.endroad.hakaton.shared.spot.entity.Parking
import ru.endroad.hakaton.shared.spot.entity.PhotoSpot
import ru.endroad.hakaton.shared.spot.entity.Position
import ru.endroad.hakaton.shared.spot.entity.Sight
import ru.endroad.hakaton.shared.spot.entity.Text
import ru.endroad.hakaton.shared.spot.entity.Toilet

class SpotDataSource {

	private companion object {

		private val sightSpotOpera = Sight(0, Position(56.008627, 92.868377), Text(R.string.sight_opera), Image(R.drawable.photo_sight_opera))
		private val randomSpotParking = Parking(0, Position(56.038762, 92.926980))
		private val randomSpotPhoto = PhotoSpot(0, Position(56.026533, 92.938417))
		private val randomSpotToilet = Toilet(0, Position(56.010110,92.928684))
	}

	fun getParkingList(): List<Parking> = listOf(randomSpotParking)

	fun getPhotoSpotList(): List<PhotoSpot> = listOf(randomSpotPhoto)

	fun getSightList(): List<Sight> = listOf(sightSpotOpera)

	fun getToiletList(): List<Toilet> = listOf(randomSpotToilet)
}