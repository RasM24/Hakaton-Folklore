package ru.endroad.hakaton.folklore.application

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import ru.endroad.hakaton.folklore.navigation.di.moduleNavigation
import ru.endroad.hakaton.folklore.navigation.di.moduleRouters

class App : Application() {

	override fun onCreate() {
		super.onCreate()

		startKoin {
			androidContext(this@App)
			modules(
				moduleNavigation,
				moduleRouters,
			)
		}
	}
}