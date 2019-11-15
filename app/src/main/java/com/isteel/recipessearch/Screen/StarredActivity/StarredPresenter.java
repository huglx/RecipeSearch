package com.isteel.recipessearch.Screen.StarredActivity;

import android.util.Log;

import com.isteel.recipessearch.Repository.RepositoryProvider;
import com.isteel.recipessearch.Screen.RecipeListActivity.RecipeListActivity;
import com.isteel.recipessearch.Screen.RecipeListActivity.RecipeListView;
import com.uber.autodispose.AutoDispose;
import com.uber.autodispose.android.lifecycle.AndroidLifecycleScopeProvider;

public class StarredPresenter {
    StarredView mView;
    StarredActivity mRecipeListActivity;

    public StarredPresenter(StarredView mView, StarredActivity activity) {
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
