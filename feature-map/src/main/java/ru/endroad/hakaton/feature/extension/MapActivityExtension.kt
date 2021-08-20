package ru.endroad.hakaton.feature.extension

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Bitmap
import android.graphics.Canvas
import android.location.LocationManager
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.model.BitmapDescriptor
import com.google.android.gms.maps.model.BitmapDescriptorFactory
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.Marker
import com.google.android.gms.maps.model.MarkerOptions
import ru.endroad.hakaton.shared.spot.entity.Position
import ru.endroad.hakaton.shared.spot.entity.Spot

val KRASNOYARSK_OVERALL_LATLNG = LatLng(56.009824, 92.873895)
const val MAP_ZOOM_OVERALL = 12.573985f
const val MAP_ZOOM_SPOT = 14.104337f
internal val Position.latLng: LatLng get() = LatLng(latitude, longitude)

@SuppressLint("MissingPermission")
internal fun GoogleMap.enableUserLocation() {
	isMyLocationEnabled = true
}

internal fun GoogleMap.prepareMarkerClickListener() {
	setOnMarkerClickListener {
		expandMarker(it)
		true
	}
}

internal fun GoogleMap.expandMarker(marker: Marker) {
	animateCamera(CameraUpdateFactory.newLatLngZoom(marker.position, MAP_ZOOM_SPOT))
	marker.showInfoWindow()
}

internal fun GoogleMap.setOnBubbleClickListener(onClickListener: (Spot) -> Unit) {
	setOnInfoWindowClickListener { (it.tag as? Spot)?.let { spot -> onClickListener(spot) } }
}

internal fun GoogleMap.setupDefaultCameraPosition() {
	moveCamera(CameraUpdateFactory.newLatLngZoom(KRASNOYARSK_OVERALL_LATLNG, MAP_ZOOM_OVERALL))
}

@Deprecated("Необходим рефактор логики")
internal fun Context.checkLocationProvidesEnabled() {
	val isGPSEnabled = (getSystemService(AppCompatActivity.LOCATION_SERVICE) as LocationManager).isProviderEnabled(LocationManager.GPS_PROVIDER)

	if (!isGPSEnabled) Toast.makeText(this, "Включите GPS", Toast.LENGTH_LONG).show()
}

internal fun GoogleMap.addSpot(context: Context, spot: Spot) {
	val markerIcon = context.bitmapFromVector(spot.icon.id)

	MarkerOptions().apply {
		position(spot.position.latLng)
		icon(markerIcon)
	}
		.let(::addMarker)
		.apply { tag = spot }
}

@Deprecated("Плохо работает при большом количестве маркеров")
internal fun Context.bitmapFromVector(vectorResId: Int): BitmapDescriptor? =
	ContextCompat.getDrawable(this, vectorResId)?.run {
		setBounds(0, 0, intrinsicWidth, intrinsicHeight)
		val bitmap = Bitmap.createBitmap(intrinsicWidth, intrinsicHeight, Bitmap.Config.ARGB_8888)
		draw(Canvas(bitmap))
		BitmapDescriptorFactory.fromBitmap(bitmap)
	}
