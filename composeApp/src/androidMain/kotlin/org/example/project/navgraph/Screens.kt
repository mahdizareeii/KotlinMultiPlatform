package org.example.project.navgraph

sealed class Screens(
    val title: String,
    val route: String
) {
    data object ProductsScreen : Screens("Specific Ui", "products_route")
    data object ProductView : Screens("Product View", "product_view")
    data object SharedScreen : Screens("Shared Ui", "shared_route")
}