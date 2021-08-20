package ru.endroad.hakaton.feature.interactive.view

import android.app.Dialog
import android.os.Bundle
import android.view.View
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import ru.endroad.component.common.BaseBottomSheetFragment
import ru.endroad.component.common.withArguments
import ru.endroad.hakaton.feature.interactive.R
import ru.endroad.hakaton.feature.interactive.extension.disableDraggingHack
import ru.endroad.widget.panorama.PanoramaView
import ru.endroad.widget.panorama.image.PanoramaImage
import ru.endroad.widget.panorama.image.textures

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

	override fun onCreateDialog(savedInstanceState: Bundle?): Dialog =
		(super.onCreateDialog(savedInstanceState) as BottomSheetDialog)
			.apply { disableDraggingHack() }
}