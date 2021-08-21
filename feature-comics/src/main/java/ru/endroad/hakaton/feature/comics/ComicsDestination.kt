package ru.endroad.hakaton.feature.comics

import androidx.fragment.app.Fragment
import ru.endroad.component.navigation.destination.FragmentDestination
import ru.endroad.hakaton.shared.spot.entity.Comics

class ComicsDestination(private val comics: Comics) : FragmentDestination {

	override fun createFragment(): Fragment =
		ComicsFragment.newInstance(comics)
}