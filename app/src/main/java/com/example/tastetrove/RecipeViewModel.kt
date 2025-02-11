package com.example.tastetrove

import RecipeRepository
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

//The ViewModel will expose LiveData (or StateFlow) to the UI, which the View (Activity/Fragment) observes.
//When the ViewModel receives a request, it interacts with the Repository to fetch the data.

class RecipeViewModel(private val recipeRepository: RecipeRepository) : ViewModel() {

    private val _recipes = MutableLiveData<List<Recipe>>()
    val recipes: LiveData<List<Recipe>> get() = _recipes

    private val _loading = MutableLiveData<Boolean>()
    val loading: LiveData<Boolean> get() = _loading

    fun searchRecipes(ingredients: String) {
        _loading.value = true
        viewModelScope.launch {
            try {
                val result = recipeRepository.searchRecipes(ingredients)
                _recipes.value = result
            } catch (e: Exception) {
                // Handle error, maybe expose another LiveData for errors
            } finally {
                _loading.value = false
            }
        }
    }
}
