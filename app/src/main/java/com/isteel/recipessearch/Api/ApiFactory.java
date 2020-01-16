package com.isteel.recipessearch.Api;

import androidx.annotation.NonNull;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
public class ApiFactory {

    private static OkHttpClient sClient;

    private static DefaultRecipeService sService;

    @NonNull
    public static DefaultRecipeService getRecipeService() {
        //I know that double checked locking is not a good pattern, but it's enough here
        DefaultRecipeService service = sService;
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
    private static DefaultRecipeService createService() {
        return new Retrofit.Builder()
                .baseUrl("https://api.spoonacular.com/recipes/")
                .client(getClient())
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()
                .create(DefaultRecipeService.class);
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
