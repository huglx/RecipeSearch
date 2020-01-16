package com.isteel.recipessearch.Screen.Recipe;

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
                .ingredients(id)
                .doOnSubscribe(mView::showLoading)
                .doOnTerminate(mView::hideLoading)
                .as(AutoDispose.autoDisposable(AndroidLifecycleScopeProvider.from(mRecipeListActivity)))
                .subscribe(mView::showIngredients, throwable ->  mView.error());

        RepositoryProvider.provideRecipeRepository()
                .recipeInfo(id)
                .doOnSubscribe(mView::showLoading)
                .doOnTerminate(mView::hideLoading)
                .as(AutoDispose.autoDisposable(AndroidLifecycleScopeProvider.from(mRecipeListActivity)))
                .subscribe(mView::showRecipeInfo, throwable ->  mView.error());

    }

    public void initStepsMode(String id){
        RepositoryProvider.provideRecipeRepository()
                .steps(id)
                .doOnSubscribe(mView::showLoading)
                .doOnTerminate(mView::hideLoading)
                .as(AutoDispose.autoDisposable(AndroidLifecycleScopeProvider.from(mRecipeListActivity)))
                .subscribe(mView::initStepsMode, throwable ->  mView.error());
    }
}
