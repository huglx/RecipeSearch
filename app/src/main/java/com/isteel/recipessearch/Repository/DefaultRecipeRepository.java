package com.isteel.recipessearch.Repository;

import androidx.annotation.NonNull;

import com.isteel.recipessearch.Api.ApiFactory;
import com.isteel.recipessearch.Content.Result;
import com.isteel.recipessearch.Content.Steps.Ingredients.IngredResponse;
import com.isteel.recipessearch.Content.Steps.Ingredients.Ingredients;
import com.isteel.recipessearch.Content.Steps.ResponseStep;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import io.realm.Realm;
import io.realm.RealmModel;
import io.realm.RealmObject;
import io.realm.RealmResults;
import ru.arturvasilov.rxloader.RxUtils;

public class DefaultRecipeRepository implements RecipeRepository {

    @NonNull
    @Override
    public Observable<Result> recipe() {
        return ApiFactory.getRecipeService()
                .recipe()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());

    }

    @NonNull
    @Override
    public Observable<Result> recipe(String query) {
        return ApiFactory.getRecipeService()
                .recipe(query)
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
