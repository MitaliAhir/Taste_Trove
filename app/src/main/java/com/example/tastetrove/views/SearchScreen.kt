package com.example.tastetrove.views

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.tastetrove.Model.RecipeViewModel
import com.example.tastetrove.scaffold.RecipeCard

@Composable
fun SearchScreen(
    viewModel: Lazy<RecipeViewModel>,
    onScreenLoading: () -> Unit,
    onSearch: (String) -> Unit

    ) {
    Column {
        SearchBarUI()
        Spacer(modifier = Modifier.width(8.dp))

        // Recent Recipes or Suggestions
        LazyColumn(modifier = Modifier.fillMaxSize()) {
            items(5) { index ->
                RecipeCard(recipeName = "Recipe $index", time = "30 min", "fyfyy")
            }
        }
    }
}


@Composable
fun SearchBarUI() {
    var searchText by remember { mutableStateOf("") }
    LaunchedEffect(Unit) {
        //onScreenLoading()
    }


    TextField(
        value = searchText,
        onValueChange = {
            searchText = it
            if (searchText.isNotEmpty()) {
                //onSearch(searchText)
            } else{
                //onScreemLoading()
            }
        },
        modifier = Modifier.fillMaxWidth().padding(16.dp),
        placeholder = { Text("Search for recipes...") },
        leadingIcon = { Icon(Icons.Default.Search, contentDescription = "Search") }
    )
}

@Preview
@Composable
fun HomeScreenPreview() {
    //SearchScreen()
}
