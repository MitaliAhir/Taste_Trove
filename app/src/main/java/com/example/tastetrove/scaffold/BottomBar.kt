package com.example.tastetrove.scaffold

import androidx.compose.runtime.Composable
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import com.example.tastetrove.navigation.NavItem

@Composable
fun BottomBar(onNavigate : (String)->Unit  ){
    val navItems = listOf(NavItem.Home, NavItem.Search, NavItem.SavedRecipes)
    var selectedIndex = remember { mutableStateOf(0) }
    NavigationBar {
        navItems.forEachIndexed { index, item ->
            NavigationBarItem(
                selected = index == selectedIndex.value,
                label = { Text(text = item.title) },
                onClick = {
                    selectedIndex.value = index
                    onNavigate(item.path)
                },
                icon = {
                    Icon(imageVector = item.icon, contentDescription = item.title)
                }
            )

        }
    }

}