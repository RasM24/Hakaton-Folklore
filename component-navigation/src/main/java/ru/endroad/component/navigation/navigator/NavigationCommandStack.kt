package ru.endroad.component.navigation.navigator

import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.channels.BufferOverflow
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow

class NavigationCommandStack {

	private val sharedFlow = MutableSharedFlow<RequireNavigationContext>(
		replay = Int.MAX_VALUE,
		extraBufferCapacity = 0,
		onBufferOverflow = BufferOverflow.SUSPEND,
	)

	private val commandFlow: Flow<RequireNavigationContext> = flow {
		sharedFlow.collect {
			sharedFlow.resetReplayCache()
			emit(it)
		}
	}

	fun execute(requireNavigationContext: RequireNavigationContext) {
		sharedFlow.tryEmit(requireNavigationContext)
	}

	//TODO проверить на утечки
	fun registryNavigationContext(activity: AppCompatActivity) {
		activity.lifecycleScope.launchWhenResumed {
			commandFlow.collect { requireActivity ->
				requireActivity(activity, activity.supportFragmentManager)
			}
		}
	}
}