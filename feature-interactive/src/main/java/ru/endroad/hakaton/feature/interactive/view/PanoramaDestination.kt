package ru.endroad.hakaton.feature.interactive.view

import androidx.fragment.app.DialogFragment
import ru.endroad.component.navigation.destination.DialogFragmentDestination
import ru.endroad.hakaton.shared.spot.entity.PanoramaPhotoSpot

class PanoramaDestination(private val image: PanoramaPhotoSpot) : DialogFragmentDestination {

	override fun createFragment(): DialogFragment =
		PanoramaBottomSheet.newInstance(image)
}