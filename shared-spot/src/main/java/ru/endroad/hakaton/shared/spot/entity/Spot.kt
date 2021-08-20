package ru.endroad.hakaton.shared.spot.entity

sealed interface Spot {

	val id: Long
	val position: Position

	val icon: Image
	val category: Text
}