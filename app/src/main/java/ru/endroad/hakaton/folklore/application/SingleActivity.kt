package ru.endroad.hakaton.folklore.application

import android.os.Bundle
import androidx.annotation.StyleRes
import androidx.appcompat.app.AppCompatActivity
import org.koin.android.ext.android.inject
import ru.endroad.component.navigation.navigator.NavigationCommandStack
import ru.endroad.component.deeplink.deeplink
import ru.endroad.hakaton.folklore.R
import ru.endroad.hakaton.folklore.navigation.deeplink.DeeplinkConverter

class SingleActivity : AppCompatActivity() {

	private val layout = R.layout.activity_single

	@StyleRes
	private val theme = R.style.Theme_HakatonFolklore

	private val deeplinkConverter: DeeplinkConverter by inject()
	private val navigator: NavigationCommandStack by inject()
	private val router: HubRouter by inject()

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setTheme(theme)
		setContentView(layout)
		navigator.registryNavigationContext(this)

		deeplink
			?.let(deeplinkConverter::convert)
			?.let(router::openDeeplinkDestination)
			?: router.openMainScreen()

//		launchNotification {
//			title = "Deeplink"
//			message = "Open map screen"
//			deepLink = "https://link.endroad.ru/map/interactive"
//		}
//
//		launchNotification {
//			title = "Deeplink"
//			message = "Open spot detail screen"
//			deepLink = "https://link.endroad.ru/spot/detail?id=0"
//		}
	}
}