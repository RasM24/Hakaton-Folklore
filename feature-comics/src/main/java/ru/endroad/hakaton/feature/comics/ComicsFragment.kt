package ru.endroad.hakaton.feature.comics

import android.view.View
import android.widget.ImageView
import androidx.fragment.app.Fragment
import org.koin.android.ext.android.inject
import ru.endroad.component.common.BaseFragment
import ru.endroad.component.common.withArguments
import ru.endroad.hakaton.shared.spot.entity.Comics

class ComicsFragment : BaseFragment() {

	companion object {

		private const val COMICS = "comics"

		fun newInstance(comics: Comics): Fragment =
			ComicsFragment().withArguments(
				COMICS to comics
			)
	}

	override val layout = R.layout.comics_comics_bleat_fragment

	private val router: ComicsRouter by inject()

	private val comics: Comics by lazy {
		val comicsData = arguments?.getSerializable(COMICS) as? Comics
		requireNotNull(comicsData)
	}

	override fun setupViewComponents(parent: View) {
		val image = parent.findViewById<ImageView>(R.id.comics)
		val comicsId = comics.image.id
		image.setImageResource(comicsId)

		parent.findViewById<ImageView>(R.id.map).setOnClickListener { router.openMap(comics.position) }
	}
}