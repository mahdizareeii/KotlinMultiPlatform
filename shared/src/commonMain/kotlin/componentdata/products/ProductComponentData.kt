package componentdata.products

import componentdata.BaseComponentData

data class ProductComponentData(
    val id: String,
    val image: String,
    val title: String,
    val description: String
) : BaseComponentData()