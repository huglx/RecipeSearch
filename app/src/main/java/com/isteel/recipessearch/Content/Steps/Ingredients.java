package com.isteel.recipessearch.Content.Steps;

import com.google.gson.annotations.SerializedName;

public class Ingredients {
    @SerializedName("id")
    private String mId;

    @SerializedName("name")
    private String mName;

    @SerializedName("image")
    private String mImage;

    public Ingredients() {
    }

    public Ingredients(String mId, String mName, String mImage) {
        this.mId = mId;
        this.mName = mName;
        this.mImage = mImage;
    }

    public String getmId() {
        return mId;
    }

    public void setmId(String mId) {
        this.mId = mId;
    }

    public String getmName() {
        return mName;
    }

    public void setmName(String mName) {
        this.mName = mName;
    }

    public String getmImage() {
        return mImage;
    }

    public void setmImage(String mImage) {
        this.mImage = mImage;
    }
}
