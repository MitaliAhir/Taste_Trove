package com.example.tastetrove.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Search

sealed class NavItem {
    object Home: Item("home","Home", Icons.Default.Home)
    object Search: Item("search","Search", Icons.Default.Search)
    object SavedRecipes: Item("saved","Saved", Icons.Default.Favorite)
}