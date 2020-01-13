package com.isteel.recipessearch.Content;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Result {
    @SerializedName("results")
    private List<Recipe> mRecipe;

    public List<Recipe> getmRecipe() {
        return mRecipe;
    }

    public void setmRecipe(List<Recipe> mRecipe) {
        this.mRecipe = mRecipe;
    }
}
