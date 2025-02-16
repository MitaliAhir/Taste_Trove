package com.example.tastetrove.views

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import com.example.tastetrove.model.RecipeViewModel

@Composable
fun RecipeDetailScreen(viewModel: RecipeViewModel, recipeId: Int) {
    val recipeDetails by viewModel.recipeDetails.observeAsState()
    LaunchedEffect(recipeId) {
        viewModel.fetchRecipeDetails(recipeId)
    }

    recipeDetails?.let { details ->
        LazyColumn(modifier = Modifier.padding(16.dp)) {
            item {
                Text(details.title, style = MaterialTheme.typography.headlineMedium)
                Spacer(modifier = Modifier.height(8.dp))
                Text("Ready in ${details.readyInMinutes} minutes")
                Spacer(modifier = Modifier.height(8.dp))
                Text("Servings: ${details.servings}")
                Spacer(modifier = Modifier.height(8.dp))
                AsyncImage(
                    model = details.image,
                    contentDescription = "Recipe Image",
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(200.dp)
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text("Instructions", style = MaterialTheme.typography.headlineSmall)
                Spacer(modifier = Modifier.height(4.dp))
                Text(details.instructions)
            }
        }
    } ?: run {
        Text("Loading...", style = MaterialTheme.typography.labelSmall)
    }
}