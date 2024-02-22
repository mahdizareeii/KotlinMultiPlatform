package repository

import kotlinx.coroutines.Dispatchers
import org.koin.dsl.bind
import org.koin.dsl.module
import repository.products.ProductRepositoryImpl
import repository.products.ProductsRepository

val repositoryModule = module {
    factory { ProductRepositoryImpl(
        coroutineDispatcher = Dispatchers.Default,
        productsApi = get()
    ) } bind ProductsRepository::class
}