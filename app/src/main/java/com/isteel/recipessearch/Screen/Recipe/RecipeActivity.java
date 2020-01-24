package com.isteel.recipessearch.Screen.Recipe;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.isteel.recipessearch.Content.Recipe;
import com.isteel.recipessearch.Content.Steps.Ingredients.IngredResponse;
import com.isteel.recipessearch.Content.Steps.ResponseStep;
import com.isteel.recipessearch.R;
import com.isteel.recipessearch.Screen.Recipe.BottomSheet.BottomSheetFragment;
import com.isteel.recipessearch.Screen.general.LoadingDialog;
import com.isteel.recipessearch.Screen.general.LoadingView;
import com.isteel.recipessearch.utils.AlgorithmUtils;
import com.isteel.recipessearch.utils.Images;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import io.reactivex.disposables.Disposable;
import io.realm.Realm;
import io.realm.RealmObject;
import io.realm.RealmResults;


public class RecipeActivity extends AppCompatActivity implements RecipeView{
    private LoadingView mLoadingView;

    private String mRecipeId;
    private String mRecipeName;
    private String mRecipeTime;
    private String mRecipeServings;


    IngredResponse responses;

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
    @BindView(R.id.servings)
    TextView mServingsTV;
    @BindView(R.id.stepsMode)
    ExtendedFloatingActionButton mStepsButton;

    private Menu mMenu;

    @OnClick(R.id.stepsMode)
    public void showBottomSheetDialogFragment() {
        //init presenter
        mRecipePresenter.initStepsMode(mRecipeId);
    }

//    TODO Design main page/ step modex

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe);
        ButterKnife.bind(this);
        mLoadingView = LoadingDialog.view(getSupportFragmentManager());

        mRecipeId = getIntent().getStringExtra("RECIPE_ID");
        mRecipeName = getIntent().getStringExtra("RECIPE_NAME");
        mRecipeTime = getIntent().getStringExtra("RECIPE_TIME");
        mRecipeServings = getIntent().getStringExtra("RECIPE_SERVINGS");

        setSupportActionBar(mToolbar);
        //getSupportActionBar().setTitle(mRecipeName);
        mToolbarLayout.setTitle(mRecipeName);
        mToolbarLayout.setCollapsedTitleTextColor(Color.parseColor("#ffffff"));

        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setHasFixedSize(true);

        mRecipePresenter = new RecipePresenter(this, this);
        mRecipePresenter.init(mRecipeId);
    }

    private void deleteStarred() {
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
                Log.i("Error", e.getMessage());
            }
    }

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
        }
    }

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

    @Override
    public void initStepsMode(List<ResponseStep> steps) {
        BottomSheetFragment bottomSheetFragment = new BottomSheetFragment();
        Bundle bundle = new Bundle();
        bundle.putSerializable("content", (Serializable) steps.get(0));
        bottomSheetFragment.setArguments(bundle);
        bottomSheetFragment.show(getSupportFragmentManager(), bottomSheetFragment.getTag());
    }

    @Override
    public void showIngredients(IngredResponse responses) {
        this.responses = responses;

        mRecipeAdapter =  new RecipeAdapter(responses, this);
        mRecyclerView.setAdapter(mRecipeAdapter);
        Images.loadRecipe(mImageView, mRecipeId, "636x393");
        mServingsTV.setText(getResources().getString(R.string.servings, mRecipeName, mRecipeServings));
    }

    @Override
    public void showRecipeInfo(Recipe recipe) {

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        mMenu = menu;
        getMenuInflater().inflate(R.menu.recipe_menu, menu);
            if(alreadyAdded()) {
                mMenu.getItem(0).setIcon(R.drawable.ic_star_white_24dp);
            }else {
                mMenu.getItem(0).setIcon(R.drawable.ic_star_border_white_24dp);
            }
        return true;
    }

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
        snackbar.setDuration(4000);
        snackbar.show();
    }


    @Override
    public void hideLoading() { mLoadingView.hideLoading();}

    @Override
    public void showLoading(Disposable disposable) { mLoadingView.showLoading(disposable);}
}
