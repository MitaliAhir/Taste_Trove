package com.example.tastetrove.views

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
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
import androidx.compose.ui.Alignment
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.lifecycle.viewmodel.compose.viewModel
import coil3.compose.AsyncImage


@Composable
fun SearchScreen(viewModel: RecipeViewModel = viewModel(), onRecipeClick: (Int) -> Unit) {

    // Call fetchIngredients when the SearchScreen composable is first composed
    LaunchedEffect(Unit) {
        viewModel.fetchIngredients()
    }
    val ingredients by viewModel.ingredients.observeAsState(emptyList())
    val recipes by viewModel.recipes.observeAsState(emptyList())
    val selectedIngredients = remember { mutableStateListOf<String>() }
    var searchText by remember { mutableStateOf("") }

    Column(modifier = Modifier.padding(16.dp)) {
        SearchBarUI(
            searchText = searchText,
            onValueChange = { query ->
                searchText = query
                if (searchText.isNotEmpty()) {
                    // Find matching ingredients or recipes
                    viewModel.searchRecipesByIngredients(searchText)
                }
            }
        )
        Spacer(modifier = Modifier.height(16.dp))
        // Ingredient selection list
        Text("Select Ingredients", style = MaterialTheme.typography.headlineMedium)
        LazyColumn(modifier = Modifier.fillMaxHeight(0.3f)) {
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
        }
        Spacer(modifier = Modifier.height(16.dp))

        Text("Recipes Based on Selected Ingredients", style = MaterialTheme.typography.headlineMedium)
        LazyColumn(modifier = Modifier.fillMaxSize()) {
            items(recipes) { recipe ->
                RecipeCard(recipeName = recipe.title, time = "30 min", imageUrl = recipe.image, onClick = {
                    onRecipeClick(recipe.id)
                })
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
        modifier = Modifier.fillMaxWidth().padding(16.dp),
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
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .padding(8.dp)
            .clickable(onClick = onClick)
    ) {
        AsyncImage(
            model = ingredient.image,
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(64.dp)
                .clip(CircleShape)
                .background(if (isSelected) Color.Green else Color.Gray)
        )
        Spacer(modifier = Modifier.height(4.dp))
        Text(ingredient.name)
    }
}
@Preview
@Composable
fun HomeScreenPreview() {
    //SearchScreen(viewModel(), onRecipeClick = onClick())
}
