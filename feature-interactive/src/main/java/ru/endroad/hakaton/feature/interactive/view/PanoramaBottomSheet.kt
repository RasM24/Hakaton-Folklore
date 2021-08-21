package ru.endroad.hakaton.feature.interactive.view

import android.app.Dialog
import android.os.Bundle
import android.view.View
import android.widget.TextView
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import ru.endroad.component.common.BaseBottomSheetFragment
import ru.endroad.component.common.withArguments
import ru.endroad.hakaton.feature.interactive.R
import ru.endroad.hakaton.feature.interactive.extension.disableDraggingHack
import ru.endroad.hakaton.feature.interactive.extension.textures
import ru.endroad.hakaton.shared.spot.entity.PanoramaPhotoSpot
import ru.endroad.widget.panorama.PanoramaView

class PanoramaBottomSheet : BaseBottomSheetFragment() {

	companion object {

		private const val PANORAMA_IMAGE = "panoramaImage"

		fun newInstance(panoramaSpot: PanoramaPhotoSpot): BottomSheetDialogFragment =
			PanoramaBottomSheet().withArguments(
				PANORAMA_IMAGE to panoramaSpot
			)
	}

	private val panoramaImage: PanoramaPhotoSpot by lazy {
		val panoramaImage = arguments?.getSerializable(PANORAMA_IMAGE) as? PanoramaPhotoSpot
		requireNotNull(panoramaImage)
	}

	override val layout = R.layout.panorama_fragment

	override fun setupViewComponents(parent: View) {
		parent.findViewById<TextView>(R.id.name).setText(panoramaImage.name.id)
		parent.findViewById<PanoramaView>(R.id.panorama).start(this, panoramaImage.textures)
	}

	override fun onCreateDialog(savedInstanceState: Bundle?): Dialog =
		(super.onCreateDialog(savedInstanceState) as BottomSheetDialog)
			.apply { disableDraggingHack() }
}