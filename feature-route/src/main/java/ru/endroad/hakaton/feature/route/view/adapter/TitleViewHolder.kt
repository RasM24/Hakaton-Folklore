package ru.endroad.hakaton.feature.route.view.adapter

import android.view.ViewGroup
import android.widget.TextView
import ru.endroad.hakaton.feature.route.R
import ru.endroad.hakaton.feature.route.entity.Listing

class TitleViewHolder(viewParent: ViewGroup) : ListingViewHolder(viewParent.inflate(R.layout.item_title)) {

	fun bind(item: Listing.TitleItem) {
		itemView.findViewById<TextView>(R.id.title).text = item.name
	}
}