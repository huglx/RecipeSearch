package com.isteel.recipessearch.Screen.RecipeListActivity;

import android.util.Log;

import com.isteel.recipessearch.Repository.RepositoryProvider;
import com.isteel.recipessearch.utils.KeyValueStorage;
import com.isteel.recipessearch.utils.TypeSearchPrefence;
import com.uber.autodispose.AutoDispose;
import com.uber.autodispose.android.lifecycle.AndroidLifecycleScopeProvider;

public class RecipeListPresenter {
    RecipeListView mView;
    RecipeListActivity mRecipeListActivity;
    private KeyValueStorage mStorage = RepositoryProvider.getmKeyValueStorage();


    public RecipeListPresenter(RecipeListView mView, RecipeListActivity activity) {
        this.mView = mView;
        mRecipeListActivity = activity;

    }

    public void init(){
        RepositoryProvider.provideRecipeRepository()
                .recipe(mStorage.getType())
                .doOnSubscribe(mView::showLoading)
                .doOnTerminate(mView::hideLoading)
                .as(AutoDispose.autoDisposable(AndroidLifecycleScopeProvider.from(mRecipeListActivity)))
                .subscribe(mView::showRecipeList, throwable -> mView.error());
    }

    public void querySearch(String query){
        RepositoryProvider.provideRecipeRepository()
                .recipe(query, mStorage.getType())
                .as(AutoDispose.autoDisposable(AndroidLifecycleScopeProvider.from(mRecipeListActivity)))
                .subscribe(mView::showRecipeList, throwable -> Log.i("234444", throwable+""));
    }
}
