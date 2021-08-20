package ru.endroad.component.navigation.destination

import androidx.fragment.app.DialogFragment

interface DialogFragmentDestination : Destination {

	fun createFragment(): DialogFragment
}