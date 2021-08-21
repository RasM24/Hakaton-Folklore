package ru.endroad.hakaton.feature.onboarding.view

import android.animation.Animator
import android.animation.AnimatorListenerAdapter
import android.view.View
import android.widget.ImageView
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import org.koin.android.ext.android.inject
import ru.endroad.component.common.BaseFragment
import ru.endroad.component.common.showToast
import ru.endroad.hakaton.feature.onboarding.R
import ru.endroad.hakaton.feature.onboarding.domain.MainRouter
import ru.endroad.hakaton.feature.onboarding.entity.Button
import ru.endroad.hakaton.feature.onboarding.entity.Listing
import ru.endroad.hakaton.feature.onboarding.view.adapter.ListingAdapter
import ru.endroad.hakaton.shared.spot.entity.Comics

class OnboardingFragment : BaseFragment() {

	override val layout = R.layout.onboarding_fragment

	private val router: MainRouter by inject()

	private val adapter = ListingAdapter(
		onButtonClickListener = ::openNextScreen,
		onComicsClickListener = router::openComics,
	)

	@ExperimentalStdlibApi
	override fun setupViewComponents(parent: View) {
		setupPanekelka(parent)
		parent.findViewById<RecyclerView>(R.id.list).adapter = adapter

		adapter.items = getItemList()
	}

	private fun setupPanekelka(parent: View) {
		val panekelka = parent.findViewById<ImageView>(R.id.panekelka)

		panekelka.isVisible = panekelkaAvailable

		panekelka.setOnClickListener {
			it.animate()
				.translationY(0f)
				.alpha(0.0f)
				.setListener(object : AnimatorListenerAdapter() {
					override fun onAnimationEnd(animation: Animator) {
						super.onAnimationEnd(animation)
						panekelkaAvailable = false
						panekelka.isVisible = panekelkaAvailable
					}
				})
		}

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