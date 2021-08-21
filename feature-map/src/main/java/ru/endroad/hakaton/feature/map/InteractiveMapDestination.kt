package ru.endroad.hakaton.feature.map

import androidx.fragment.app.Fragment
import ru.endroad.component.navigation.destination.FragmentDestination
import ru.endroad.hakaton.shared.spot.entity.Position

class InteractiveMapDestination(private val position: Position? = null) : FragmentDestination {

	override fun createFragment(): Fragment =
		InteractiveMapFragment.newInstance(position)
}