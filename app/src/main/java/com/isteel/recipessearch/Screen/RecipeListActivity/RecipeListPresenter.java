package com.isteel.recipessearch.Screen.RecipeListActivity;

import android.util.Log;

import androidx.lifecycle.LifecycleOwner;

import com.isteel.recipessearch.Repository.RepositoryProvider;
import com.uber.autodispose.AutoDispose;
import com.uber.autodispose.android.lifecycle.AndroidLifecycleScopeProvider;

public class RecipeListPresenter {
    RecipeListView mView;
<<<<<<< HEAD
    RecipeListActivity mRecipeListActivity;

    public RecipeListPresenter(RecipeListView mView, RecipeListActivity activity) {
=======
    LifecycleOwner lifecycleOwner;
    private KeyValueStorage mStorage = RepositoryProvider.getmKeyValueStorage();

    public RecipeListPresenter(RecipeListView mView, LifecycleOwner lifecycleOwner) {
>>>>>>> 3a0da9f... version 1.25.01
        this.mView = mView;
        this.lifecycleOwner = lifecycleOwner;

    }

    public void init(){
        Log.i("INFO4132", mStorage.getType() + "dsds");
        RepositoryProvider.provideRecipeRepository()
                .recipe()
                .doOnSubscribe(mView::showLoading)
                .doOnTerminate(mView::hideLoading)
<<<<<<< HEAD
                .as(AutoDispose.autoDisposable(AndroidLifecycleScopeProvider.from(mRecipeListActivity)))
                .subscribe(mView::show, throwable -> mView.error());
=======
                .as(AutoDispose.autoDisposable(AndroidLifecycleScopeProvider.from(lifecycleOwner)))
                .subscribe(mView::showRecipeList, throwable -> mView.error());
>>>>>>> 3a0da9f... version 1.25.01
    }

    public void querySearch(String query){
        RepositoryProvider.provideRecipeRepository()
<<<<<<< HEAD
                .recipe(query)
                .as(AutoDispose.autoDisposable(AndroidLifecycleScopeProvider.from(mRecipeListActivity)))
                .subscribe(mView::show, throwable -> Log.i("234444", throwable+""));
=======
                .recipe(query, mStorage.getType())
                .doOnSubscribe(mView::showLoading)
                .doOnTerminate(mView::hideLoading)
                .as(AutoDispose.autoDisposable(AndroidLifecycleScopeProvider.from(lifecycleOwner)))
                .subscribe(mView::showRecipeList, throwable -> mView.error());
>>>>>>> 3a0da9f... version 1.25.01
    }
}
