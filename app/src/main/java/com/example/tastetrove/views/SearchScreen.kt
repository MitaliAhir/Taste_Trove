package com.example.tastetrove.views

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.SearchBar
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchScreen() {
    Column {
        // Top Bar with app name and settings icon
//        TopAppBar(
//            title = { Text("Discover") },
//            actions = {
//                IconButton(onClick = { }) {
//                    Icon(Icons.Default.Settings, contentDescription = "Settings")
//                }
//            }
//        )

        // Search Bar
        SearchBarUI()

        // Recent Recipes or Suggestions
        LazyColumn(modifier = Modifier.fillMaxSize()) {
            items(5) { index ->
                RecipeCard(recipeName = "Recipe $index", time = "30 min")
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchBarUI() {
    var searchText by remember { mutableStateOf("") }
    var activeStateOfSearchBar by remember { mutableStateOf(true) }
//    SearchBar(
//        query = searchText,
//        onQueryChange = {
//            searchText = it
//        },
//        onSearch = {
//            activeStateOfSearchBar = true
//        },
//        active  = activeStateOfSearchBar,
//        onActiveChange = {
//            activeStateOfSearchBar = it
//        },
//        placeholder = { Text("Search for recipes...") },
//        modifier = Modifier.fillMaxWidth().padding(16.dp),
//        leadingIcon = { Icon(Icons.Default.Search, contentDescription = "Search") }
//
//    ) { }

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
