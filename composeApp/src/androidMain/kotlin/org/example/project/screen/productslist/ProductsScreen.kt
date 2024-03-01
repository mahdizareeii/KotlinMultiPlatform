package org.example.project.screen.productslist

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import componentdata.products.ProductComponentData
import navigationargs.ProductViewArgs
import org.example.project.component.products.ProductComponent
import org.koin.androidx.compose.getViewModel
import state.BaseUiState
import viewmodel.ProductsViewModel

@Composable
fun ProductsScreen(
    modifier: Modifier = Modifier,
    viewModel: ProductsViewModel = getViewModel(),
    navController: NavController
) {
    val uiState by viewModel.uiState.collectAsState()
    LazyColumn(
        modifier = modifier.fillMaxSize()
    ) {
        when (val state = uiState) {
            is BaseUiState.InitialUiState<*> -> {}
            is BaseUiState.EmptyUiState<*> -> item { Text(text = "empty") }
            is BaseUiState.ErrorUiState<*> -> item {
                Text(
                    modifier = Modifier.clickable { state.onTryAgainClicked.invoke() },
                    text = "Try Again \n" + state.throwable.message.toString()
                )
            }

            is BaseUiState.LoadingUiState<*> -> {
                item { ProductsSkeleton() }
            }

            is BaseUiState.SuccessUiState -> items(state.state.products) {
                when (it) {
                    is ProductComponentData -> ProductComponent(
                        modifier = Modifier
                            .clickable {
                                viewModel.onProductComponentClicked(
                                    ProductViewArgs(
                                        _id = it.id,
                                        _title = it.title,
                                        _desc = it.desc,
                                        _image = it.image
                                    )
                                )
                            }
                            .padding(horizontal = 8.dp, vertical = 4.dp),
                        data = it
                    )

                    else -> {}
                }
            }
        }
    }

    ListenToProductsEvents(viewModel.events, navController)
}