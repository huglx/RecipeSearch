package com.isteel.recipessearch.Repository;

import androidx.annotation.MainThread;
import androidx.annotation.NonNull;

import com.isteel.recipessearch.utils.KeyValueStorage;
import com.isteel.recipessearch.utils.TypeSearchPrefence;

/**
 * @author Artur Vasilov
 */
public final class RepositoryProvider {

    private static KeyValueStorage mKeyValueStorage;
    private static RecipeRepository mRecipeRepository;

    private RepositoryProvider() {
    }

    public static RecipeRepository provideRecipeRepository() {
        if (mRecipeRepository == null) {
            mRecipeRepository = new DefaultRecipeRepository();
        }
        return mRecipeRepository;
    }

    public static void setRecipeRepository(RecipeRepository recipeRepository) {
        mRecipeRepository = recipeRepository;
    }

    public static KeyValueStorage getmKeyValueStorage() {
        if (mKeyValueStorage == null) {
            mKeyValueStorage = new TypeSearchPrefence();
        }
        return mKeyValueStorage;
    }

    public static void setmKeyValueStorage(KeyValueStorage mKeyValueStorage2) {
        mKeyValueStorage = mKeyValueStorage2;
    }


    @MainThread
    public static void init() {
        mRecipeRepository = new DefaultRecipeRepository();
    }
}
