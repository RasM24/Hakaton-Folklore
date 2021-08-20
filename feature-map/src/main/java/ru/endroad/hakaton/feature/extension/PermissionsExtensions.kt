package ru.endroad.hakaton.feature.extension

import android.Manifest
import android.app.Activity
import android.content.Context
import androidx.core.app.ActivityCompat
import androidx.core.content.PermissionChecker
import androidx.core.content.PermissionChecker.checkSelfPermission
import androidx.fragment.app.Fragment

private val locationPermissions = arrayOf(Manifest.permission.ACCESS_COARSE_LOCATION, Manifest.permission.ACCESS_FINE_LOCATION)
private const val LOCATION_PERMISSION_REQUEST_CODE = 85

@Deprecated("Необходимо создать PermissionsManager")
fun Activity.requestLocationPermissions() {
	ActivityCompat.requestPermissions(this, locationPermissions, LOCATION_PERMISSION_REQUEST_CODE)
}

@Deprecated("Необходимо создать PermissionsManager")
fun Context.isGrantedLocationPermissions(): Boolean =
	locationPermissions.all(::isGranted)

private fun Context.isGranted(permission: String): Boolean =
	ActivityCompat.checkSelfPermission(this, permission) == PermissionChecker.PERMISSION_GRANTED

@Deprecated("Необходимо создать PermissionsManager")
fun Context.handleLocationPermissions(requestCode: Int, onGrantedPermission: () -> Unit) {
	if (requestCode == LOCATION_PERMISSION_REQUEST_CODE && isGrantedLocationPermissions()) onGrantedPermission()
}

@Deprecated("Необходимо создать PermissionsManager")
fun Fragment.requestLocationPermissions() {
	requestPermissions(locationPermissions, LOCATION_PERMISSION_REQUEST_CODE)
}

@Deprecated("Необходимо создать PermissionsManager")
fun Fragment.isGrantedLocationPermissions(): Boolean =
	locationPermissions.all(::isGranted)

private fun Fragment.isGranted(permission: String): Boolean =
	checkSelfPermission(requireContext(), permission) == PermissionChecker.PERMISSION_GRANTED

@Deprecated("Необходимо создать PermissionsManager")
fun Fragment.handleLocationPermissions(requestCode: Int, onGrantedPermission: () -> Unit) {
	if (requestCode == LOCATION_PERMISSION_REQUEST_CODE && isGrantedLocationPermissions()) onGrantedPermission()
}