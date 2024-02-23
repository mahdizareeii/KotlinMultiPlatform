package domain.mapper.products

import domain.mapper.BaseMapper
import domain.model.products.ProductResponseDomain
import uidata.BaseUiData
import uidata.products.ProductUiData

class ProductsSectionMapper : BaseMapper<List<ProductResponseDomain>, List<BaseUiData>> {
    override suspend fun map(from: List<ProductResponseDomain>): List<BaseUiData> {
        return from.map {
            ProductUiData(
                image = it.image,
                title = it.title,
                description = it.description + "\n${it.publishedDate} + \n${it.platforms}"
            )
        }
    }
}