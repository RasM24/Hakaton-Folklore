plugins {
	id("android-application-convection")
}

dependencies {
	implementation(project(":feature-map"))
	implementation(project(":feature-interactive"))
	implementation(project(":component-deeplink"))
	implementation(project(":component-navigation"))

	implementation(AndroidX.core)
	implementation(AndroidX.appcompat)
	implementation(AndroidX.material)

	implementation(Koin.core)
	implementation(Koin.android)
}