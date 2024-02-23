package state

import componentdata.BaseComponentData
import util.Switch

data class ProductsUiState(
    val initData: Switch<Boolean> = Switch(false, false),
    val products: List<BaseComponentData> = listOf()
)
