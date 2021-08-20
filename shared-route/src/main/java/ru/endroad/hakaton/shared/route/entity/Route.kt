package ru.endroad.hakaton.shared.route.entity

import ru.endroad.hakaton.shared.spot.entity.Position

data class Route(val name: String, val path: List<Position>)
