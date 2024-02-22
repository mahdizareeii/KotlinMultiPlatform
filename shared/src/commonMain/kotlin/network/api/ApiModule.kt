package network.api

import network.api.products.ProductsApi
import org.koin.dsl.bind
import org.koin.dsl.module

val apiModule = module {
    factory { ProductsApi(get()) } bind BaseApi::class
}