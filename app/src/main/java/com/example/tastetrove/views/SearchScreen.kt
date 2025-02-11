package com.example.tastetrove.views

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun SearchScreen() {
    Column {
        SearchBarUI()

        // Recent Recipes or Suggestions
        LazyColumn(modifier = Modifier.fillMaxSize()) {
            items(5) { index ->
                RecipeCard(recipeName = "Recipe $index", time = "30 min")
            }
        }
    }
}


@Composable
fun SearchBarUI() {
    var searchText by remember { mutableStateOf("") }
    var activeStateOfSearchBar by remember { mutableStateOf(true) }

    TextField(
        value = searchText,
        onValueChange = {
            searchText = it
            if (searchText.isNotEmpty()) {
                //onSearch()
            } else{
                //loading
            }
        },
        modifier = Modifier.fillMaxWidth().padding(16.dp),
        placeholder = { Text("Search for recipes...") },
        leadingIcon = { Icon(Icons.Default.Search, contentDescription = "Search") }
    )
}

@Composable
fun RecipeCard(recipeName: String, time: String) {
    Card(modifier = Modifier.padding(8.dp)) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(recipeName, style = MaterialTheme.typography.headlineMedium)
            Text("Time to Cook: $time")
        }
    }
}

@Preview
@Composable
fun HomeScreenPreview() {
    SearchScreen()
}
