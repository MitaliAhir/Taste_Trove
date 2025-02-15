package com.example.tastetrove.scaffold

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
    fun RecipeCard(recipeName: String,
                   time: String,
                   imageUrl: String?,
                   ) {
        Card(modifier = Modifier.padding(8.dp),
            shape = MaterialTheme.shapes.medium,
            border = null
            //elevation = 4.dp
        ) {
            Column(modifier = Modifier.padding(16.dp)) {
                Text(recipeName, style = MaterialTheme.typography.headlineMedium)
                Text("Time to Cook: $time")
            }
        }
    }
