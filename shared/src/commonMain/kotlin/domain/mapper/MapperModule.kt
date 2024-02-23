package domain.mapper

import domain.mapper.products.ProductsSectionMapper
import org.koin.dsl.module

val mapperModule = module {
    factory { ProductsSectionMapper() }
}