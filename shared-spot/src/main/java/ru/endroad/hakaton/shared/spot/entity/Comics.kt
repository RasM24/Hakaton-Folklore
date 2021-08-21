package ru.endroad.hakaton.shared.spot.entity

import ru.endroad.hakaton.shared.spot.R

enum class Comics(val title: String, val image: Image) {
	IVAN_GROZNIY("Иван Грозный перестает быть грозным", Image(R.drawable.comics_ivan)),
	PARASKEEVA("Параскеева домоседка", Image(R.drawable.comics_icona))
}