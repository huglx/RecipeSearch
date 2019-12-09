package com.isteel.recipessearch.utils;

import androidx.annotation.NonNull;

import com.orhanobut.hawk.Hawk;

import java.lang.reflect.Type;

public class TypeSearchPrefence {
    private static final String TYPE = "type";

    public static String getType() {
        return Hawk.get(TYPE, "");
    }

    public static void setType(@NonNull String type) {
        Hawk.put(TYPE, type);
    }
}
