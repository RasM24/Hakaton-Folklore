package ru.endroad.hakaton.feature.onboarding.entity

import ru.endroad.hakaton.feature.onboarding.R
import ru.endroad.hakaton.shared.spot.entity.Comics
import ru.endroad.hakaton.shared.spot.entity.Image

sealed class Listing {
	data class CategoryItem(val button: Button) : Listing()
	data class PointItem(val comics: Comics) : Listing()
}

enum class Button(val icon: Image, val title: String) {
	COMICS(Image(R.drawable.ic_button_comics), "Комиксы"),
	AUDIOGID(Image(R.drawable.ic_button_audiogid), "Аудиогид"),
	ROUTES(Image(R.drawable.ic_button_routes), "Маршруты"),
	MAP(Image(R.drawable.ic_button_map), "На карту"),
}