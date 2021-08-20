package ru.endroad.hakaton.feature.domain

import ru.endroad.hakaton.feature.interactive.enity.PanoramaImage

interface MapRouter {

	fun openAudiogidBottomSheet()

	fun openPanoramaBottomSheet(image: PanoramaImage)
}