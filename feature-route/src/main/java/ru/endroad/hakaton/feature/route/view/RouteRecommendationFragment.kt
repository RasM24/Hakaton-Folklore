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
import ru.endroad.hakaton.shared.spot.entity.Image

class RouteRecommendationFragment : BaseFragment() {

	override val layout = R.layout.route_recommendation_fragment

	private val adapter = ListingAdapter()

	@ExperimentalStdlibApi
	override fun setupViewComponents(parent: View) {
		parent.findViewById<RecyclerView>(R.id.list).adapter = adapter

		adapter.items = getItemList()
	}

	@ExperimentalStdlibApi
	private fun getItemList(): List<Listing> =
		buildList {
			add(Listing.PromoItem(listOf(nitiKrasnoyarskaPromo, novgorodTravelPromo, aviasalesPromo)))

			add(Listing.RouteItem(Image(R.drawable.ic_icon_like), "Панекелька рекоммендует"))
			add(Listing.PointItem("Старая русса"))
			add(Listing.PointItem("Сказания озера Ильмень"))
			add(Listing.PointItem("Легенды Великого Новгорода"))

			add(Listing.RouteItem(Image(R.drawable.ic_icon_meal), "Богатырь после боя"))
			add(Listing.RouteItem(Image(R.drawable.ic_icon_auto), "Удалой ямщик"))
			add(Listing.RouteItem(Image(R.drawable.ic_icon_step), "Безлошадный крестьянин"))

			add(Listing.CategoryItem(Image(R.drawable.ic_radio), "Radio"))
			add(Listing.CategoryItem(Image(R.drawable.ic_book), "Recipes"))
			add(Listing.CategoryItem(Image(R.drawable.ic_bike), "Sports"))
			add(Listing.CategoryItem(Image(R.drawable.ic_airplane), "Travel"))
		}
}