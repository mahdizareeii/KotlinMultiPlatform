package org.example.project.navgraph

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import navigationargs.ProductViewArgs
import org.example.project.screen.productview.ProductViewScreen
import org.example.project.screen.productslist.ProductsScreen
import sharedscreen.ShareCockScreen

@Composable
fun AppNavGraph(
    modifier: Modifier,
    navController: NavHostController
) {
    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = Screens.ProductsScreen.route
    ) {
        composable(Screens.ProductsScreen.route) {
            ProductsScreen(navController = navController)
        }

        composable(Screens.SharedScreen.route) {
            ShareCockScreen()
        }

        composable(Screens.ProductView.route) {
            ProductViewScreen(navController = navController)
        }
    }
}