package ru.endroad.hakaton.feature.route.view

import androidx.fragment.app.Fragment
import ru.endroad.component.navigation.destination.FragmentDestination

object RouteRecommendationDestination : FragmentDestination {

	override fun createFragment(): Fragment =
		RouteRecommendationFragment()
}