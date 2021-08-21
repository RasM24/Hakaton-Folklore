package ru.endroad.hakaton.feature.onboarding.view.adapter

import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import ru.endroad.hakaton.feature.onboarding.R
import ru.endroad.hakaton.feature.onboarding.entity.Button
import ru.endroad.hakaton.feature.onboarding.entity.Listing

class CategoryViewHolder(
	private val onClickListener: (Button) -> Unit,
	viewParent: ViewGroup
) : ListingViewHolder(viewParent.inflate(R.layout.item_button)) {

	fun bind(item: Listing.CategoryItem) {
		itemView.setOnClickListener { onClickListener(item.button) }

		itemView.findViewById<TextView>(R.id.name).text = item.button.title
		itemView.findViewById<ImageView>(R.id.image).setImageResource(item.button.icon.id)
	}
}