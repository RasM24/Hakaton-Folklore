package ru.endroad.hakaton.feature.route.view.adapter

import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import ru.endroad.component.common.showToast
import ru.endroad.hakaton.feature.route.R
import ru.endroad.hakaton.feature.route.entity.Listing

class RouteViewHolder(viewParent: ViewGroup) : ListingViewHolder(viewParent.inflate(R.layout.item_route)) {

	fun bind(item: Listing.RouteItem) {
		itemView.setOnClickListener { itemView.context.showToast("Click") }

		itemView.findViewById<TextView>(R.id.name).text = item.name
		itemView.findViewById<ImageView>(R.id.image).setImageResource(item.icon.id)
	}
}