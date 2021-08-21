package ru.endroad.hakaton.feature.domain

import ru.endroad.hakaton.shared.spot.entity.PanoramaPhotoSpot

interface MapRouter {

	fun openAudiogidBottomSheet()

	fun openPanoramaBottomSheet(image: PanoramaPhotoSpot)

	fun openRoutes()
}