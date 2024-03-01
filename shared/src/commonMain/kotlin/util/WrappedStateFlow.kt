package util

import io.ktor.utils.io.core.Closeable
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.cancel
import kotlinx.coroutines.flow.*

//https://github.com/adeo-opensource/kviewmodel--mpp/blob/22b994b532da76024ff9c20d0771a32a7c810afc/kviewmodel/src/commonMain/kotlin/com/adeo/kviewmodel/Flow%2BWrappers.kt

public class WrappedStateFlow<T : Any>(private val origin: StateFlow<T>) : StateFlow<T> by origin {
    public fun watch(block: (T) -> Unit): Closeable = watchFlow(block)
}

public class WrappedSharedFlow<T : Any?>(private val origin: SharedFlow<T>) : SharedFlow<T> by origin {
    public fun watch(block: (T) -> Unit): Closeable = watchFlow(block)
}

private fun <T> Flow<T>.watchFlow(block: (T) -> Unit): Closeable {
    val context = CoroutineScope(SupervisorJob() + Dispatchers.Main)
    onEach(block).launchIn(context)

    return object : Closeable {
        override fun close() {
            context.cancel()
        }
    }
}