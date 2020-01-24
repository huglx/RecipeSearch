package com.isteel.recipessearch.Content;

import com.google.gson.annotations.SerializedName;

import java.util.Date;

import io.realm.RealmObject;

public class Recipe extends RealmObject {
    @SerializedName("healthScore")
    private String healthScore;

    @SerializedName("title")
    private String mTitle;

    @SerializedName("readyInMinutes")
    private String mTime;

    @SerializedName("id")
    private String mId;

    @SerializedName("servings")
    private String servings;

    private Date whenAdded;

    public String getmId() {
        return mId;
    }

    public void setmId(String mId) {
        this.mId = mId;
    }

    public String getmTitle() {
        return mTitle;
    }

    public void setmTitle(String mTitle) {
        this.mTitle = mTitle;
    }

    public Recipe(String mTitle, String mId, String mTime) {
        this.mTitle = mTitle;
        this.mId = mId;
        this.mTime = mTime;
    }

    public String getmTime() {
        return mTime;
    }

    public void setmTime(String mTime) {
        this.mTime = mTime;
    }

    public Recipe() {
    }

    public String getHealthScore() {
        return healthScore;
    }

    public void setHealthScore(String healthScore) {
        this.healthScore = healthScore;
    }

    public Date getWhenAdded() {
        return whenAdded;
    }

    public void setWhenAdded(Date whenAdded) {
        this.whenAdded = whenAdded;
    }

    public String getServings() {
        return servings;
    }

    public void setServings(String servings) {
        this.servings = servings;
    }
}
