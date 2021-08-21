package ru.endroad.hakaton.shared.spot.entity

import ru.endroad.hakaton.shared.spot.R

enum class Comics(val title: String, val image: Image, val position: Position) {
	IVAN_GROZNIY("Иван Грозный перестает быть грозным", Image(R.drawable.comics_ivan), Position(58.1274491, 30.3825126)),
	PARASKEEVA("Параскеева домоседка", Image(R.drawable.comics_icona), Position(58.6125113, 33.6861279))
}