package org.example.project.screen.productslist

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import event.ProductEvent
import kotlinx.coroutines.flow.SharedFlow
import org.example.project.composeutil.collectAsEffect
import org.example.project.navgraph.Screens

@Composable
fun ListenToProductsEvents(
    event: SharedFlow<ProductEvent>,
    navController: NavController
) {
    event.collectAsEffect {
        when (it) {
            is ProductEvent.Initial -> {}
            is ProductEvent.NavigateToProductViewScreen -> {
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