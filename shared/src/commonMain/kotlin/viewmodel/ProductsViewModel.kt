package viewmodel

import com.rickclephas.kmm.viewmodel.coroutineScope
import domain.mapper.products.ProductsSectionMapper
import domain.usecase.products.GetProductsUseCase
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import state.BaseUiState
import state.ProductsUiState
import util.Switch

class ProductsViewModel(
    private val getProductsUseCase: GetProductsUseCase,
    private val productsSectionMapper: ProductsSectionMapper
) : BaseViewModel<ProductsUiState>() {
    init {
        getProducts()
    }

    private fun getProducts() {
        viewModelScope.coroutineScope.launch {
            _uiState.update { BaseUiState.LoadingUiState() }

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
                _uiState.update { BaseUiState.ErrorUiState(e) }
            }

        }
    }
}