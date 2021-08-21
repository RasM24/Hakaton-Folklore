package ru.endroad.hakaton.shared.spot.remote

class RemoteSpotModel(
	val id: Long,
	val create_date: Long,
	val name: String,
	val type: String,
	val description: String,
	val documents: String,
	val informant: String,
	val municipality_id: Long,
	val audio_guide_id: Long,
	val lat: Double,
	val long: Double,
	val municipality: String,
)