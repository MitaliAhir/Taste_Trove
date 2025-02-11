package com.example.tastetrove.scaffold

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import com.example.tastetrove.navigation.Item

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBar(selectedIndex: MutableState<Int>, navItems: List<Item>) {

    TopAppBar(
        title = { Text(text = navItems[selectedIndex.value].title) }
    )
}

