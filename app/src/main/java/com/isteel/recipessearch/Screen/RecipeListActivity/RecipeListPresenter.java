package com.isteel.recipessearch.Screen.RecipeListActivity;

import android.util.Log;

import androidx.lifecycle.LifecycleOwner;

import com.isteel.recipessearch.Repository.RepositoryProvider;
import com.isteel.recipessearch.utils.KeyValueStorage;
import com.isteel.recipessearch.utils.TypeSearchPrefence;
import com.uber.autodispose.AutoDispose;
import com.uber.autodispose.android.lifecycle.AndroidLifecycleScopeProvider;

public class RecipeListPresenter {
    RecipeListView mView;
    LifecycleOwner lifecycleOwner;
    private KeyValueStorage mStorage = RepositoryProvider.getmKeyValueStorage();

    public RecipeListPresenter(RecipeListView mView, LifecycleOwner lifecycleOwner) {
        this.mView = mView;
        this.lifecycleOwner = lifecycleOwner;

    }

    public void init(){
        Log.i("INFO4132", mStorage.getType() + "dsds");
        RepositoryProvider.provideRecipeRepository()
                .recipe(mStorage.getType())
                .doOnSubscribe(mView::showLoading)
                .doOnTerminate(mView::hideLoading)
                .as(AutoDispose.autoDisposable(AndroidLifecycleScopeProvider.from(lifecycleOwner)))
                .subscribe(mView::showRecipeList, throwable -> mView.error());
    }

    public void querySearch(String query){
        RepositoryProvider.provideRecipeRepository()
                .recipe(query, mStorage.getType())
                .doOnSubscribe(mView::showLoading)
                .doOnTerminate(mView::hideLoading)
                .as(AutoDispose.autoDisposable(AndroidLifecycleScopeProvider.from(lifecycleOwner)))
                .subscribe(mView::showRecipeList, throwable -> mView.error());
    }
}
