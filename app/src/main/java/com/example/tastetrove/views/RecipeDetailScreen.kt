package com.example.tastetrove.views

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.tastetrove.model.RecipeViewModel

@Composable
fun RecipeDetailScreen(viewModel: RecipeViewModel, recipeId: Int) {
    val recipeDetails by viewModel.recipeDetails.observeAsState()
    LaunchedEffect(recipeId) {
        viewModel.fetchRecipeDetails(recipeId)
    }

    recipeDetails?.let { details ->
        Column(modifier = Modifier.padding(16.dp)) {
            Text(details.title, style = MaterialTheme.typography.headlineMedium)
            Spacer(modifier = Modifier.height(8.dp))
            Text("Ready in ${details.readyInMinutes} minutes")
            Spacer(modifier = Modifier.height(8.dp))
            // Add more details here...
        }
    } ?: run {
        Text("Loading...", style = MaterialTheme.typography.labelSmall)
    }
}