package ru.endroad.hakaton.feature.map

import androidx.fragment.app.Fragment
import ru.endroad.component.navigation.destination.FragmentDestination

object InteractiveMapDestination : FragmentDestination {

	override fun createFragment(): Fragment =
		InteractiveMapFragment()
}