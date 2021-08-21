package ru.endroad.hakaton.feature.interactive.view

import androidx.fragment.app.DialogFragment
import ru.endroad.component.navigation.destination.DialogFragmentDestination
import ru.endroad.hakaton.shared.spot.entity.ComicsSpot
import ru.endroad.hakaton.shared.spot.entity.PanoramaPhotoSpot

class ComicsDestination(private val comics: ComicsSpot) : DialogFragmentDestination {

	override fun createFragment(): DialogFragment =
		ComicsBottomSheet.newInstance(comics)
}