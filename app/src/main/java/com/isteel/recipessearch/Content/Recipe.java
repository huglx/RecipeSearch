package com.isteel.recipessearch.Content;

import com.google.gson.annotations.SerializedName;

import io.realm.RealmObject;

public class Recipe extends RealmObject {
    @SerializedName("title")
    private String mTitle;

    @SerializedName("readyInMinutes")
    private String mTime;

    @SerializedName("id")
    private String mId;

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
}
