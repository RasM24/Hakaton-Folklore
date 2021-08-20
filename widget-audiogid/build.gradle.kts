plugins {
	id("android-library-convection")
}

dependencies {
	implementation(AndroidX.lifecycleRuntime)
	implementation(AndroidX.lifecycleViewModel)
	implementation(Coroutine.core)
	implementation(Coroutine.android)
}