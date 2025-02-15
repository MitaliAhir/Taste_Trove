package com.example.tastetrove.scaffold

import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.tastetrove.navigation.Item

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBar(selectedIndex: MutableState<Int>, navItems: List<Item>) {

    CenterAlignedTopAppBar(
        title = { Text(text = navItems[selectedIndex.value].title,
            style = TextStyle(
                fontSize = 23.sp,
                lineHeight = 32.sp,
                fontFamily = (FontFamily.SansSerif),
                fontWeight = FontWeight(700),
                color = Color(0xFF146354)
                )
        ) }
    )
    HorizontalDivider(
        modifier = Modifier,
        thickness = 5.dp,
        color = Color(0xFFBFC6DC)
    )
}

