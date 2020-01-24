package com.isteel.recipessearch.Api;

import com.isteel.recipessearch.Content.Recipe;
import com.isteel.recipessearch.Content.Result;
import com.isteel.recipessearch.Content.Steps.Ingredients.IngredResponse;
import com.isteel.recipessearch.Content.Steps.ResponseStep;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

<<<<<<< HEAD:app/src/main/java/com/isteel/recipessearch/Api/RecipeService.java
public interface RecipeService {

    @GET("search?apiKey=6bbcc5cb6b1b46f9986d188fd72c1d65&number=100")
    Observable<Result> recipe();

    @GET("search?apiKey=6bbcc5cb6b1b46f9986d188fd72c1d65&number=100")
    Observable<Result> recipe(@Query("query") String query);

    @GET("{id}/analyzedInstructions?apiKey=6bbcc5cb6b1b46f9986d188fd72c1d65")
    Observable<List<ResponseStep>> steps(@Path("id") String id);

    @GET("{id}/ingredientWidget.json?apiKey=6bbcc5cb6b1b46f9986d188fd72c1d65")
    Observable<IngredResponse> ingredients(@Path("id") String id);
=======
public interface DefaultRecipeService {
    @GET("{id}/ingredientWidget.json?apiKey=6bbcc5cb6b1b46f9986d188fd72c1d65")
    Observable<IngredResponse> ingredients(@Path("id") String id);

    @GET("search?apiKey=6bbcc5cb6b1b46f9986d188fd72c1d65&number=99")
    Observable<RecipeResponse> recipe(@Query("diet") String diet);

    @GET("search?apiKey=6bbcc5cb6b1b46f9986d188fd72c1d65&number=99")
    Observable<RecipeResponse> recipe(@Query("query") String query, @Query("diet") String diet);

    @GET("{id}/information?apiKey=6bbcc5cb6b1b46f9986d188fd72c1d65")
    Observable<Recipe> recipeInfo(@Path("id") String id);

    @GET("{id}/analyzedInstructions?apiKey=6bbcc5cb6b1b46f9986d188fd72c1d65")
    Observable<List<ResponseStep>> steps(@Path("id") String id);
>>>>>>> 3a0da9f... version 1.25.01:app/src/main/java/com/isteel/recipessearch/Api/DefaultRecipeService.java
}
