import com.example.tastetrove.model.Ingredient
import com.example.tastetrove.model.Recipe
import com.example.tastetrove.networking.RecipeAPIService
import com.example.tastetrove.room.RecipeDao
import com.example.tastetrove.room.RecipeEntity

//The Repository handles network requests. For example, it will call API to search for recipes based on ingredients.
class RecipeRepository(private val apiService: RecipeAPIService, private val recipeDao: RecipeDao) {

//    suspend fun getIngredients(): List<Ingredient> {
//        return apiService.getIngredients()
//    }

    suspend fun getRecipesByIngredients(ingredients: String): List<Recipe> {
        return apiService.getRecipesByIngredients(ingredients)
    }
    suspend fun getRecipeDetails(id: Int): Recipe {
        return apiService.getRecipeDetails(id)
    }
    suspend fun saveRecipe(recipeEntity: RecipeEntity) {
        recipeDao.insert(recipeEntity)
    }

    suspend fun getAllSavedRecipes(): List<RecipeEntity> {
        return recipeDao.getAllRecipes()
    }

    suspend fun deleteRecipe(recipeId: Int) {
        recipeDao.deleteRecipe(recipeId)
    }
}