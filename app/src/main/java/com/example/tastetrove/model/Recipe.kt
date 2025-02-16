package com.example.tastetrove.model
import kotlin.random.Random

data class Recipe(val id: Int, val title: String, val image: String, val instructions: String)

val recipes = listOf(
    Recipe(Random.nextInt(),"Recipe Name", "url","Steps...."),
    Recipe(65435346, "Recipe Name", "url","Steps..."),
    Recipe(53535543, "Recipe Name", "url","Steps")
)

data class  RecipeDetails(val id: Int,
                          val title: String,
                          val image: String,
                          val instructions: String,
                          val servings: Int,
                          val readyInMinutes: Int)