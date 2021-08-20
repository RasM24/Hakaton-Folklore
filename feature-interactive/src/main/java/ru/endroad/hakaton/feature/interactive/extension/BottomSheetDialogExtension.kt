package ru.endroad.hakaton.feature.interactive.extension

import android.view.View
import android.widget.FrameLayout
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetDialog

fun BottomSheetDialog.disableDraggingHack() {
	setOnShowListener {
		val bottomSheet = (it as BottomSheetDialog).findViewById<View>(com.google.android.material.R.id.design_bottom_sheet) as FrameLayout?
		val behavior = BottomSheetBehavior.from(bottomSheet!!)
		behavior.state = BottomSheetBehavior.STATE_EXPANDED

		behavior.setBottomSheetCallback(object : BottomSheetBehavior.BottomSheetCallback() {
			override fun onStateChanged(bottomSheet: View, newState: Int) {
				if (newState == BottomSheetBehavior.STATE_DRAGGING) {
					behavior.state = BottomSheetBehavior.STATE_EXPANDED
				}
			}

			override fun onSlide(bottomSheet: View, slideOffset: Float) {}
		})
	}
}

