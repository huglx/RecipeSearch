package com.isteel.recipessearch.Repository;

import androidx.annotation.MainThread;
import androidx.annotation.NonNull;

/**
 * @author Artur Vasilov
 */
public final class RepositoryProvider {

    private static RecipeRepository mRecipeRepository;

    private RepositoryProvider() {
    }

    @NonNull
    public static RecipeRepository provideRecipeRepository() {
        if (mRecipeRepository == null) {
            mRecipeRepository = new DefaultRecipeRepository();
        }
        return mRecipeRepository;
    }

    public static void setRecipeRepository(@NonNull RecipeRepository recipeRepository) {
        mRecipeRepository = recipeRepository;
    }

    @MainThread
    public static void init() {
        mRecipeRepository = new DefaultRecipeRepository();
    }
}
