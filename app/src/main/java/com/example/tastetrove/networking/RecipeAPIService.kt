package com.example.tastetrove.networking

import com.example.tastetrove.model.Ingredient
import com.example.tastetrove.model.Recipe
import retrofit2.http.GET
import retrofit2.http.Query

interface RecipeAPIService {

    @GET("food/ingredients")
    suspend fun getIngredients(): List<Ingredient>

    @GET("recipes/findByIngredients")
    suspend fun getRecipesByIngredients(
        @Query("ingredients") ingredients: String
    ): List<Recipe>
}

