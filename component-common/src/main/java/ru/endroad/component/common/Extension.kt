package ru.endroad.component.common

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment

inline fun <reified F : Fragment> F.withArguments(vararg pairs: Pair<String, Any?>): F {
	arguments = bundleOf(*pairs)
	return this
}

fun ViewGroup.inflate(@LayoutRes layoutRes: Int): View =
	LayoutInflater.from(context).inflate(layoutRes, this, false)