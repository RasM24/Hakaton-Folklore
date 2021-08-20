package ru.endroad.hakaton.folklore.navigation.di

import org.koin.dsl.module
import ru.endroad.hakaton.folklore.application.HubRouter
import ru.endroad.hakaton.folklore.navigation.routers.HubRouterImpl

val moduleRouters = module {
	single<HubRouter> { HubRouterImpl() }
}