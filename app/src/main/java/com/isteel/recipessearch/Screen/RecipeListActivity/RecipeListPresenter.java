package com.isteel.recipessearch.Screen.RecipeListActivity;

import android.util.Log;

import com.isteel.recipessearch.Repository.RepositoryProvider;
import com.uber.autodispose.AutoDispose;
import com.uber.autodispose.android.lifecycle.AndroidLifecycleScopeProvider;

public class RecipeListPresenter {
    RecipeListView mView;
    RecipeListActivity mRecipeListActivity;

    public RecipeListPresenter(RecipeListView mView, RecipeListActivity activity) {
        this.mView = mView;
        mRecipeListActivity = activity;

    }

    public void init(){
        RepositoryProvider.provideRecipeRepository()
                .recipe()
                .as(AutoDispose.autoDisposable(AndroidLifecycleScopeProvider.from(mRecipeListActivity)))
                .subscribe(mView::show, throwable -> Log.i("234444", throwable+""));
    }

    public void querySearch(String query){
        RepositoryProvider.provideRecipeRepository()
                .recipe(query)
                .as(AutoDispose.autoDisposable(AndroidLifecycleScopeProvider.from(mRecipeListActivity)))
                .subscribe(mView::show, throwable -> Log.i("234444", throwable+""));
    }
}
