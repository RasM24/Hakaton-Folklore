package ru.endroad.hakaton.feature.onboarding.domain

import ru.endroad.hakaton.shared.spot.entity.Comics

interface MainRouter {

	fun openMap()
	fun openComics(comics: Comics)
	fun openRoutes()
	fun openAudiogid()
}