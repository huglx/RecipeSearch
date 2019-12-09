package com.isteel.recipessearch.Content.Steps;

import com.google.gson.annotations.SerializedName;
import com.isteel.recipessearch.Content.Steps.Ingredients.Ingredients;

import java.util.List;

public class Step {
    private Ingredients mIngredients;

    @SerializedName("step")
    private String mStep;

    @SerializedName("number")
    private String mNumber;

    public Step() {
    }

    public Step(Ingredients mIngredients, String mStep, String mNumber) {
        this.mIngredients = mIngredients;
        this.mStep = mStep;
        this.mNumber = mNumber;
    }

    public Ingredients getmIngredients() {
        return mIngredients;
    }

    public void setmIngredients(Ingredients mIngredients) {
        this.mIngredients = mIngredients;
    }

    public String getmStep() {
        return mStep;
    }

    public void setmStep(String mStep) {
        this.mStep = mStep;
    }

    public String getmNumber() {
        return mNumber;
    }

    public void setmNumber(String mNumber) {
        this.mNumber = mNumber;
    }
}
