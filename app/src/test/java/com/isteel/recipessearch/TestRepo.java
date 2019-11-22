package com.isteel.recipessearch;

import androidx.annotation.NonNull;

import com.isteel.recipessearch.Api.RecipeService;
import com.isteel.recipessearch.Content.Result;
import com.isteel.recipessearch.Content.Steps.Ingredients.IngredResponse;
import com.isteel.recipessearch.Content.Steps.ResponseStep;
import com.isteel.recipessearch.Repository.RecipeRepository;

import java.util.List;

import io.reactivex.Observable;

public class TestRepo implements RecipeRepository {
    @NonNull
    @Override
    public Observable<Result> recipe() {
        ExampleUnitTest ExampleUnitTest = new ExampleUnitTest();
        return Observable.empty();
    }

    @NonNull
    @Override
    public Observable<Result> recipe(String query) {
        return Observable.empty();
    }

    @NonNull
    @Override
    public Observable<List<ResponseStep>> steps(String id) {
        return Observable.empty();
    }

    @NonNull
    @Override
    public Observable<IngredResponse> ingredients(String id) {
        return Observable.empty();
    }
}
