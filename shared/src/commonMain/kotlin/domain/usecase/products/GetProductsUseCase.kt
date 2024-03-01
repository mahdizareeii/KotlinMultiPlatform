package domain.usecase.products

import domain.model.products.ProductResponseDomain
import domain.usecase.BaseUseCase
import repository.products.ProductsRepository

class GetProductsUseCase(
    repository: ProductsRepository
) : BaseUseCase<ProductsRepository, Unit, List<ProductResponseDomain>>(repository) {
    override suspend fun invoke(request: Unit): Result<List<ProductResponseDomain>> {
        val result = repository.getProducts()
        return if (result.isSuccess)
            Result.success(
                result.getOrNull()?.map {
                    ProductResponseDomain(
                        desc = it.description ?: "",
                        endDate = it.endDate ?: "",
                        id = it.id ?: 0,
                        image = it.image ?: "",
                        instructions = it.instructions ?: "",
                        platforms = it.platforms ?: "",
                        publishedDate = it.publishedDate ?: "",
                        status = it.status ?: "",
                        thumbnail = it.thumbnail ?: "",
                        title = it.title ?: "",
                        type = it.type ?: "",
                        users = it.users ?: 0,
                        worth = it.worth ?: ""
                    )
                } ?: listOf()
            )
        else Result.failure(result.exceptionOrNull() ?: Throwable())
    }
}