package com.isteel.recipessearch.Content.Steps.Ingredients;
// TODO make ingredients content

import com.google.gson.annotations.SerializedName;

public class Metric {
    @SerializedName("unit")
    private String mUnit;

    @SerializedName("value")
    private String mValue;

    public Metric() {
    }

    public Metric(String mUnit, String mValue) {
        this.mUnit = mUnit;
        this.mValue = mValue;
    }

    public String getmUnit() {
        return mUnit;
    }

    public void setmUnit(String mUnit) {
        this.mUnit = mUnit;
    }

    public String getmValue() {
        return mValue;
    }

    public void setmValue(String mValue) {
        this.mValue = mValue;
    }
}
