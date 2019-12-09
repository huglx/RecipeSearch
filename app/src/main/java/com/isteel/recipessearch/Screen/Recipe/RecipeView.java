package com.isteel.recipessearch.Screen.Recipe;

import com.isteel.recipessearch.Content.Steps.Ingredients.IngredResponse;
import com.isteel.recipessearch.Content.Steps.ResponseStep;
import com.isteel.recipessearch.Screen.general.LoadingView;

import java.util.List;

public interface RecipeView extends LoadingView {

    void showIngredients(IngredResponse igredients);
    void initStepsMode(List<ResponseStep> steps);

    void error();

}
