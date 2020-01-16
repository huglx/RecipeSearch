package com.isteel.recipessearch.utils;

import com.isteel.recipessearch.Content.Recipe;

import java.util.List;

public class AlgorithmUtils {

    public static int binarySearch(List<Recipe> list, int key) {
        int start = 0;
        int end = list.size() - 1;
        while (start < end) {
            int mid = (start + end) / 2;
            if (key < Integer.parseInt(( list.get(mid)).getmId())) {
                end = mid - 1;
            } else if (key < Integer.parseInt(( list.get(mid)).getmId())) {
                return mid;
            } else {
                start = mid + 1;
            }
        }
        return -1;
    }
}
