package ru.endroad.hakaton.folklore.application

import ru.endroad.component.navigation.destination.Destination

interface HubRouter {

	fun openMainScreen()

	fun openDeeplinkDestination(destination: Destination)
}