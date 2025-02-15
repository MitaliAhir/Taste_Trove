package com.example.tastetrove.networking

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object RetrofitInstance {

    private const val BASE_URL  = "https://spoonacular-recipe-food-nutrition-v1.p.rapidapi.com/"

    // Create a custom OkHttpClient with increased timeouts to handle slow network responses
    private val okHttpClient = OkHttpClient.Builder()
        .connectTimeout(30, TimeUnit.SECONDS)  // Connection timeout
        .readTimeout(30, TimeUnit.SECONDS)     // Read timeout
        .writeTimeout(30, TimeUnit.SECONDS)    // Write timeout
        .build()

    // Retrofit instance for Recipe Search API
    private val retrofitObject =
        Retrofit.Builder().
        addConverterFactory(GsonConverterFactory.create()).
        baseUrl(BASE_URL).
        client(okHttpClient).
        build()

    // API interface for Recipe Search API
    //val recipeAPI = retrofitObject.create(RecipeAPIService::class.java)

    fun <T> createService(serviceClass: Class<T>): T {
        return retrofitObject.create(serviceClass)
    }

}