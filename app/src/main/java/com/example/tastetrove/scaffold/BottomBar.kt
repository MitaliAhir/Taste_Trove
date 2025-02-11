package com.example.tastetrove.scaffold

import androidx.compose.runtime.Composable
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.MutableState
import com.example.tastetrove.navigation.Item

@Composable
fun BottomBar(navItems: List<Item>, selectedIndex: MutableState<Int>, onNavigate: (String) -> Unit){
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