package com.isteel.recipessearch.Screen.Recipe;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
<<<<<<< HEAD
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
=======
import android.view.Menu;
import android.view.MenuItem;
<<<<<<< HEAD
>>>>>>> 3a0da9f... version 1.25.01
=======
>>>>>>> 3a0da9f... version 1.25.01
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.appbar.CollapsingToolbarLayout;
<<<<<<< HEAD
<<<<<<< HEAD
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.isteel.recipessearch.Content.Recipe;
import com.isteel.recipessearch.Content.Steps.Ingredients.IngredResponse;
=======
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;
import com.google.android.material.snackbar.BaseTransientBottomBar;
=======
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;
>>>>>>> 3a0da9f... version 1.25.01
import com.google.android.material.snackbar.Snackbar;
import com.isteel.recipessearch.Content.Recipe;
import com.isteel.recipessearch.Content.Steps.Ingredients.IngredResponse;
import com.isteel.recipessearch.Content.Steps.ResponseStep;
>>>>>>> 3a0da9f... version 1.25.01
import com.isteel.recipessearch.R;
import com.isteel.recipessearch.utils.Images;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.realm.Realm;
import io.realm.RealmObject;
import io.realm.RealmResults;


public class RecipeActivity extends AppCompatActivity implements RecipeView{

    private String mRecipeId;
    private String mRecipeName;
<<<<<<< HEAD
    private boolean ifStarred;
=======
    private String mRecipeTime;
    private String mRecipeServings;


    IngredResponse responses;
>>>>>>> 3a0da9f... version 1.25.01

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
<<<<<<< HEAD
<<<<<<< HEAD
    @BindView(R.id.action_button)
    FloatingActionButton mStarButton;
=======
=======
>>>>>>> 3a0da9f... version 1.25.01
    @BindView(R.id.servings)
    TextView mServingsTV;
    @BindView(R.id.stepsMode)
    ExtendedFloatingActionButton mStepsButton;

    private Menu mMenu;
>>>>>>> 3a0da9f... version 1.25.01

//    TODO Design main page/ adding to fav ones/ step modex

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe);
        ButterKnife.bind(this);
<<<<<<< HEAD
        mRecipeId = getIntent().getStringExtra("RECIPE_ID");
        mRecipeName = getIntent().getStringExtra("RECIPE_NAME");
        setFABanimation();

        if(starred()) {
            mStarButton.setImageDrawable(getDrawable(R.drawable.ic_delete_white_24dp));
            setOnRemoveListener();
        }else {
            mStarButton.setImageDrawable(getDrawable(R.drawable.ic_star_white_24dp));
            setOnStarredListener();
        }
=======
        mLoadingView = LoadingDialog.view(getSupportFragmentManager());

        mRecipeId = getIntent().getStringExtra("RECIPE_ID");
        mRecipeName = getIntent().getStringExtra("RECIPE_NAME");
        mRecipeTime = getIntent().getStringExtra("RECIPE_TIME");
        mRecipeServings = getIntent().getStringExtra("RECIPE_SERVINGS");
<<<<<<< HEAD
>>>>>>> 3a0da9f... version 1.25.01
=======
>>>>>>> 3a0da9f... version 1.25.01

        setSupportActionBar(mToolbar);
        //getSupportActionBar().setTitle(mRecipeName);
        mToolbarLayout.setTitle(mRecipeName);
        mToolbarLayout.setCollapsedTitleTextColor(Color.parseColor("#ffffff"));

        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setHasFixedSize(true);

        mRecipePresenter = new RecipePresenter(this, this);
        mRecipePresenter.init(mRecipeId);

    }

    private void setFABanimation() {

    }

    private void setOnRemoveListener() {
        mStarButton.setOnClickListener(view -> {
            // opens "myrealm.realm"
            try (Realm realm = Realm.getDefaultInstance()) {
                realm.beginTransaction();
                RealmObject recipe = realm.where(Recipe.class).equalTo("mId", mRecipeId).findFirst();
                assert recipe != null;
                recipe.deleteFromRealm();
                realm.commitTransaction();

                Toast.makeText(this, "Your starred recipe was deleted", Toast.LENGTH_SHORT).show();
            }catch (Exception e){
                Toast.makeText(this, "Something went wrong, retry later.", Toast.LENGTH_SHORT).show();
            }
            mStarButton.setImageDrawable(getDrawable(R.drawable.ic_star_white_24dp));
            setOnStarredListener();
        });
    }

<<<<<<< HEAD
    private boolean starred() {
        boolean flag = false;
        Realm realm = Realm.getDefaultInstance();// opens "myrealm.realm"
        RealmResults<Recipe> recipes = realm.where(Recipe.class).findAll();

        for (Recipe recipe : recipes) {
            if (recipe.getmId().equals(mRecipeId)) {
                flag = true;
                Log.i("Starredfunc", flag+"");
            }
=======
    private void addToStarred() {
        // opens "myrealm.realm"
        try (Realm realm = Realm.getDefaultInstance()) {
            realm.beginTransaction();

            Recipe recipe = realm.createObject(Recipe.class);
            recipe.setmId(mRecipeId);
            recipe.setmTitle(mRecipeName);
            recipe.setmTime(mRecipeTime);
            recipe.setWhenAdded(new Date());
            recipe.setServings(mRecipeServings);

            realm.commitTransaction();
            Toast.makeText(this, "Your starred recipe was added", Toast.LENGTH_SHORT).show();
        }catch (Exception e){
            Toast.makeText(this, "Something went wrong, retry later.", Toast.LENGTH_SHORT).show();
<<<<<<< HEAD
>>>>>>> 3a0da9f... version 1.25.01
=======
>>>>>>> 3a0da9f... version 1.25.01
        }

        Log.i("Starredfunc", flag+"");
        return flag;
    }

<<<<<<< HEAD


    private void setOnStarredListener() {
        mStarButton.setOnClickListener(view -> {
            // opens "myrealm.realm"
            try (Realm realm = Realm.getDefaultInstance()) {
                realm.beginTransaction();
                Recipe recipe = realm.createObject(Recipe.class);
                recipe.setmId(mRecipeId);
                recipe.setmTitle(mRecipeName);
                realm.commitTransaction();

                Toast.makeText(this, "Your starred recipe was added", Toast.LENGTH_SHORT).show();
            }catch (Exception e){
                Toast.makeText(this, "Something went wrong, retry later.", Toast.LENGTH_SHORT).show();
            }
            mStarButton.setImageDrawable(getDrawable(R.drawable.ic_delete_white_24dp));
            setOnRemoveListener();
        });
=======
    private boolean alreadyAdded() {
        boolean flag = true;
        try {
            Realm realm = Realm.getDefaultInstance();// opens "myrealm.realm"
            RealmResults<Recipe> recipes = realm.where(Recipe.class).findAll().sort("mId");
            List<Recipe> recipeList = realm.copyFromRealm(recipes);
            int index = AlgorithmUtils.binarySearch(recipeList, Integer.parseInt(mRecipeId));
            if(index == -1){
                flag = false;
            }
            return flag;
        }catch (Exception e){
            error();
            return flag;
        }
    }
>>>>>>> 3a0da9f... version 1.25.01

    }

    @Override
    public void showIngredients(IngredResponse responses) {
<<<<<<< HEAD
        mRecipeAdapter =  new RecipeAdapter(responses, this);
        mRecyclerView.setAdapter(mRecipeAdapter);
        Images.loadRecipe(mImageView, mRecipeId, "636x393");
=======
        this.responses = responses;

        mRecipeAdapter =  new RecipeAdapter(responses, this);
        mRecyclerView.setAdapter(mRecipeAdapter);
        Images.loadRecipe(mImageView, mRecipeId, "636x393");
        mServingsTV.setText(getResources().getString(R.string.servings, mRecipeName, mRecipeServings));
    }

    @Override
    public void showRecipeInfo(Recipe recipe) {
>>>>>>> 3a0da9f... version 1.25.01

        Log.i("0129", mRecipeId);

        Log.i("0129", responses.getmIngredients().get(0).getmAmount().getmMetrics().getmValue());
    }
<<<<<<< HEAD
=======

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        // handle arrow click here
        if (item.getItemId() == R.id.starrItem) {
            if(alreadyAdded()) {
                deleteStarred();
                mMenu.getItem(0).setIcon(R.drawable.ic_star_border_white_24dp);
            }else {
                addToStarred();
                mMenu.getItem(0).setIcon(R.drawable.ic_star_white_24dp);
            }
        }
        if (item.getItemId() == R.id.copy){
            copyIngredients();
        }
        return super.onOptionsItemSelected(item);
    }

    private void copyIngredients() {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < this.responses.getmIngredients().size(); i++) {
            builder.append(responses.getmIngredients().get(i).getmName());
            String str = " ";
            builder.append(str);
            builder.append(responses.getmIngredients().get(i).getmAmount().getmMetrics().getmValue());
            builder.append(str);
            builder.append(responses.getmIngredients().get(i).getmAmount().getmMetrics().getmUnit());
            builder.append("\n");
        }
        ClipboardManager myClipboard = (ClipboardManager) getSystemService(CLIPBOARD_SERVICE);
        myClipboard.setPrimaryClip(ClipData.newPlainText("",builder.toString()));
        Toast.makeText(this, "Ingredients list copied to clipboard", Toast.LENGTH_SHORT).show();

    }

    @Override
    public void error() {
        Snackbar snackbar = Snackbar.make(mRecyclerView,R.string.error, Snackbar.LENGTH_LONG)
                .setAction("Try again", action -> mRecipePresenter.init(mRecipeId));
        snackbar.setDuration(BaseTransientBottomBar.LENGTH_INDEFINITE);
        snackbar.show();
    }


    @Override
    public void hideLoading() { mLoadingView.hideLoading();}

    @Override
    public void showLoading(Disposable disposable) { mLoadingView.showLoading(disposable);}
>>>>>>> 3a0da9f... version 1.25.01
}
