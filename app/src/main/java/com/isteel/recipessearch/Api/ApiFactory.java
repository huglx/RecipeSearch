package com.isteel.recipessearch.Api;

import androidx.annotation.NonNull;

import com.isteel.recipessearch.BuildConfig;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
public class ApiFactory {

    private static OkHttpClient sClient;

    private static RecipeService sService;

    @NonNull
    public static RecipeService getRecipeService() {
        //I know that double checked locking is not a good pattern, but it's enough here
        RecipeService service = sService;
        if (service == null) {
            synchronized (ApiFactory.class) {
                service = sService;
                if (service == null) {
                    service = sService = createService();
                }
            }
        }
        return service;
    }

    @NonNull
    private static RecipeService createService() {
        return new Retrofit.Builder()
                .baseUrl("https://api.spoonacular.com/recipes/")
                .client(getClient())
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()
                .create(RecipeService.class);
    }

    @NonNull
    private static OkHttpClient getClient() {
        OkHttpClient client = sClient;
        if (client == null) {
            synchronized (ApiFactory.class) {
                client = sClient;
                if (client == null) {
                    client = sClient = buildClient();
                }
            }
        }
        return client;
    }

    @NonNull
    private static OkHttpClient buildClient() {
        return new OkHttpClient.Builder()
                .addInterceptor(new ApiKeyInterceptor())
                .build();
    }
}
