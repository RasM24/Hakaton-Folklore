package ru.endroad.hakaton.folklore.navigation.routers

import org.koin.java.KoinJavaComponent
import ru.endroad.component.navigation.command.Command
import ru.endroad.component.navigation.navigator.Navigator
import ru.endroad.hakaton.feature.domain.MapRouter
import ru.endroad.hakaton.feature.interactive.view.AudiogidDestination
import ru.endroad.hakaton.feature.interactive.view.ComicsDestination
import ru.endroad.hakaton.feature.interactive.view.PanoramaDestination
import ru.endroad.hakaton.feature.route.view.RouteRecommendationDestination
import ru.endroad.hakaton.folklore.navigation.di.rootNavigatorQualifier
import ru.endroad.hakaton.shared.spot.entity.ComicsSpot
import ru.endroad.hakaton.shared.spot.entity.PanoramaPhotoSpot

class MapRouterImpl : MapRouter {

	private val rootNavigator: Navigator by KoinJavaComponent.inject(Navigator::class.java, rootNavigatorQualifier)

	override fun openAudiogidBottomSheet() {
		rootNavigator.execute(Command.Open(AudiogidDestination()))
	}

	override fun openPanoramaBottomSheet(image: PanoramaPhotoSpot) {
		rootNavigator.execute(Command.Open(PanoramaDestination(image)))
	}

	override fun openRoutes() {
		rootNavigator.execute(Command.Open(RouteRecommendationDestination))
	}

	override fun openComicsBottomSheet(comics: ComicsSpot) {
		rootNavigator.execute(Command.Open(ComicsDestination(comics)))
	}
}