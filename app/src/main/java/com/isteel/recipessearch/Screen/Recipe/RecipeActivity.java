package com.isteel.recipessearch.Screen.Recipe;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;

import com.isteel.recipessearch.Content.Steps.Ingredients.IngredResponse;
import com.isteel.recipessearch.R;
import com.isteel.recipessearch.utils.Images;

import butterknife.BindView;
import butterknife.ButterKnife;


public class RecipeActivity extends AppCompatActivity implements RecipeView{

    private String mRecipeId;
    private String mRecipeName;

    private RecipePresenter mRecipePresenter;
    private RecipeAdapter mRecipeAdapter;

    @BindView(R.id.view)
    RecyclerView mRecyclerView;
    @BindView(R.id.toolbar)
    Toolbar mToolbar;
    @BindView(R.id.imageToolbar)
    ImageView mImageView;

//    TODO Name toolbar like recipe name. Redesign ingred. item. Add step mode.

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe);
        ButterKnife.bind(this);

        setSupportActionBar(mToolbar);
        mRecipeName = getIntent().getStringExtra("RECIPE_NAME");
        getSupportActionBar().setTitle(mRecipeName);
        mToolbar.setTitleTextColor(Color.parseColor("#fafafa")); //setting toolbar
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
        Images.loadRecipe(mImageView, mRecipeId, "636x393");

        Log.i("0129", mRecipeId);

        Log.i("0129", responses.getmIngredients().get(0).getmAmount().getmMetrics().getmValue());
    }
}
