package com.isteel.recipessearch.Api;

import com.isteel.recipessearch.Content.Recipe;
import com.isteel.recipessearch.Content.Result;
import com.isteel.recipessearch.Content.Steps.ResponseStep;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface RecipeService {

    @GET("search?apiKey=6bbcc5cb6b1b46f9986d188fd72c1d65")
    Observable<Result> recipe();

    @GET("search?apiKey=6bbcc5cb6b1b46f9986d188fd72c1d65")
    Observable<Result> recipe(@Query("query") String query);

    @GET("{id}/analyzedInstructions?apiKey=6bbcc5cb6b1b46f9986d188fd72c1d65")
    Observable<List<ResponseStep>> steps(@Path("id") String id);
}
