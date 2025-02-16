package com.example.tastetrove.networking

import com.example.tastetrove.model.Ingredient
import com.example.tastetrove.model.Recipe
import com.example.tastetrove.model.RecipeDetails
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface RecipeAPIService {

    @GET("food/ingredients")
    suspend fun getIngredients(): List<Ingredient>

    @GET("recipes/findByIngredients")
    suspend fun getRecipesByIngredients(
        @Query("ingredients") ingredients: String,
        @Query("number") number: Int = 5,
        @Query("ignorePantry") ignorePantry: Boolean = true,
        @Query("ranking") ranking: Int = 1
    ): List<Recipe>

    @GET("recipes/{id}/information")
    suspend fun getRecipeDetails(@Path("id") id: Int): RecipeDetails
}

