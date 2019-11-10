package com.isteel.recipessearch.Screen.Recipe;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.isteel.recipessearch.Content.Steps.Ingredients.IngredResponse;
import com.isteel.recipessearch.Content.Steps.ResponseStep;
import com.isteel.recipessearch.R;

import java.util.List;

public class RecipeActivity extends AppCompatActivity implements RecipeView{

    private String mRecipeId;
    private RecipePresenter mRecipePresenter;
    private RecipeAdapter mRecipeAdapter;
    private RecyclerView mRecyclerView;

//    TODO Name toolbar like recipe name. Redesign ingred. item. Add step mode.

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe);

        mRecyclerView = findViewById(R.id.viewIngr);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setHasFixedSize(true);

        mRecipeId = getIntent().getStringExtra("RECIPE_ID");
        mRecipePresenter = new RecipePresenter(this, this);
        mRecipePresenter.init(mRecipeId);

    }

    @Override
    public void showIngredients(IngredResponse responses) {
        mRecipeAdapter =  new RecipeAdapter(responses, this);

        mRecyclerView.setAdapter(mRecipeAdapter);

        Log.i("0129", mRecipeId);

        Log.i("0129", responses.getmIngredients().get(0).getmAmount().getmMetrics().getmValue());
    }
}
