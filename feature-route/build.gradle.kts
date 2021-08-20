plugins {
	id("android-library-convection")
}

dependencies {
	implementation(project(":component-common"))
	implementation(project(":component-navigation"))
	implementation(project(":shared-spot"))
	implementation(project(":shared-route"))

	implementation(AndroidX.appcompat)
	implementation(AndroidX.material)
}