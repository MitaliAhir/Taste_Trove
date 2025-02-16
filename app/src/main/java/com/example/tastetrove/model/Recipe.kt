package com.example.tastetrove.model
import kotlin.random.Random


data class  Recipe(val id: Int,
                          val title: String,
                          val image: String,
                          val instructions: String,
                          val servings: Int,
                          val readyInMinutes: Int)
val recipes = listOf(
    Recipe(Random.nextInt(),"Recipe Name", "url","Steps....", 2,30),
    Recipe(65435346, "Recipe Name", "url","Steps...",3, 20),
    Recipe(53535543, "Recipe Name", "url","Steps",4, 40)
)
