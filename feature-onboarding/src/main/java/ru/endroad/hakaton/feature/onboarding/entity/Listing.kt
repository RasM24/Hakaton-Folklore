package ru.endroad.hakaton.feature.onboarding.entity

import ru.endroad.hakaton.feature.onboarding.R
import ru.endroad.hakaton.shared.spot.entity.Image

sealed class Listing {
	data class CategoryItem(val button: Button) : Listing()
	data class PointItem(val comics: Comics) : Listing()
}

enum class Button(val icon: Image, val title: String) {
	COMICS(Image(R.drawable.ic_icon_comic), "Комиксы"),
	AUDIOGID(Image(R.drawable.ic_icon_audio), "Аудиогид"),
	ROUTES(Image(R.drawable.ic_icon_parking), "Маршруты"),
	MAP(Image(R.drawable.ic_icon_building), "На карту"),
}

enum class Comics(val title: String) {
	IVAN_GROZNIY("Иван Грозный перестает быть грозным"),
	PARASKEEVA("Параскеева домоседка")
}