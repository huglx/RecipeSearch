package com.isteel.recipessearch.Repository;

import androidx.annotation.NonNull;

import com.isteel.recipessearch.Content.Recipe;
import com.isteel.recipessearch.Content.Result;
import com.isteel.recipessearch.Content.Steps.Ingredients.IngredResponse;
import com.isteel.recipessearch.Content.Steps.Ingredients.Ingredients;
import com.isteel.recipessearch.Content.Steps.ResponseStep;

import java.util.List;

import io.reactivex.Observable;


public interface RecipeRepository {
    @NonNull
    Observable<Result> recipe();

    @NonNull
    Observable<Result> recipe(String query);

    @NonNull
    Observable<List<ResponseStep>> steps(String id);

    @NonNull
    Observable<IngredResponse> ingredients(String id);
}
