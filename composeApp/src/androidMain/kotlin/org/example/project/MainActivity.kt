package org.example.project

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import org.example.project.component.HomeBottomNavigation
import org.example.project.navgraph.AppNavGraph
import org.example.project.screen.productslist.ProductsScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            val navController = rememberNavController()
            Scaffold(
                bottomBar = {
                    HomeBottomNavigation(navController = navController)
                },
                topBar = {},
                content = { innerPadding ->
                    AppNavGraph(
                        modifier = Modifier.padding(innerPadding),
                        navController = navController
                    )
                }
            )
        }
    }
}

@Preview
@Composable
fun AppAndroidPreview() {
    ProductsScreen(navController = rememberNavController())
}