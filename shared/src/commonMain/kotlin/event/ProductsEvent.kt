package event

import navigationargs.ProductViewArgs

sealed class ProductsEvent {
    data object Initial : ProductsEvent()
    data class NavigateToProductViewScreen(val args: ProductViewArgs) : ProductsEvent()
}