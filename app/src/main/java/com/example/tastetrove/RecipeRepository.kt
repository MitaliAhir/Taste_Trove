import com.example.tastetrove.Model.Recipe

//package com.example.tastetrove
//
////The Repository handles network requests. For example, it will call Spoonacular API to search for recipes based on ingredients.
////Use Retrofit for networking, Gson for parsing, and maybe a Room database if you need to cache recipes.
//
//class RecipeRepository (private val apiService: SpoonacularApiService){
//    suspend fun searchRecipes(ingredients: String): List<Recipe> {
//        // Make API call to Spoonacular API with ingredients
//        return apiService.searchRecipes(ingredients)
//    }
//}
class RecipeRepository {
    fun searchRecipes(ingredients: String): List<Recipe>{
        return listOf(
            Recipe(88508304,"Recipe Name", "url", "30 min"),
            Recipe(65435346, "Recipe Name", "url", "40 min"),
            Recipe(53535543, "Recipe Name", "url", "50 min")
        )
    }
}
