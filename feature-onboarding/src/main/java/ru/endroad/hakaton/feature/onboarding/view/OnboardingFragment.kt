package ru.endroad.hakaton.feature.onboarding.view

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import ru.endroad.component.common.BaseFragment
import ru.endroad.hakaton.feature.onboarding.R
import ru.endroad.hakaton.feature.onboarding.entity.Button
import ru.endroad.hakaton.feature.onboarding.entity.Comics
import ru.endroad.hakaton.feature.onboarding.entity.Listing
import ru.endroad.hakaton.feature.onboarding.view.adapter.ListingAdapter

class OnboardingFragment : BaseFragment() {

	override val layout = R.layout.onboarding_fragment

	private val adapter = ListingAdapter(
		onButtonClickListener = {},
		onComicsClickListener = {},
	)

	@ExperimentalStdlibApi
	override fun setupViewComponents(parent: View) {
		parent.findViewById<RecyclerView>(R.id.list).adapter = adapter

		adapter.items = getItemList()
	}

	@ExperimentalStdlibApi
	private fun getItemList(): List<Listing> =
		buildList {

			add(Button.COMICS.let(Listing::CategoryItem))
			addAll(Comics.values().map(Listing::PointItem))

			add(Button.AUDIOGID.let(Listing::CategoryItem))
			add(Button.ROUTES.let(Listing::CategoryItem))
			add(Button.MAP.let(Listing::CategoryItem))
		}
}