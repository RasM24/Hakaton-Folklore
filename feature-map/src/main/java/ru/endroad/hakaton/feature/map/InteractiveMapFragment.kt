package ru.endroad.hakaton.feature.map

import android.view.View
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.SupportMapFragment
import ru.endroad.component.common.BaseFragment
import ru.endroad.hakaton.feature.extension.addSpot
import ru.endroad.hakaton.feature.extension.checkLocationProvidesEnabled
import ru.endroad.hakaton.feature.extension.enableUserLocation
import ru.endroad.hakaton.feature.extension.handleLocationPermissions
import ru.endroad.hakaton.feature.extension.isGrantedLocationPermissions
import ru.endroad.hakaton.feature.extension.prepareMarkerClickListener
import ru.endroad.hakaton.feature.extension.requestLocationPermissions
import ru.endroad.hakaton.feature.extension.setOnBubbleClickListener
import ru.endroad.hakaton.feature.extension.setupDefaultCameraPosition
import ru.endroad.hakaton.shared.spot.data.SpotDataSource

internal class InteractiveMapFragment : BaseFragment() {

	override val layout = R.layout.fragment_interactive_map

	private lateinit var gMap: GoogleMap

	private val spotDataSource = SpotDataSource()

	override fun setupViewComponents(parent: View) {
		(childFragmentManager.findFragmentById(R.id.map) as? SupportMapFragment)
			?.getMapAsync(::onMapReady)
	}

	private fun onMapReady(googleMap: GoogleMap) {
		gMap = googleMap

		googleMap.uiSettings.isMapToolbarEnabled = true
		googleMap.checkPermission()
		googleMap.setupDefaultCameraPosition()

		googleMap.prepareMarkerClickListener()
		googleMap.setOnBubbleClickListener { }

		googleMap.addSpot(requireContext(), spotDataSource.getParkingList().first())
		googleMap.addSpot(requireContext(), spotDataSource.getSightList().first())
		googleMap.addSpot(requireContext(), spotDataSource.getPhotoSpotList().first())
		googleMap.addSpot(requireContext(), spotDataSource.getToiletList().first())
	}

	private fun GoogleMap.checkPermission() {
		requireContext().checkLocationProvidesEnabled()
		if (isGrantedLocationPermissions()) {
			enableUserLocation()
		} else {
			requestLocationPermissions()
		}
	}

	override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<String>, grantResults: IntArray) {
		handleLocationPermissions(requestCode) { gMap.enableUserLocation() }
	}
}