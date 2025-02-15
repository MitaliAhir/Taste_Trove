package com.example.tastetrove.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.tastetrove.model.RecipeViewModel
import com.example.tastetrove.views.HomeScreen
import com.example.tastetrove.views.SavedRecipesScreen
import com.example.tastetrove.views.SearchScreen

@Composable
fun AppNavHost(navController: NavHostController, viewModel: RecipeViewModel) {

    NavHost(navController, startDestination = "home") {
        composable("home") {
            HomeScreen(
                viewModel = viewModel
            )
        }
        composable("search") {
            SearchScreen(
                viewModel = viewModel
            )
        }
        composable("saved") {
             SavedRecipesScreen()
        }
    }

}
