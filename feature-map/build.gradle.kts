plugins {
	id("android-library-convection")
}

dependencies {
	implementation(project(":component-common"))
	implementation(project(":component-navigation"))
	implementation(project(":shared-spot"))
	//TODO избавиться от зависимости
	implementation(project(":feature-interactive"))

	implementation(AndroidX.core)
	implementation(AndroidX.appcompat)
	implementation(AndroidX.material)
	implementation(GoogleServices.maps)

	implementation(Koin.core)
	implementation(Koin.android)
}