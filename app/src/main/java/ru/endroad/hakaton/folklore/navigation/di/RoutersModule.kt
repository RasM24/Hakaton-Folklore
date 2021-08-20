package ru.endroad.hakaton.folklore.navigation.di

import org.koin.dsl.module
import ru.endroad.hakaton.feature.domain.MapRouter
import ru.endroad.hakaton.folklore.application.HubRouter
import ru.endroad.hakaton.folklore.navigation.routers.HubRouterImpl
import ru.endroad.hakaton.folklore.navigation.routers.MapRouterImpl

val moduleRouters = module {
	single<HubRouter> { HubRouterImpl() }
	single<MapRouter> { MapRouterImpl() }
}