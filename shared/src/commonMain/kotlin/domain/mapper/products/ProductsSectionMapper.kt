package domain.mapper.products

import componentdata.BaseComponentData
import componentdata.products.ProductComponentData
import domain.mapper.BaseMapper
import domain.model.products.ProductResponseDomain

class ProductsSectionMapper : BaseMapper<List<ProductResponseDomain>, List<BaseComponentData>> {
    override suspend fun map(from: List<ProductResponseDomain>): List<BaseComponentData> {
        return from.map {
            ProductComponentData(
                id = it.id.toString(),
                image = it.image,
                title = it.title,
                desc = it.desc
            )
        }
    }
}