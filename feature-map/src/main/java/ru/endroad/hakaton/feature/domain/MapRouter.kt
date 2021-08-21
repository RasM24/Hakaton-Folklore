package ru.endroad.hakaton.feature.domain

import ru.endroad.widget.panorama.image.PanoramaImage

interface MapRouter {

	fun openAudiogidBottomSheet()

	fun openPanoramaBottomSheet(image: PanoramaImage)

	fun openRoutes()
}