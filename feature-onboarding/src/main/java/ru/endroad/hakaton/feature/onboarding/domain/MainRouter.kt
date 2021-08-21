package ru.endroad.hakaton.feature.onboarding.domain

import ru.endroad.hakaton.feature.onboarding.entity.Comics

interface MainRouter {

	fun openMap()
	fun openComics(comics: Comics)
	fun openRoutes()
	fun openAudiogid()
}