plugins {
	id("android-library-convection")
}

dependencies {
	implementation(project(":component-common"))
	implementation(project(":component-navigation"))

	implementation(AndroidX.core)
	implementation(AndroidX.appcompat)
	implementation(AndroidX.material)
}