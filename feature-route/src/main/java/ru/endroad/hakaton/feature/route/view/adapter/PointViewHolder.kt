package ru.endroad.hakaton.feature.route.view.adapter

import android.view.ViewGroup
import android.widget.TextView
import ru.endroad.component.common.showToast
import ru.endroad.hakaton.feature.route.R
import ru.endroad.hakaton.feature.route.entity.Listing

class PointViewHolder(viewParent: ViewGroup) : ListingViewHolder(viewParent.inflate(R.layout.item_point)) {

	fun bind(item: Listing.PointItem) {
		itemView.setOnClickListener { itemView.context.showToast("Click") }

		itemView.findViewById<TextView>(R.id.title).text = item.name
	}
}