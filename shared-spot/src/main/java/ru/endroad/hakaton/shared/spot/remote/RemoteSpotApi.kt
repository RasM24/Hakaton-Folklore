package ru.endroad.hakaton.shared.spot.remote

interface RemoteSpotApi {

	suspend fun getSpot(): List<RemoteSpotModel>?
}