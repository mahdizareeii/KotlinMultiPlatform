package org.example.project.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import componentdata.products.ProductComponentData
import org.example.project.component.products.ProductComponent
import org.example.project.composeutil.shimmerBrush
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
        modifier = modifier.fillMaxSize()
    ) {
        when (val state = uiState) {
            is BaseUiState.InitialUiState -> {}
            is BaseUiState.EmptyUiState -> item { Text(text = "empty") }
            is BaseUiState.ErrorUiState -> item { Text(text = state.throwable.message.toString()) }
            is BaseUiState.LoadingUiState -> { item { ProductsSkeleton() } }
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

@Composable
fun ProductsSkeleton() {
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        repeat(10) {
            Box(
                modifier = Modifier
                    .padding(vertical = 4.dp, horizontal = 8.dp)
                    .background(
                        brush = shimmerBrush(targetValue = 1300f),
                        shape = RoundedCornerShape(4.dp)
                    )
                    .fillMaxWidth()
                    .height(100.dp)
            )
        }
    }
}