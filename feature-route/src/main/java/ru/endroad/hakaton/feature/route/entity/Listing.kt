package ru.endroad.hakaton.feature.route.entity

import ru.endroad.hakaton.shared.spot.entity.Image

sealed class Listing {
	data class PromoItem(val promo: List<Promo>) : Listing()
	data class PointItem(val name: String) : Listing()
	data class RouteItem(val icon: Image, val name: String) : Listing()
	data class CategoryItem(val icon: Image, val name: String) : Listing()
}

data class Promo(val title: String, val description: String, val background: Image)