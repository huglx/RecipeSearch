package com.isteel.recipessearch.Repository;

import androidx.annotation.NonNull;

import com.isteel.recipessearch.Content.Recipe;
import com.isteel.recipessearch.Content.RecipeResponse;
import com.isteel.recipessearch.Content.Steps.Ingredients.IngredResponse;
import com.isteel.recipessearch.Content.Steps.Ingredients.Ingredients;
import com.isteel.recipessearch.Content.Steps.ResponseStep;

import java.util.List;

import io.reactivex.Observable;


public interface RecipeRepository {
    @NonNull
    Observable<IngredResponse> ingredients(String id);

    @NonNull
    Observable<RecipeResponse> recipe(String diet);

    @NonNull
    Observable<RecipeResponse> recipe(String query, String diet);

    @NonNull
    Observable<Recipe> recipeInfo(String id);

    @NonNull
    Observable<List<ResponseStep>> steps(String id);
}
