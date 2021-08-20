package ru.endroad.hakaton.feature.interactive.view

import androidx.fragment.app.DialogFragment
import ru.endroad.component.navigation.destination.DialogFragmentDestination
import ru.endroad.hakaton.feature.interactive.enity.PanoramaImage

class PanoramaDestination(private val image: PanoramaImage) : DialogFragmentDestination {

	override fun createFragment(): DialogFragment =
		PanoramaBottomSheet.newInstance(image)
}