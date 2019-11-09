package com.isteel.recipessearch.Screen.Recipe;

import com.isteel.recipessearch.Content.Result;
import com.isteel.recipessearch.Content.Steps.Ingredients;
import com.isteel.recipessearch.Content.Steps.ResponseStep;

import java.util.List;

public interface RecipeView {
    void showIngredients(List<ResponseStep> steps);

}
