package com.example.tastetrove

import RecipeRepository
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.compose.rememberNavController
import com.example.tastetrove.model.RecipeViewModel
import com.example.tastetrove.model.RecipeViewModelFactory
import com.example.tastetrove.navigation.AppNavHost
import com.example.tastetrove.navigation.NavItem
import com.example.tastetrove.scaffold.BottomBar
import com.example.tastetrove.scaffold.TopBar
import com.example.tastetrove.ui.theme.TasteTroveTheme
import com.example.tastetrove.networking.RetrofitInstance

class MainActivity : ComponentActivity() {

    private lateinit var recipeViewModel: RecipeViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        // Create an instance of your RecipeAPIService
        //val apiService = RetrofitInstance.createService(RecipeAPIService::class.java)

        // Create an instance of your RecipeRepository
        val recipeRepository = RecipeRepository(RetrofitInstance.recipeAPI)

        // Initialize the ViewModel with the factory
        val factory = RecipeViewModelFactory(recipeRepository)
        recipeViewModel = ViewModelProvider(this, factory).get(RecipeViewModel::class.java)

        setContent {
            TasteTroveTheme {
                val navController = rememberNavController()
                val selectedIndex = remember { mutableStateOf(0) }
                val navItems = listOf(NavItem.Home, NavItem.Search, NavItem.SavedRecipes)

                Scaffold(
                    bottomBar = {
                        BottomBar(navItems, selectedIndex, onNavigate = { path ->
                            navController.navigate(path)
                        })
                    },
                    topBar = { TopBar(selectedIndex, navItems) }
                ) { innerPadding ->
                    Column(
                        modifier = Modifier.padding(innerPadding)
                    ) {
                        AppNavHost(navController, viewModel = recipeViewModel)
                    }
                }
            }
        }

    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    TasteTroveTheme {

    }
}