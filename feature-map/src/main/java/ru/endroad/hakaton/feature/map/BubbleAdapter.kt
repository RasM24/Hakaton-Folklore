package ru.endroad.hakaton.feature.map

import android.content.Context
import android.view.View
import android.widget.TextView
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.model.Marker
import ru.endroad.component.common.inflate
import ru.endroad.hakaton.shared.spot.entity.Spot
import ru.endroad.hakaton.shared.spot.remote.RemoteSpot

class BubbleAdapter(context: Context) : GoogleMap.InfoWindowAdapter {

	private val itemView: View = context.inflate(R.layout.map_bubble)

	override fun getInfoWindow(marker: Marker): View {
		(marker.tag as? Spot)?.let {
			itemView.findViewById<TextView>(R.id.bubble_name).setText(it.name.id)
		}

		(marker.tag as? RemoteSpot)?.let {
			itemView.findViewById<TextView>(R.id.bubble_name).text = it.name
		}

		return itemView
	}

	override fun getInfoContents(marker: Marker): View? = null
}