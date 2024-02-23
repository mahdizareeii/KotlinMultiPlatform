package domain.usecase

import repository.BaseRepository

abstract class BaseUseCase<Repository : BaseRepository, in REQUEST_DOMAIN, out RESPONSE_DOMAIN>(
    protected val repository: Repository
) {
    abstract suspend fun invoke(request: REQUEST_DOMAIN): Result<RESPONSE_DOMAIN>
}