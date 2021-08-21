package ru.endroad.hakaton.feature.onboarding.view.adapter

import android.view.ViewGroup
import android.widget.TextView
import ru.endroad.hakaton.feature.onboarding.R
import ru.endroad.hakaton.feature.onboarding.entity.Listing
import ru.endroad.hakaton.shared.spot.entity.Comics

class PointViewHolder(
	private val onClickListener: (Comics) -> Unit,
	viewParent: ViewGroup
) : ListingViewHolder(viewParent.inflate(R.layout.item_point)) {

	fun bind(item: Listing.PointItem) {
		itemView.setOnClickListener { onClickListener(item.comics) }

		itemView.findViewById<TextView>(R.id.title).text = item.comics.title
	}
}