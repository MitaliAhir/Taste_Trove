package com.example.tastetrove.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Search

// Sealed class means a class have static objects that we can use without creating any variables.
// It provides a safe way to define fixed type of routes in your app .
// Define each screen into objects to ensure type safety and each object represent unique destination.

sealed class NavItem {
    object Home: Item("home","TasteTrove", Icons.Default.Home)
    object Search: Item("search","Search", Icons.Default.Search)
    object SavedRecipes: Item("saved","Saved Recipes", Icons.Default.Favorite)
}