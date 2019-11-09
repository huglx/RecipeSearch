package com.isteel.recipessearch.Screen.Recipe;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.isteel.recipessearch.Content.Steps.ResponseStep;
import com.isteel.recipessearch.R;

import java.util.List;

public class RecipeActivity extends AppCompatActivity implements RecipeView{

    private String mRecipeId;
    private RecipePresenter mRecipePresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe);

        mRecipeId = getIntent().getStringExtra("RECIPE_ID");
        mRecipePresenter = new RecipePresenter(this, this);
        mRecipePresenter.init(mRecipeId);

    }

    @Override
    public void showIngredients(List<ResponseStep> steps) {
        Log.i("0129", mRecipeId);

        Log.i("0129", steps.get(0).getmSteps().get(0).getmStep());
    }
}
