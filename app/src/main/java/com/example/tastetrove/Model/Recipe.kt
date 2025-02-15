package com.example.tastetrove.Model
import kotlin.random.Random

data class Recipe(val id: Long, val title: String, val image: String, val instructions: String)

class RecipeAPIService() {
    // Connecting API to fetch recipes data

    fun getRecipesFromAPI(quary: String) : ArrayList<Recipe>{
        var apiList = ArrayList<Recipe>()


        return  apiList
    }
}
val recipes = listOf(
    Recipe(Random.nextLong(),"Recipe Name", "url", "30 min"),
    Recipe(65435346, "Recipe Name", "url", "40 min"),
    Recipe(53535543, "Recipe Name", "url", "50 min")
)
