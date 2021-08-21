package ru.endroad.hakaton.feature.onboarding.view.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ru.endroad.hakaton.feature.onboarding.entity.Button
import ru.endroad.hakaton.feature.onboarding.entity.Listing
import ru.endroad.hakaton.feature.onboarding.entity.Listing.CategoryItem
import ru.endroad.hakaton.feature.onboarding.entity.Listing.PointItem
import ru.endroad.hakaton.shared.spot.entity.Comics

class ListingAdapter(
	private val onButtonClickListener: (Button) -> Unit,
	private val onComicsClickListener: (Comics) -> Unit,
) : RecyclerView.Adapter<ListingViewHolder>() {

	private companion object {

		const val POINT_VIEW_TYPE = 2
		const val CATEGORY_VIEW_TYPE = 4
	}

	var items: List<Listing> = listOf()
		set(value) {
			field = value
			notifyDataSetChanged()
		}

	override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListingViewHolder =
		when (viewType) {
			POINT_VIEW_TYPE    -> PointViewHolder(onComicsClickListener, parent)
			CATEGORY_VIEW_TYPE -> CategoryViewHolder(onButtonClickListener, parent)
			else               -> throw IllegalStateException("Отсутствует ViewHolder для данного viewType")
		}

	override fun onBindViewHolder(holder: ListingViewHolder, position: Int) {
		when (holder) {
			is PointViewHolder    -> holder.bind(items[position] as PointItem)
			is CategoryViewHolder -> holder.bind(items[position] as CategoryItem)
			else                  -> throw IllegalStateException("Отсутствует binding для ${holder::class}")
		}
	}

	override fun getItemViewType(position: Int): Int =
		when (items[position]) {
			is PointItem    -> POINT_VIEW_TYPE
			is CategoryItem -> CATEGORY_VIEW_TYPE
		}

	override fun getItemCount(): Int =
		items.size
}