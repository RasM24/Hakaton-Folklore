package ru.endroad.hakaton.feature.route.view

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import ru.endroad.component.common.BaseFragment
import ru.endroad.hakaton.feature.route.R
import ru.endroad.hakaton.feature.route.data.aviasalesPromo
import ru.endroad.hakaton.feature.route.data.nitiKrasnoyarskaPromo
import ru.endroad.hakaton.feature.route.data.novgorodTravelPromo
import ru.endroad.hakaton.feature.route.entity.Listing
import ru.endroad.hakaton.feature.route.view.adapter.ListingAdapter
import ru.endroad.hakaton.shared.route.data.RouteDataSource

class RouteRecommendationFragment : BaseFragment() {

	override val layout = R.layout.route_recommendation_fragment

	private val adapter = ListingAdapter()
	private val dataSource = RouteDataSource()

	@ExperimentalStdlibApi
	override fun setupViewComponents(parent: View) {
		parent.findViewById<RecyclerView>(R.id.list).adapter = adapter

		adapter.items = getItemList()
	}

	@ExperimentalStdlibApi
	private fun getItemList(): List<Listing> =
		buildList {
			add(Listing.PromoItem(listOf(nitiKrasnoyarskaPromo, novgorodTravelPromo, aviasalesPromo)))

			add(Listing.TitleItem("Популярное"))
			addAll(dataSource.getRouteList().map(Listing::RouteItem))

			add(Listing.TitleItem("Маршруты в GoogleMap"))
			addAll(dataSource.getExternalRoute().map(Listing::ExternalRouteItem))
		}
}