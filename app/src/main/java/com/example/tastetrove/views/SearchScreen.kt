package com.example.tastetrove.views

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.tastetrove.model.Ingredient
import com.example.tastetrove.model.RecipeViewModel
import com.example.tastetrove.scaffold.RecipeCard
import androidx.compose.runtime.livedata.observeAsState
import androidx.lifecycle.viewmodel.compose.viewModel


@Composable
fun SearchScreen(viewModel: RecipeViewModel = viewModel()) {
    val ingredients by viewModel.ingredients.observeAsState(emptyList())
    val recipes by viewModel.recipes.observeAsState(emptyList())
    val selectedIngredients = remember { mutableStateListOf<String>() }
    var searchText by remember { mutableStateOf("") }

    Column(modifier = Modifier.padding(16.dp)) {
        // Search bar
        SearchBarUI(
            searchText = searchText,
            onValueChange = { query ->
                searchText = query
                if (searchText.isNotEmpty()) {
                    // Find matching ingredients or recipes
                    viewModel.searchRecipesByIngredients(searchText)
                } else {
                    // Clear results or show default state
                }
            }
        )

        // Ingredient selection list
        LazyColumn(modifier = Modifier.fillMaxSize()) {
            item {
                Text("Select Ingredients", style = MaterialTheme.typography.headlineMedium)
                Spacer(modifier = Modifier.height(8.dp))
            }

            items(ingredients) { ingredient ->
                IngredientItem(
                    ingredient = ingredient,
                    isSelected = selectedIngredients.contains(ingredient.name),
                    onClick = {
                        if (selectedIngredients.contains(ingredient.name)) {
                            selectedIngredients.remove(ingredient.name)
                            viewModel.removeIngredient(ingredient.name)
                        } else {
                            selectedIngredients.add(ingredient.name)
                            viewModel.addIngredient(ingredient.name)
                        }
                    }
                )
            }

            item {
                Spacer(modifier = Modifier.height(16.dp))
                Text("Recipes Based on Selected Ingredients", style = MaterialTheme.typography.headlineMedium)
                Spacer(modifier = Modifier.height(8.dp))
            }

            items(recipes) { recipe ->
                RecipeCard(recipeName = recipe.title, time = "30 min", imageUrl = recipe.image)
            }
        }
    }
}

@Composable
fun SearchBarUI(
    searchText: String,
    onValueChange: (String) -> Unit
) {
    TextField(
        value = searchText,
        onValueChange = onValueChange,
        modifier = Modifier.fillMaxWidth(),
        placeholder = { Text("Search for ingredients...") },
        leadingIcon = { Icon(Icons.Default.Search, contentDescription = "Search") }
    )
}

@Composable
fun IngredientItem(
    ingredient: Ingredient,
    isSelected: Boolean,
    onClick: () -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .clickable(onClick = onClick),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(ingredient.name)
        if (isSelected) {
            Icon(Icons.Default.Check, contentDescription = "Selected")
        }
    }
}

@Preview
@Composable
fun HomeScreenPreview() {
    //SearchScreen()
}
