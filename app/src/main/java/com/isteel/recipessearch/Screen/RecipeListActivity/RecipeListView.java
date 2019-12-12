package com.isteel.recipessearch.Screen.RecipeListActivity;

import com.isteel.recipessearch.Content.Result;
import com.isteel.recipessearch.Screen.general.LoadingView;

public interface RecipeListView extends LoadingView {
    void showRecipeList(Result recipes);

    void error();
}
