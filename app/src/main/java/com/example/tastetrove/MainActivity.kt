package com.example.tastetrove

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.example.tastetrove.navigation.AppNavHost
import com.example.tastetrove.scaffold.BottomBar
import com.example.tastetrove.scaffold.TopBar
import com.example.tastetrove.ui.theme.TasteTroveTheme

class MainActivity : ComponentActivity() {

    private lateinit var recipeViewModel: RecipeViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TasteTroveTheme {
                val navController = rememberNavController()
                TasteTroveApp()
                Scaffold (
                    bottomBar = { BottomBar (onNavigate = {path ->
                        navController.navigate(path) })
                    },
                    topBar = { TopBar() }
                ){innerPadding ->
                    Column(
                        modifier = Modifier.padding(innerPadding)
                    ) {
                        AppNavHost(navController)

                    }
                }
            }
        }
        // ViewModelProvider setup
//        recipeViewModel = ViewModelProvider(this).get(RecipeViewModel::class.java)
//        // Observe LiveData for recipes
//        recipeViewModel.recipes.observe(this, Observer { recipes ->
//            // Update UI with the list of recipes
//            // Show recipes in a RecyclerView, for example
//        })
//
//        // Observe loading state
//        recipeViewModel.loading.observe(this, Observer { isLoading ->
//            // Show loading spinner or something when isLoading is true
//        })
//
//        // Trigger recipe search
//        recipeViewModel.searchRecipes("tomato, cheese")  // Example search query
    }
}
@Composable
fun TasteTroveApp(){

    //AppNavHost()
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    TasteTroveTheme {
        TasteTroveApp()
    }
}