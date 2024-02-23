package domain.mapper.products

import domain.mapper.BaseMapper
import domain.model.products.ProductResponseDomain
import componentdata.BaseComponentData
import componentdata.products.ProductComponentData

class ProductsSectionMapper : BaseMapper<List<ProductResponseDomain>, List<BaseComponentData>> {
    override suspend fun map(from: List<ProductResponseDomain>): List<BaseComponentData> {
        return from.map {
            ProductComponentData(
                image = it.image,
                title = it.title,
                description = it.description + "\n${it.publishedDate} + \n${it.platforms}"
            )
        }
    }
}