package com.example.tastetrove.scaffold

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun RecipeCard(recipeName: String, time: String, imageUrl: String, onClick: () -> Unit) {
    Card(
        modifier = Modifier.padding(8.dp).fillMaxWidth().clickable(onClick = onClick),
        shape = MaterialTheme.shapes.medium,

    ) {
        Column(
            modifier = Modifier.padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(recipeName, style = MaterialTheme.typography.headlineMedium)
            Text("Time to Cook: $time")
            //Image(painter = rememberImagePainter(imageUrl), contentDescription = "Recipe Image")
        }
    }
}
