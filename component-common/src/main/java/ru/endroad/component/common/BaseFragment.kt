package ru.endroad.component.common

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment

abstract class BaseFragment : Fragment() {

	abstract val layout: Int

	override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
		super.onViewCreated(view, savedInstanceState)
		setupViewComponents(view)
	}

	protected open fun setupViewComponents(parent: View) = Unit

	override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View =
		inflater.inflate(layout, container, false)

	protected fun setToolbarText(text: CharSequence) {
		activity?.title = text
	}
}