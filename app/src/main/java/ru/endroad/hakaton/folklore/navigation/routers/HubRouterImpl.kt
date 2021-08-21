package ru.endroad.hakaton.folklore.navigation.routers

import org.koin.java.KoinJavaComponent.inject
import ru.endroad.component.navigation.command.Command
import ru.endroad.component.navigation.destination.Destination
import ru.endroad.component.navigation.navigator.Navigator
import ru.endroad.hakaton.feature.map.InteractiveMapDestination
import ru.endroad.hakaton.folklore.application.HubRouter
import ru.endroad.hakaton.folklore.navigation.di.rootNavigatorQualifier

class HubRouterImpl : HubRouter {

	private val rootNavigator: Navigator by inject(Navigator::class.java, rootNavigatorQualifier)

	override fun openMainScreen() {
		rootNavigator.execute(Command.Open(InteractiveMapDestination))
	}

	override fun openDeeplinkDestination(destination: Destination) {
		rootNavigator.execute(Command.Open(destination))
	}
}