package com.isteel.recipessearch.utils;

import com.orhanobut.hawk.Hawk;

public class TypeSearchPrefence implements KeyValueStorage {
    private static final String TYPE = "type";
    public static final String TYPE_DEF = "";
    public static final String TYPE_VEG = "vegetarian";

    public String getType() {
        return (String) Hawk.get(TYPE, "");
    }

    public void setType(String type) {
        Hawk.put(TYPE, type);
    }

    public int getCurrentType() {
        if (getType().equals("")) {
            return 0;
        }
        if (getType().equals(TYPE_VEG)) {
            return 1;
        }
        return -1;
    }
}
