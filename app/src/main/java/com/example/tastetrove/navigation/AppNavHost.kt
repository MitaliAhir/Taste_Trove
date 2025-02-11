package com.example.tastetrove.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.tastetrove.views.HomeScreen
import com.example.tastetrove.views.SavedRecipesScreen
import com.example.tastetrove.views.SearchScreen


@Composable
fun AppNavHost(navController: NavHostController) {

    NavHost(navController, startDestination = "home") {
        composable("home") {
            HomeScreen()
        }
        composable("search") {
            SearchScreen()
        }
        composable("saved") {
             SavedRecipesScreen()
        }
    }
}
