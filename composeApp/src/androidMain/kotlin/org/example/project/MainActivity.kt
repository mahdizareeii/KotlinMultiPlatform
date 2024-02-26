package org.example.project

import sharedscreen.TestSharedScreen
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import org.example.project.component.HomeBottomNavigation
import org.example.project.component.HomeBottomNavigationItem
import org.example.project.screen.ProductsScreen
import sharedscreen.ShareCockScreen

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
                    NavHost(
                        modifier = Modifier.padding(innerPadding),
                        navController = navController,
                        startDestination = HomeBottomNavigationItem.ProductsScreen.route
                    ) {
                        composable(HomeBottomNavigationItem.ProductsScreen.route){
                            ProductsScreen()
                        }

                        composable(HomeBottomNavigationItem.SharedScreen.route){
                            ShareCockScreen()
                        }
                    }
                }
            )
        }
    }
}

@Preview
@Composable
fun AppAndroidPreview() {
    ProductsScreen()
}