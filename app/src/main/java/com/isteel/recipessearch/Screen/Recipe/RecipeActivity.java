package com.isteel.recipessearch.Screen.Recipe;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.isteel.recipessearch.Content.Recipe;
import com.isteel.recipessearch.Content.Steps.Ingredients.IngredResponse;
import com.isteel.recipessearch.R;
import com.isteel.recipessearch.utils.Images;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.realm.Realm;
import io.realm.RealmResults;


public class RecipeActivity extends AppCompatActivity implements RecipeView{

    private String mRecipeId;
    private String mRecipeName;
    private boolean ifStarred;

    private RecipePresenter mRecipePresenter;
    private RecipeAdapter mRecipeAdapter;

    @BindView(R.id.toolbarTab)
    CollapsingToolbarLayout mToolbarLayout;
    @BindView(R.id.view)
    RecyclerView mRecyclerView;
    @BindView(R.id.toolbar)
    Toolbar mToolbar;
    @BindView(R.id.imageToolbar)
    ImageView mImageView;
    @BindView(R.id.star)
    Button mStarButton;

//    TODO Design main page/ adding to fav ones/ step modex

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe);
        ButterKnife.bind(this);
        mRecipeId = getIntent().getStringExtra("RECIPE_ID");
        mRecipeName = getIntent().getStringExtra("RECIPE_NAME");

        if(starred()) {
            mStarButton.setEnabled(false);
        }else setOnStarredListener();

        setSupportActionBar(mToolbar);
        //getSupportActionBar().setTitle(mRecipeName);
        mToolbarLayout.setTitle(mRecipeName);
        mToolbarLayout.setCollapsedTitleTextColor(Color.parseColor("#ffffff"));

        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setHasFixedSize(true);

        mRecipePresenter = new RecipePresenter(this, this);
        mRecipePresenter.init(mRecipeId);

    }

    private boolean starred() {
        Realm realm = Realm.getDefaultInstance();// opens "myrealm.realm"
        boolean flag = false;
        RealmResults<Recipe> recipes = realm.where(Recipe.class).findAll();
        for (Recipe recipe : recipes) {
            if (recipe.getmId().equals(mRecipeId)) {
                flag = true;
                Log.i("Starredfunc", flag+"");
            }
        }
        Log.i("Starredfunc", flag+"");
        return flag;
    }

    private void setOnStarredListener() {
        mStarButton.setOnClickListener(view -> {
            mStarButton.setEnabled(false);
            Realm realm = Realm.getDefaultInstance();// opens "myrealm.realm"
            try {
                realm.beginTransaction();
                Recipe recipe = realm.createObject(Recipe.class);
                recipe.setmId(mRecipeId);
                recipe.setmTitle(mRecipeName);
                realm.commitTransaction();
            } finally {
                realm.close();
            }
        });
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
