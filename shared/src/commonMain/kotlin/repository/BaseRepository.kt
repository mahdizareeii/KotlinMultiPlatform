package repository

import kotlinx.coroutines.CoroutineDispatcher

abstract class BaseRepository(protected val dispatcher: CoroutineDispatcher) {

    protected inline fun <reified T> toResult(result: T?): Result<T> {
        return if (result == null)
            Result.failure(Throwable("data is null"))
        else
            Result.success(result)
    }
}