package com.isteel.recipessearch.Content.Steps.Ingredients;

import com.google.gson.annotations.SerializedName;

public class Amount {
    @SerializedName("metric")
    private Metric mMetrics;

    public Amount() {
    }

    public Amount(Metric mMetrics) {
        this.mMetrics = mMetrics;
    }

    public Metric getmMetrics() {
        return mMetrics;
    }

    public void setmMetrics(Metric mValue) {
        this.mMetrics = mValue;
    }
}
