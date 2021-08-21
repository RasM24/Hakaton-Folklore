package ru.endroad.hakaton.feature.route.view.carousel

import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import ru.endroad.hakaton.feature.route.R
import ru.endroad.hakaton.feature.route.entity.Promo
import ru.endroad.hakaton.feature.route.view.adapter.inflate

object PromoViewHolder {

	operator fun invoke(promo: Promo, viewParent: ViewGroup): View =
		viewParent.inflate(R.layout.item_carusel_promo).apply {
			findViewById<ViewGroup>(R.id.promo_layout).setBackgroundResource(promo.background.id)
			findViewById<TextView>(R.id.promo_title).text = promo.title
			findViewById<TextView>(R.id.promo_description).text = promo.description
		}
}