package com.example.tastetrove.scaffold

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import com.example.tastetrove.navigation.NavItem

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun  TopBar() {
    val navItems = listOf(NavItem.Home, NavItem.Search, NavItem.SavedRecipes)
    var selectedIndex = remember { mutableStateOf(0) }
    navItems.forEachIndexed { index, item ->
            index == selectedIndex.value
        TopAppBar(
            title = {
                Text(text = item.title)
            }
        )
    }

}