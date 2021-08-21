package ru.endroad.hakaton.feature.route.view.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ru.endroad.hakaton.feature.route.entity.Listing
import ru.endroad.hakaton.feature.route.entity.Listing.CategoryItem
import ru.endroad.hakaton.feature.route.entity.Listing.PointItem
import ru.endroad.hakaton.feature.route.entity.Listing.PromoItem
import ru.endroad.hakaton.feature.route.entity.Listing.RouteItem

class ListingAdapter : RecyclerView.Adapter<ListingViewHolder>() {

	private companion object {

		const val PROMO_VIEW_TYPE = 1
		const val POINT_VIEW_TYPE = 2
		const val ROUTE_VIEW_TYPE = 3
		const val CATEGORY_VIEW_TYPE = 4
	}

	var items: List<Listing> = listOf()
		set(value) {
			field = value
			notifyDataSetChanged()
		}

	override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListingViewHolder =
		when (viewType) {
			PROMO_VIEW_TYPE    -> PromoViewHolder(parent)
			POINT_VIEW_TYPE    -> PointViewHolder(parent)
			ROUTE_VIEW_TYPE    -> RouteViewHolder(parent)
			CATEGORY_VIEW_TYPE -> CategoryViewHolder(parent)
			else               -> throw IllegalStateException("Отсутствует ViewHolder для данного viewType")
		}

	override fun onBindViewHolder(holder: ListingViewHolder, position: Int) {
		when (holder) {
			is PromoViewHolder    -> holder.bind(items[position] as PromoItem)
			is PointViewHolder    -> holder.bind(items[position] as PointItem)
			is RouteViewHolder    -> holder.bind(items[position] as RouteItem)
			is CategoryViewHolder -> holder.bind(items[position] as CategoryItem)
			else                  -> throw IllegalStateException("Отсутствует binding для ${holder::class}")
		}
	}

	override fun getItemViewType(position: Int): Int =
		when (items[position]) {
			is PromoItem    -> PROMO_VIEW_TYPE
			is PointItem    -> POINT_VIEW_TYPE
			is RouteItem    -> ROUTE_VIEW_TYPE
			is CategoryItem -> CATEGORY_VIEW_TYPE
		}

	override fun getItemCount(): Int =
		items.size
}