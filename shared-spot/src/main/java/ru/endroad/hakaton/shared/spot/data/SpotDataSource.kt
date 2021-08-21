package ru.endroad.hakaton.shared.spot.data

import ru.endroad.hakaton.shared.spot.entity.AudioSpot
import ru.endroad.hakaton.shared.spot.entity.ComicsSpot
import ru.endroad.hakaton.shared.spot.entity.PanoramaPhotoSpot

class SpotDataSource {

	fun getPhotoSpotList(): List<PanoramaPhotoSpot> = listOf(panoramaSpot1, panoramaSpot2, panoramaSpot3, panoramaSpot4, panoramaSpot5, panoramaSpot6)

	fun getAudioList(): List<AudioSpot> = listOf(audiogidSpot)

	fun getComics(): List<ComicsSpot> = listOf(comics1, comics2, comics3, comics4, comics5)
}