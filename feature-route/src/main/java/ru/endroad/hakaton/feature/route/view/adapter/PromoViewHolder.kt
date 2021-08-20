package ru.endroad.hakaton.feature.route.view.adapter

import android.view.ViewGroup
import ru.endroad.hakaton.feature.route.R
import ru.endroad.hakaton.feature.route.entity.Listing
import ru.endroad.hakaton.feature.route.view.carousel.CarouselView

class PromoViewHolder(viewParent: ViewGroup) : ListingViewHolder(viewParent.inflate(R.layout.item_promo)) {

	fun bind(item: Listing.PromoItem) {
		itemView.findViewById<CarouselView>(R.id.carouselView).setPromoList(item.promo)
	}
}