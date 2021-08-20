package ru.endroad.hakaton.feature.interactive.view

import androidx.fragment.app.DialogFragment
import ru.endroad.component.navigation.destination.DialogFragmentDestination

class AudiogidDestination : DialogFragmentDestination {

	override fun createFragment(): DialogFragment =
		AudiogidBottomSheet()
}