package com.isteel.recipessearch.Api;

import com.isteel.recipessearch.Content.Recipe;
import com.isteel.recipessearch.Content.RecipeResponse;
import com.isteel.recipessearch.Content.Steps.Ingredients.IngredResponse;
import com.isteel.recipessearch.Content.Steps.ResponseStep;
import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface DefaultRecipeService {
    @GET("{id}/ingredientWidget.json?apiKey=6bbcc5cb6b1b46f9986d188fd72c1d65")
    Observable<IngredResponse> ingredients(@Path("id") String str);

    @GET("search?apiKey=6bbcc5cb6b1b46f9986d188fd72c1d65&number=99")
    Observable<RecipeResponse> recipe(@Query("diet") String str);

    @GET("search?apiKey=6bbcc5cb6b1b46f9986d188fd72c1d65&number=99")
    Observable<RecipeResponse> recipe(@Query("query") String str, @Query("diet") String str2);

    @GET("{id}/information?apiKey=6bbcc5cb6b1b46f9986d188fd72c1d65")
    Observable<Recipe> recipeInfo(@Path("id") String str);

    @GET("{id}/analyzedInstructions?apiKey=6bbcc5cb6b1b46f9986d188fd72c1d65")
    Observable<List<ResponseStep>> steps(@Path("id") String str);
}
