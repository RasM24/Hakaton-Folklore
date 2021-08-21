package ru.endroad.hakaton.feature.map

import android.content.Context
import android.view.View
import android.widget.TextView
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.model.Marker
import ru.endroad.component.common.inflate
import ru.endroad.hakaton.shared.spot.entity.Spot

class BubbleAdapter(context: Context) : GoogleMap.InfoWindowAdapter {

	private val itemView: View = context.inflate(R.layout.map_bubble)

	override fun getInfoWindow(marker: Marker): View {
		val model = marker.tag as Spot
		itemView.findViewById<TextView>(R.id.bubble_name).setText(model.name.id)
		return itemView
	}

	override fun getInfoContents(marker: Marker): View? = null
}