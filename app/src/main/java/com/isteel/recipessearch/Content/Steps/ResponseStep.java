package com.isteel.recipessearch.Content.Steps;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ResponseStep {
    @SerializedName("steps")
    private List<Step> mSteps;

    public ResponseStep() {
    }

    public ResponseStep(List<Step> mSteps) {
        this.mSteps = mSteps;
    }

    public List<Step> getmSteps() {
        return mSteps;
    }

    public void setmSteps(List<Step> mSteps) {
        this.mSteps = mSteps;
    }
}
