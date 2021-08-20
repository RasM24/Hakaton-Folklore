package ru.endroad.hakaton.shared.route.data

import ru.endroad.hakaton.shared.route.entity.ExternalRoute
import ru.endroad.hakaton.shared.route.entity.Route

class RouteDataSource {

	private val route1 = Route("Маршрут 1", listOf())
	private val route2 = Route("Маршрут 2", listOf())
	private val route3 = Route("Маршрут 3", listOf())
	private val route4 = Route("Маршрут 4", listOf())
	private val route5 = Route("Маршрут 5", listOf())

	private val externalRoute1 = ExternalRoute("Google Маршрут 1", "link")
	private val externalRoute2 = ExternalRoute("Google Маршрут 2", "link")
	private val externalRoute3 = ExternalRoute("Google Маршрут 3", "link")

	fun getRouteList(): List<Route> = listOf(route1, route2, route3, route4, route5)

	fun getExternalRoute(): List<ExternalRoute> = listOf(externalRoute1, externalRoute2, externalRoute3)
}