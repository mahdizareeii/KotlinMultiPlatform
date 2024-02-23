package domain.usecase

import domain.usecase.products.GetProductsUseCase
import org.koin.dsl.module

val useCaseModule = module {
    factory {
        GetProductsUseCase(
            repository = get()
        )
    }
}