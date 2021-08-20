package ru.endroad.hakaton.feature.route.view.adapter

import android.view.ViewGroup
import android.widget.TextView
import ru.endroad.hakaton.feature.route.R
import ru.endroad.hakaton.feature.route.entity.Listing

class RouteViewHolder(viewParent: ViewGroup) : ListingViewHolder(viewParent.inflate(R.layout.item_route)) {

	fun bind(item: Listing.RouteItem) {
		itemView.findViewById<TextView>(R.id.name).text = item.data.name
	}
}