package com.isteel.recipessearch.Content.Steps;

import com.google.gson.annotations.SerializedName;
import com.isteel.recipessearch.Content.Steps.Ingredients.Ingredients;

import java.io.Serializable;

public class Step implements Serializable {

    @SerializedName("step")
    private String mStep;

    @SerializedName("number")
    private String mNumber;

    public Step() {
    }

    public Step( String mStep, String mNumber) {
        this.mStep = mStep;
        this.mNumber = mNumber;
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
