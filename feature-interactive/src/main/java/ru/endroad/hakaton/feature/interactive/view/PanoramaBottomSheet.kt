package ru.endroad.hakaton.feature.interactive.view

import android.view.View
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import ru.endroad.component.common.BaseBottomSheetFragment
import ru.endroad.component.common.withArguments
import ru.endroad.hakaton.feature.interactive.R
import ru.endroad.hakaton.feature.interactive.enity.PanoramaImage
import ru.endroad.hakaton.feature.interactive.enity.textures
import ru.endroad.widget.panorama.PanoramaView

class PanoramaBottomSheet : BaseBottomSheetFragment() {

	companion object {

		private const val PANORAMA_IMAGE = "panoramaImage"

		fun newInstance(image: PanoramaImage): BottomSheetDialogFragment =
			PanoramaBottomSheet().withArguments(
				PANORAMA_IMAGE to image
			)
	}

	private val panoramaImage: PanoramaImage by lazy {
		val panoramaImage = arguments?.getSerializable(PANORAMA_IMAGE) as? PanoramaImage
		requireNotNull(panoramaImage)
	}

	override val layout = R.layout.panorama_fragment

	override fun setupViewComponents(parent: View) {

		parent.findViewById<PanoramaView>(R.id.panorama).start(this, panoramaImage.textures)
	}
}