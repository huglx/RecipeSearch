package com.isteel.recipessearch.Content;

import com.google.gson.annotations.SerializedName;

import io.realm.RealmObject;

public class Recipe extends RealmObject {
    @SerializedName("title")
    private String mTitle;

    @SerializedName("id")
    private String mId;

<<<<<<< HEAD
<<<<<<< HEAD
=======
=======
>>>>>>> 3a0da9f... version 1.25.01
    @SerializedName("servings")
    private String servings;

    private Date whenAdded;

>>>>>>> 3a0da9f... version 1.25.01
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

    public Recipe(String mTitle, String mId) {
        this.mTitle = mTitle;
        this.mId = mId;
    }

    public Recipe() {
    }
<<<<<<< HEAD
=======

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
<<<<<<< HEAD
>>>>>>> 3a0da9f... version 1.25.01
=======
>>>>>>> 3a0da9f... version 1.25.01
}
