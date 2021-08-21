package ru.endroad.hakaton.feature.onboarding.view

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import org.koin.android.ext.android.inject
import ru.endroad.component.common.BaseFragment
import ru.endroad.component.common.showToast
import ru.endroad.hakaton.feature.onboarding.R
import ru.endroad.hakaton.feature.onboarding.domain.MainRouter
import ru.endroad.hakaton.feature.onboarding.entity.Button
import ru.endroad.hakaton.feature.onboarding.entity.Comics
import ru.endroad.hakaton.feature.onboarding.entity.Listing
import ru.endroad.hakaton.feature.onboarding.view.adapter.ListingAdapter

class OnboardingFragment : BaseFragment() {

	override val layout = R.layout.onboarding_fragment

	private val router: MainRouter by inject()

	private val adapter = ListingAdapter(
		onButtonClickListener = ::openNextScreen,
		onComicsClickListener = router::openComics,
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

	private fun openNextScreen(button: Button) {
		when (button) {
			Button.COMICS   -> requireContext().showToast("Выберите интересующий комикс")
			Button.AUDIOGID -> router.openAudiogid()
			Button.ROUTES   -> router.openRoutes()
			Button.MAP      -> router.openMap()
		}
	}
}