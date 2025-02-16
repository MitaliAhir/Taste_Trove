import com.example.tastetrove.model.Ingredient
import com.example.tastetrove.model.Recipe
import com.example.tastetrove.model.RecipeDetails
import com.example.tastetrove.networking.RecipeAPIService

//The Repository handles network requests. For example, it will call API to search for recipes based on ingredients.
class RecipeRepository(private val apiService: RecipeAPIService) {

    suspend fun getIngredients(): List<Ingredient> {
        return apiService.getIngredients()
    }

    suspend fun getRecipesByIngredients(ingredients: String): List<Recipe> {
        return apiService.getRecipesByIngredients(ingredients)
    }
    suspend fun getRecipeDetails(id: Int): RecipeDetails {
        return apiService.getRecipeDetails(id)
    }
}