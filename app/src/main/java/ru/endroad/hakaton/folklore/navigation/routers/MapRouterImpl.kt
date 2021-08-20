package ru.endroad.hakaton.folklore.navigation.routers

import org.koin.java.KoinJavaComponent
import ru.endroad.component.navigation.command.Command
import ru.endroad.component.navigation.navigator.Navigator
import ru.endroad.hakaton.feature.domain.MapRouter
import ru.endroad.hakaton.feature.interactive.view.AudiogidDestination
import ru.endroad.hakaton.feature.interactive.view.PanoramaDestination
import ru.endroad.hakaton.folklore.navigation.di.rootNavigatorQualifier
import ru.endroad.widget.panorama.image.PanoramaImage

class MapRouterImpl : MapRouter {

	private val rootNavigator: Navigator by KoinJavaComponent.inject(Navigator::class.java, rootNavigatorQualifier)

	override fun openAudiogidBottomSheet() {
		rootNavigator.execute(Command.Open(AudiogidDestination()))
	}

	override fun openPanoramaBottomSheet(image: PanoramaImage) {
		rootNavigator.execute(Command.Open(PanoramaDestination(image)))
	}
}