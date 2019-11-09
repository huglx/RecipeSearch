package com.isteel.recipessearch.utils;

import android.widget.ImageView;

import androidx.annotation.NonNull;

import com.isteel.recipessearch.Content.Recipe;
import com.squareup.picasso.Picasso;

public final class Images {

    public static final String WIDTH_185 = "w185";
    public static final String WIDTH_780 = "w780";

    private Images() {
    }

    public static void loadRecipe(@NonNull ImageView imageView, @NonNull Recipe recipe,
                                 @NonNull String size) {
        loadRecipe(imageView, recipe.getmId(), size);
    }

    public static void loadRecipe(@NonNull ImageView imageView, @NonNull String id,
                                 @NonNull String size) {
        String url = "https://spoonacular.com/recipeImages/" + id + "-"+ size +".jpg";
        Picasso.with(imageView.getContext())
                .load(url)
                .noFade()
                .into(imageView);
    }

    public static void loadIngredients(@NonNull ImageView imageView, @NonNull Recipe recipe,
                                  @NonNull String size) {
        loadIngredients(imageView, recipe.getmId(), size);
    }

    public static void loadIngredients(@NonNull ImageView imageView, @NonNull String name,
                                  @NonNull String size) {
        String url = "https://spoonacular.com/cdn/ingredients_"+ size +"/"+ name;
        Picasso.with(imageView.getContext())
                .load(url)
                .noFade()
                .into(imageView);
    }

}
