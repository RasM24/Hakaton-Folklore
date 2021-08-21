package ru.endroad.hakaton.folklore.navigation.routers

import org.koin.java.KoinJavaComponent
import ru.endroad.component.navigation.command.Command
import ru.endroad.component.navigation.navigator.Navigator
import ru.endroad.hakaton.feature.comics.ComicsRouter
import ru.endroad.hakaton.feature.map.InteractiveMapDestination
import ru.endroad.hakaton.folklore.navigation.di.rootNavigatorQualifier
import ru.endroad.hakaton.shared.spot.entity.Position

class ComicsRouterImpl : ComicsRouter {

	private val rootNavigator: Navigator by KoinJavaComponent.inject(Navigator::class.java, rootNavigatorQualifier)

	override fun openMap(position: Position) {
		rootNavigator.execute(Command.Open(InteractiveMapDestination(position)))
	}
}