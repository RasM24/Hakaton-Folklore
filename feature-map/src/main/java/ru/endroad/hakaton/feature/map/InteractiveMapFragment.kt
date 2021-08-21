package ru.endroad.hakaton.feature.map

import android.view.View
import android.widget.Button
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.SupportMapFragment
import org.koin.android.ext.android.inject
import ru.endroad.component.common.BaseFragment
import ru.endroad.hakaton.feature.domain.MapRouter
import ru.endroad.hakaton.feature.extension.addRemoteSpot
import ru.endroad.hakaton.feature.extension.addSpot
import ru.endroad.hakaton.feature.extension.checkLocationProvidesEnabled
import ru.endroad.hakaton.feature.extension.drawRoute
import ru.endroad.hakaton.feature.extension.enableUserLocation
import ru.endroad.hakaton.feature.extension.handleLocationPermissions
import ru.endroad.hakaton.feature.extension.isGrantedLocationPermissions
import ru.endroad.hakaton.feature.extension.prepareBubbleAdapter
import ru.endroad.hakaton.feature.extension.prepareMarkerClickListener
import ru.endroad.hakaton.feature.extension.requestLocationPermissions
import ru.endroad.hakaton.feature.extension.setOnBubbleClickListener
import ru.endroad.hakaton.feature.extension.setupDefaultCameraPosition
import ru.endroad.hakaton.shared.route.data.russaRoute
import ru.endroad.hakaton.shared.spot.data.SpotDataSource
import ru.endroad.hakaton.shared.spot.entity.ComicsSpot
import ru.endroad.hakaton.shared.spot.entity.PanoramaPhotoSpot
import ru.endroad.hakaton.shared.spot.entity.AudioSpot
import ru.endroad.hakaton.shared.spot.entity.Spot
import ru.endroad.hakaton.shared.spot.remote.RemoteDataSource

internal class InteractiveMapFragment : BaseFragment() {

	override val layout = R.layout.fragment_interactive_map

	private lateinit var gMap: GoogleMap

	private val spotDataSource = SpotDataSource()
	private val remoteDataSource = RemoteDataSource()
	private val router: MapRouter by inject()

	override fun setupViewComponents(parent: View) {
		(childFragmentManager.findFragmentById(R.id.map) as? SupportMapFragment)
			?.getMapAsync(::onMapReady)
	}

	private fun onMapReady(googleMap: GoogleMap) {
		gMap = googleMap

		googleMap.uiSettings.isMapToolbarEnabled = true
		googleMap.checkPermission()
		googleMap.setupDefaultCameraPosition()

//		googleMap.drawRoute(russaRoute)
		googleMap.prepareMarkerClickListener(::markerClickHandler)
		googleMap.prepareBubbleAdapter(requireContext())
		googleMap.setOnBubbleClickListener { }

		remoteDataSource.getSpotList().forEach { googleMap.addRemoteSpot(requireContext(), it) }
		spotDataSource.getAudioList().forEach { googleMap.addSpot(requireContext(), it) }
		spotDataSource.getComics().forEach { googleMap.addSpot(requireContext(), it) }
		spotDataSource.getPhotoSpotList().forEach { googleMap.addSpot(requireContext(), it) }
	}

	private fun markerClickHandler(spot: Spot) {
		when (spot) {
			is PanoramaPhotoSpot -> router.openPanoramaBottomSheet(spot)
			is AudioSpot         -> router.openAudiogidBottomSheet()
			is ComicsSpot        -> router.openComicsBottomSheet(spot)
		}
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