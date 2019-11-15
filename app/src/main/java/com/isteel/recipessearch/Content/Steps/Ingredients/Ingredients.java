package com.isteel.recipessearch.Content.Steps.Ingredients;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Ingredients {
    private boolean ifStarred;

    @SerializedName("id")
    private String mId;

    @SerializedName("name")
    private String mName;

    @SerializedName("image")
    private String mImage;

    @SerializedName("amount")
    private Amount mAmount;

    public Amount getmAmount() {
        return mAmount;
    }

    public void setmAmount(Amount mAmount) {
        this.mAmount = mAmount;
    }

    public Ingredients() {
    }

    public Ingredients(String mId, String mName, String mImage, Amount mAmount) {
        this.mAmount = mAmount;
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

    public boolean isIfStarred() {
        return ifStarred;
    }

    public void setIfStarred(boolean ifStarred) {
        this.ifStarred = ifStarred;
    }
}
