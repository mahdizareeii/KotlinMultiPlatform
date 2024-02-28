package event

import navigationargs.ProductViewArgs

sealed class ProductEvent {
    data object Initial : ProductEvent()
    data class NavigateToProductViewScreen(val args: ProductViewArgs) : ProductEvent()
}