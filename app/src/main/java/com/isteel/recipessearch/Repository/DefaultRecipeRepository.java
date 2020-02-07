package com.isteel.recipessearch.Repository;

import androidx.annotation.NonNull;

import com.isteel.recipessearch.Api.ApiFactory;
import com.isteel.recipessearch.Content.Recipe;
import com.isteel.recipessearch.Content.RecipeResponse;
import com.isteel.recipessearch.Content.Steps.Ingredients.IngredResponse;
import com.isteel.recipessearch.Content.Steps.ResponseStep;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class DefaultRecipeRepository implements RecipeRepository {

    @NonNull
    @Override
    public Observable<RecipeResponse> recipe(String diet) {
        return ApiFactory.getRecipeService()
                .recipe(diet)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());

    }

    @NonNull
    @Override
    public Observable<RecipeResponse> recipe(String query, String diet) {
        return ApiFactory.getRecipeService()
                .recipe(query, diet)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());

    }

    @NonNull
    @Override
    public Observable<Recipe> recipeInfo(String id) {
        return ApiFactory.getRecipeService()
                .recipeInfo(id)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());

    }

    @NonNull
    @Override
    public Observable<List<ResponseStep>> steps(String id) {
        return ApiFactory.getRecipeService()
                .steps(id)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

    @NonNull
    @Override
    public Observable<IngredResponse> ingredients(String id) {
        return ApiFactory.getRecipeService()
                .ingredients(id)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }
}
