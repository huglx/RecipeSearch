package com.isteel.recipessearch.Content.Steps.Ingredients;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class IngredResponse {
    @SerializedName("ingredients")
    private List<Ingredients> mIngredients;

    public IngredResponse() {
    }

    public List<Ingredients> getmIngredients() {
        return mIngredients;
    }

    public void setmIngredients(List<Ingredients> mIngredients) {
        this.mIngredients = mIngredients;
    }

    public IngredResponse(List<Ingredients> mIngredients) {
        this.mIngredients = mIngredients;
    }
}
