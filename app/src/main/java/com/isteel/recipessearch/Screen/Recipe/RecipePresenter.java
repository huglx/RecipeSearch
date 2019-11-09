package com.isteel.recipessearch.Screen.Recipe;

import android.util.Log;

import com.isteel.recipessearch.Repository.RepositoryProvider;
import com.uber.autodispose.AutoDispose;
import com.uber.autodispose.android.lifecycle.AndroidLifecycleScopeProvider;

public class RecipePresenter {
    RecipeView mView;
    RecipeActivity mRecipeListActivity;

    public RecipePresenter(RecipeView mView, RecipeActivity activity) {
        this.mView = mView;
        mRecipeListActivity = activity;

    }

    public void init(String id){
        RepositoryProvider.provideRecipeRepository()
                .steps(id)
                .as(AutoDispose.autoDisposable(AndroidLifecycleScopeProvider.from(mRecipeListActivity)))
                .subscribe(mView::showIngredients, throwable -> Log.i("234444", throwable+""));
    }
}
