package com.example.tastetrove.model

import RecipeRepository
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.tastetrove.room.RecipeEntity
import kotlinx.coroutines.launch

//The ViewModel will expose LiveData (or StateFlow) to the UI, which the View (Activity/Fragment) observes.
//When the ViewModel receives a request, it interacts with the Repository to fetch the data.

class RecipeViewModel(private val recipeRepository: RecipeRepository) : ViewModel() {
    private val _ingredients = MutableLiveData<List<Ingredient>>()
    val ingredients: LiveData<List<Ingredient>> get() = _ingredients

    private val _recipes = MutableLiveData<List<Recipe>>()
    val recipes: LiveData<List<Recipe>> get() = _recipes

    private val _recipeDetails = MutableLiveData<Recipe>()
    val recipeDetails: LiveData<Recipe> get() = _recipeDetails

    private val _savedRecipes = MutableLiveData<List<RecipeEntity>>()
    val savedRecipes: LiveData<List<RecipeEntity>> get() = _savedRecipes

    private val _loading = MutableLiveData<Boolean>()
    val loading: LiveData<Boolean> get() = _loading

    private val selectedIngredients = mutableListOf<String>()

//    fun fetchIngredients() {
//        viewModelScope.launch {
//            _loading.value = true
//            try {
//                _ingredients.value = recipeRepository.getIngredients()
//            } catch (e: Exception) {
//                Log.e("RecipeViewModel", "Error fetching ingredients", e)
//            } finally {
//                _loading.value = false
//            }
//        }
//    }

    fun addIngredient(ingredient: String) {
        if (!selectedIngredients.contains(ingredient)) {
            selectedIngredients.add(ingredient)
            searchRecipesByIngredients(selectedIngredients.joinToString(","))
        }
    }

    fun removeIngredient(ingredient: String) {
        selectedIngredients.remove(ingredient)
        searchRecipesByIngredients(selectedIngredients.joinToString(","))
    }

    fun searchRecipesByIngredients(ingredients: String) {
        _loading.value = true
        viewModelScope.launch {
            try {
                val result = recipeRepository.getRecipesByIngredients(ingredients)
                _recipes.value = result
            } catch (e: Exception) {
                Log.e("RecipeViewModel", "Error fetching recipes", e)
            } finally {
                _loading.value = false
            }
        }
    }
    fun fetchRecipeDetails(recipeId: Int) {
        viewModelScope.launch {
            _loading.value = true
            try {
                val details = recipeRepository.getRecipeDetails(recipeId)
                _recipeDetails.value = details
            } catch (e: Exception) {
                Log.e("RecipeViewModel", "Error fetching recipe details", e)
            } finally {
                _loading.value = false
            }
        }
    }

    fun saveRecipe(recipeEntity: RecipeEntity) {
        viewModelScope.launch {
            try {
                recipeRepository.saveRecipe(recipeEntity)
                fetchSavedRecipes()
            } catch (e: Exception) {
                Log.e("RecipeViewModel", "Error saving recipe", e)
            }
        }
    }

    fun fetchSavedRecipes() {
        viewModelScope.launch {
            try {
                val savedRecipes = recipeRepository.getAllSavedRecipes()
                _savedRecipes.value = savedRecipes
            } catch (e: Exception) {
                Log.e("RecipeViewModel", "Error fetching saved recipes", e)
            }
        }
    }

    fun deleteRecipe(recipeId: Int) {
        viewModelScope.launch {
            try {
                recipeRepository.deleteRecipe(recipeId)
                fetchSavedRecipes()
            } catch (e: Exception) {
                Log.e("RecipeViewModel", "Error deleting recipe", e)
            }
        }
    }
}