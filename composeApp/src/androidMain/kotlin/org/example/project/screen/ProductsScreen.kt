package org.example.project.screen

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import componentdata.products.ProductComponentData
import org.example.project.component.products.ProductComponent
import org.koin.androidx.compose.getViewModel
import state.BaseUiState
import viewmodel.ProductsViewModel

@Composable
fun ProductsScreen(
    modifier: Modifier = Modifier,
    viewModel: ProductsViewModel = getViewModel()
) {
    val uiState by viewModel.uiState.collectAsState()
    LazyColumn(
        modifier = modifier
    ) {
        when (val state = uiState) {
            is BaseUiState.InitialUiState -> {}
            is BaseUiState.EmptyUiState -> item { Text(text = "empty") }
            is BaseUiState.ErrorUiState -> item { Text(text = state.throwable.message.toString()) }
            is BaseUiState.LoadingUiState -> {
                item { Text(text = "Loading") }
            }

            is BaseUiState.SuccessUiState -> items(state.state.products) {
                when (it) {
                    is ProductComponentData -> ProductComponent(
                        modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp),
                        data = it
                    )

                    else -> {}
                }
            }
        }
    }

}