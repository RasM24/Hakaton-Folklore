package ru.endroad.hakaton.folklore.navigation.routers

import org.koin.java.KoinJavaComponent
import ru.endroad.component.navigation.command.Command
import ru.endroad.component.navigation.navigator.Navigator
import ru.endroad.hakaton.feature.interactive.view.AudiogidDestination
import ru.endroad.hakaton.feature.map.InteractiveMapDestination
import ru.endroad.hakaton.feature.onboarding.domain.MainRouter
import ru.endroad.hakaton.feature.onboarding.entity.Comics
import ru.endroad.hakaton.feature.route.view.RouteRecommendationDestination
import ru.endroad.hakaton.folklore.navigation.di.rootNavigatorQualifier

class MainRouterImpl : MainRouter {

	private val rootNavigator: Navigator by KoinJavaComponent.inject(Navigator::class.java, rootNavigatorQualifier)

	override fun openMap() {
		rootNavigator.execute(Command.Open(InteractiveMapDestination))
	}

	override fun openComics(comics: Comics) {
//		rootNavigator.execute(Command.Open())
	}

	override fun openRoutes() {
		rootNavigator.execute(Command.Open(RouteRecommendationDestination))
	}

	override fun openAudiogid() {
		rootNavigator.execute(Command.Open(AudiogidDestination()))
	}
}