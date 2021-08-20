package ru.endroad.hakaton.folklore.navigation.deeplink

import ru.endroad.component.navigation.destination.Destination
import ru.endroad.component.deeplink.Deeplink
import ru.endroad.hakaton.feature.map.InteractiveMapDestination

class DeeplinkConverter {

	fun convert(deeplink: Deeplink): Destination? =
		when (deeplink.path) {
			"/map/interactive" -> InteractiveMapDestination
			else               -> null
		}
}