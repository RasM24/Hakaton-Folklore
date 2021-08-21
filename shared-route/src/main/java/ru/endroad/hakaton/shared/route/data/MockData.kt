package ru.endroad.hakaton.shared.route.data

import ru.endroad.hakaton.shared.route.entity.ExternalRoute
import ru.endroad.hakaton.shared.route.entity.Route
import ru.endroad.hakaton.shared.spot.entity.Position

val russaRoute = Route(
	"Старая Русса", listOf(
		Position(57.991167, 31.331087),
		Position(57.997299, 31.343769),
		Position(57.993445, 31.350987),
		Position(57.992307, 31.353730),
		Position(57.993464, 31.371882),
		Position(57.997031, 31.370943),
		Position(57.997209, 31.372819),
		Position(57.995842, 31.375579),
	)
)
internal val route2 = Route("Маршрут 2", listOf())
internal val route3 = Route("Маршрут 3", listOf())
internal val route4 = Route("Маршрут 4", listOf())
internal val route5 = Route("Маршрут 5", listOf())

internal val externalRoute1 = ExternalRoute("Google Маршрут 1", "link")
internal val externalRoute2 = ExternalRoute("Google Маршрут 2", "link")
internal val externalRoute3 = ExternalRoute("Google Маршрут 3", "link")