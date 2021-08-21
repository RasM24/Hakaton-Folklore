package ru.endroad.hakaton.folklore.navigation.di

import org.koin.core.qualifier.named
import org.koin.dsl.module
import org.koin.dsl.single
import ru.endroad.component.navigation.navigator.NavigationCommandExecutor
import ru.endroad.component.navigation.navigator.NavigationCommandStack
import ru.endroad.component.navigation.navigator.Navigator
import ru.endroad.hakaton.folklore.R
import ru.endroad.hakaton.folklore.navigation.deeplink.DeeplinkConverter

val rootNavigatorQualifier = named("RootNavigator")
val contentNavigatorQualifier = named("ContentNavigator")

val moduleNavigation = module {
	single<NavigationCommandStack>()
	single<NavigationCommandExecutor>()
	single<DeeplinkConverter>()

	single(rootNavigatorQualifier) { Navigator(R.id.promo_layout, get(), get()) }
	single(contentNavigatorQualifier) { Navigator(R.id.content, get(), get()) }
}