package com.example.tastetrove.views

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.tastetrove.model.RecipeViewModel
import com.example.tastetrove.scaffold.RecipeCard

@Composable
fun SavedRecipesScreen(viewModel: RecipeViewModel) {
    val savedRecipes by viewModel.savedRecipes.observeAsState(emptyList())

    Column(modifier = Modifier.padding(16.dp)) {
        Text("Saved Recipes", style = MaterialTheme.typography.headlineMedium)
        LazyColumn(modifier = Modifier.fillMaxSize()) {
            items(savedRecipes) { recipe ->
                RecipeCard(
                    recipeName = recipe.title,
                    time = "${recipe.readyInMinutes} min",
                    imageUrl = recipe.image,
                    onClick = {
                        // Navigate to recipe details screen
                    }
                )
            }
        }
    }
}