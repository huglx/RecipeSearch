package com.isteel.recipessearch.Screen.RecipeListActivity;

import android.util.Log;

import com.isteel.recipessearch.Repository.RepositoryProvider;
import com.isteel.recipessearch.utils.TypeSearchPrefence;
import com.uber.autodispose.AutoDispose;
import com.uber.autodispose.android.lifecycle.AndroidLifecycleScopeProvider;

import java.lang.reflect.Type;

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
                .doOnSubscribe(mView::showLoading)
                .doOnTerminate(mView::hideLoading)
                .as(AutoDispose.autoDisposable(AndroidLifecycleScopeProvider.from(mRecipeListActivity)))
                .subscribe(mView::show, throwable -> mView.error());
    }

    public void querySearch(String query){
        Log.i("HAWK", TypeSearchPrefence.getType());

        RepositoryProvider.provideRecipeRepository()
                .recipe(query)
                .as(AutoDispose.autoDisposable(AndroidLifecycleScopeProvider.from(mRecipeListActivity)))
                .subscribe(mView::show, throwable -> Log.i("234444", throwable+""));
    }
}
