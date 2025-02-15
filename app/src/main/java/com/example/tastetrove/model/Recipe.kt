package com.example.tastetrove.model
import kotlin.random.Random

data class Recipe(val id: Long, val title: String, val image: String, val instructions: String)

val recipes = listOf(
    Recipe(Random.nextLong(),"Recipe Name", "url","Steps...."),
    Recipe(65435346, "Recipe Name", "url","Steps..."),
    Recipe(53535543, "Recipe Name", "url","Steps")
)
