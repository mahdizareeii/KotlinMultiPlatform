package org.example.project.screen.productslist

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import event.ProductsEvent
import kotlinx.coroutines.flow.SharedFlow
import org.example.project.composeutil.collectAsEffect
import org.example.project.navgraph.Screens

@Composable
fun ListenToProductsEvents(
    event: SharedFlow<ProductsEvent>,
    navController: NavController
) {
    event.collectAsEffect {
        when (it) {
            is ProductsEvent.Initial -> {}
            is ProductsEvent.NavigateToProductViewScreen -> {
                navController.apply {
                    currentBackStackEntry?.savedStateHandle?.apply {
                        set("argument", it.args)
                    }
                    navigate(Screens.ProductView.route)
                }
            }
        }
    }
}