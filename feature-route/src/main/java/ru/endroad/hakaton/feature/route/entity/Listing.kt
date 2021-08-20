package ru.endroad.hakaton.feature.route.entity

import ru.endroad.hakaton.shared.route.entity.ExternalRoute
import ru.endroad.hakaton.shared.route.entity.Route

sealed class Listing {
	data class PromoItem(val promo: List<Promo>) : Listing()
	data class TitleItem(val name: String) : Listing()
	data class RouteItem(val data: Route) : Listing()
	data class ExternalRouteItem(val data: ExternalRoute) : Listing()
}

data class Promo(val title: String, val description: String)