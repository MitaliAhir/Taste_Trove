package com.example.tastetrove.networking

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object RetrofitInstance {

    private const val BASE_URL  = "https://spoonacular-recipe-food-nutrition-v1.p.rapidapi.com/"

    // Retrofit instance for Recipe Search API
    private val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    // API interface for Recipe Search API
    val recipeAPI: RecipeAPIService = retrofit.create(RecipeAPIService::class.java)


}