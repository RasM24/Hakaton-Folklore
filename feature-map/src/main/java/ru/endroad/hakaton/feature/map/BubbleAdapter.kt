package ru.endroad.hakaton.feature.map

import android.content.Context
import android.view.View
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.model.Marker
import ru.endroad.component.common.inflate
import ru.endroad.hakaton.shared.spot.entity.Parking
import ru.endroad.hakaton.shared.spot.entity.PhotoSpot
import ru.endroad.hakaton.shared.spot.entity.Sight
import ru.endroad.hakaton.shared.spot.entity.Toilet

class BubbleAdapter(context: Context) : GoogleMap.InfoWindowAdapter {

	private val itemView: View = context.inflate(R.layout.map_bubble)

	override fun getInfoWindow(marker: Marker): View {
		when (val model = marker.tag) {
			is Parking   -> Unit
			is PhotoSpot -> Unit
			is Sight     -> Unit
			is Toilet    -> Unit
		}

		return itemView
	}

	override fun getInfoContents(marker: Marker): View? = null
}