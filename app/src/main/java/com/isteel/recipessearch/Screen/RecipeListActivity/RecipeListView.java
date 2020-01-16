package com.isteel.recipessearch.Screen.RecipeListActivity;

import com.isteel.recipessearch.Content.RecipeResponse;
import com.isteel.recipessearch.Screen.general.LoadingView;

public interface RecipeListView extends LoadingView {
    void showRecipeList(RecipeResponse recipes);

    void error();
}
