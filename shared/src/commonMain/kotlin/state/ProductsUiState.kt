package state

import uidata.BaseUiData
import util.Switch

data class ProductsUiState(
    val initData: Switch<Boolean> = Switch(false, false),
    val products: List<BaseUiData> = listOf()
)
