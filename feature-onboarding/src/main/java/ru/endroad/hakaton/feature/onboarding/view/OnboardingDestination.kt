package ru.endroad.hakaton.feature.onboarding.view

import androidx.fragment.app.Fragment
import ru.endroad.component.navigation.destination.FragmentDestination

object OnboardingDestination : FragmentDestination {

	override fun createFragment(): Fragment =
		OnboardingFragment()
}