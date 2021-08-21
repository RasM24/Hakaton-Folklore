package ru.endroad.hakaton.feature.interactive.view

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import ru.endroad.component.common.BaseBottomSheetFragment
import ru.endroad.component.common.withArguments
import ru.endroad.hakaton.feature.interactive.R
import ru.endroad.hakaton.shared.spot.entity.ComicsSpot

class ComicsBottomSheet : BaseBottomSheetFragment() {

	companion object {

		private const val COMICS = "comics"

		fun newInstance(comics: ComicsSpot): BottomSheetDialogFragment =
			ComicsBottomSheet().withArguments(
				COMICS to comics
			)
	}

	private val comics: ComicsSpot by lazy {
		val panoramaImage = arguments?.getSerializable(COMICS) as? ComicsSpot
		requireNotNull(panoramaImage)
	}

	override val layout = R.layout.comics_fragment

	override fun setupViewComponents(parent: View) {
		parent.findViewById<TextView>(R.id.name).setText(comics.name.id)
		parent.findViewById<ImageView>(R.id.image).setImageResource(comics.image.id)
	}
}