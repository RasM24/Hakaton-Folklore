package ru.endroad.hakaton.feature.onboarding.view.adapter

import android.view.ViewGroup
import android.widget.TextView
import ru.endroad.hakaton.feature.onboarding.R
import ru.endroad.hakaton.feature.onboarding.entity.Comics
import ru.endroad.hakaton.feature.onboarding.entity.Listing

class PointViewHolder(
	private val onClickListener: (Comics) -> Unit,
	viewParent: ViewGroup
) : ListingViewHolder(viewParent.inflate(R.layout.item_point)) {

	fun bind(item: Listing.PointItem) {
		itemView.setOnClickListener { onClickListener(item.comics) }

		itemView.findViewById<TextView>(R.id.title).text = item.comics.title
	}
}