package viewmodel

import com.rickclephas.kmm.viewmodel.coroutineScope
import domain.mapper.products.ProductsSectionMapper
import domain.usecase.products.GetProductsUseCase
import event.ProductsEvent
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import navigationargs.ProductViewArgs
import state.BaseUiState
import state.ProductsUiState
import util.Switch

open class ProductsViewModel(
    private val getProductsUseCase: GetProductsUseCase,
    private val productsSectionMapper: ProductsSectionMapper
) : BaseViewModel<ProductsUiState, ProductsEvent>() {
    init {
        getProducts()
    }

    private fun getProducts() {
        viewModelScope.coroutineScope.launch {
            _uiState.update { BaseUiState.LoadingUiState<ProductsUiState>() }
            try {
                getProductsUseCase.invoke(Unit).getOrThrow().also { result ->
                    _uiState.update {
                        BaseUiState.SuccessUiState(
                            ProductsUiState(
                                initData = Switch(true, false),
                                products = productsSectionMapper.map(result)
                            )
                        )
                    }
                }
            } catch (e: Exception) {
                _uiState.update { BaseUiState.ErrorUiState<ProductsUiState>(e) { getProducts() } }
            }

        }
    }

    fun onProductComponentClicked(data: ProductViewArgs) {
        viewModelScope.coroutineScope.launch {
            _events.emit(ProductsEvent.NavigateToProductViewScreen(data))
        }
    }
}