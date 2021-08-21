plugins {
	id("android-application-convection")
}

dependencies {
	implementation(project(":feature-map"))
	implementation(project(":feature-interactive"))
	implementation(project(":feature-route"))
	implementation(project(":widget-panorama"))
	implementation(project(":component-deeplink"))
	implementation(project(":component-navigation"))
	implementation(project(":shared-spot"))

	implementation(AndroidX.core)
	implementation(AndroidX.appcompat)
	implementation(AndroidX.material)

	implementation(Koin.core)
	implementation(Koin.android)
}