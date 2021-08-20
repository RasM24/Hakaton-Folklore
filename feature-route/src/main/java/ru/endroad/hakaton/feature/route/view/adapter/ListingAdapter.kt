package ru.endroad.hakaton.feature.route.view.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ru.endroad.hakaton.feature.route.entity.Listing
import ru.endroad.hakaton.feature.route.entity.Listing.ExternalRouteItem
import ru.endroad.hakaton.feature.route.entity.Listing.PromoItem
import ru.endroad.hakaton.feature.route.entity.Listing.RouteItem
import ru.endroad.hakaton.feature.route.entity.Listing.TitleItem

class ListingAdapter : RecyclerView.Adapter<ListingViewHolder>() {

	private companion object {

		const val PROMO_VIEW_TYPE = 1
		const val TITLE_VIEW_TYPE = 2
		const val ROUTE_VIEW_TYPE = 3
		const val EXTERNAL_ROUTE_VIEW_TYPE = 4
	}

	var items: List<Listing> = listOf()
		set(value) {
			field = value
			notifyDataSetChanged()
		}

	override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListingViewHolder =
		when (viewType) {
			PROMO_VIEW_TYPE          -> PromoViewHolder(parent)
			TITLE_VIEW_TYPE          -> TitleViewHolder(parent)
			ROUTE_VIEW_TYPE          -> RouteViewHolder(parent)
			EXTERNAL_ROUTE_VIEW_TYPE -> ExternalRouteViewHolder(parent)
			else                     -> throw IllegalStateException("Отсутствует ViewHolder для данного viewType")
		}

	override fun onBindViewHolder(holder: ListingViewHolder, position: Int) {
		when (holder) {
			is PromoViewHolder         -> holder.bind(items[position] as PromoItem)
			is TitleViewHolder         -> holder.bind(items[position] as TitleItem)
			is RouteViewHolder         -> holder.bind(items[position] as RouteItem)
			is ExternalRouteViewHolder -> holder.bind(items[position] as ExternalRouteItem)
			else                       -> throw IllegalStateException("Отсутствует binding для ${holder::class}")
		}
	}

	override fun getItemViewType(position: Int): Int =
		when (items[position]) {
			is PromoItem         -> PROMO_VIEW_TYPE
			is TitleItem         -> TITLE_VIEW_TYPE
			is RouteItem         -> ROUTE_VIEW_TYPE
			is ExternalRouteItem -> EXTERNAL_ROUTE_VIEW_TYPE
		}

	override fun getItemCount(): Int =
		items.size
}