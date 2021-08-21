package ru.endroad.hakaton.shared.route.data

import ru.endroad.hakaton.shared.route.entity.ExternalRoute
import ru.endroad.hakaton.shared.route.entity.Route

class RouteDataSource {

	fun getRouteList(): List<Route> = listOf(russaRoute, route2, route3, route4, route5)

	fun getExternalRoute(): List<ExternalRoute> = listOf(externalRoute1, externalRoute2, externalRoute3)
}