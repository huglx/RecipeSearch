package com.isteel.recipessearch.Screen.StarredActivity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.google.android.material.snackbar.Snackbar;
import com.isteel.recipessearch.Content.Recipe;
import com.isteel.recipessearch.R;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.realm.Realm;
import io.realm.RealmResults;

public class StarredActivity extends AppCompatActivity{
    @BindView(R.id.view)
    RecyclerView mRecyclerView;
    @BindView(R.id.toolbar)
    Toolbar mToolbar;
    @BindView(R.id.adView)
    AdView mAd;
    @BindView(R.id.empty)
    TextView mEmpty;

    private StarredAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_starred);
        ButterKnife.bind(this);

        // Initialize the Mobile Ads SDK.
        MobileAds.initialize(this, initializationStatus -> {});
        // Create an ad request. Check your logcat output for the hashed device ID to
        // get test ads on a physical device. e.g.
        // "Use AdRequest.Builder.addTestDevice("ABCDEF012345") to get test ads on this device."
        AdRequest adRequest = new AdRequest.Builder()
                .build();
        // Start loading the ad in the background.
        mAd.loadAd(adRequest);

        setSupportActionBar(mToolbar);
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_arrow_back_white_24dp);

        mToolbar.setTitleTextColor(Color.parseColor("#fafafa"));
        getSupportActionBar().setTitle("Your starred recipes");

        mRecyclerView.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));
        mRecyclerView.setHasFixedSize(true);

        getCachedRecipe();
    }

    private void getCachedRecipe() {
        // opens "myrealm.realm"
        try (Realm realm = Realm.getDefaultInstance()) {
            RealmResults<Recipe> recipes = realm.where(Recipe.class).findAll();
            Comparator<Recipe> compareByDate = (Recipe o1, Recipe o2) ->
                    o2.getWhenAdded().compareTo( o1.getWhenAdded() );
            List<Recipe> recipeList = realm.copyFromRealm(recipes);
            Collections.sort(recipeList, compareByDate);

            showRecipes(recipeList);
        } catch (Exception e) {
            Snackbar snackbar = Snackbar.make(mRecyclerView,R.string.error, Snackbar.LENGTH_LONG)
                    .setAction("Try again", action -> getCachedRecipe());
            snackbar.setDuration(BaseTransientBottomBar.LENGTH_INDEFINITE);
            snackbar.show();
        }
    }

    private void showRecipes(List<Recipe> recipeList) {
        if (!recipeList.isEmpty()) {
            mRecyclerView.setVisibility(View.VISIBLE);
            mEmpty.setVisibility(View.GONE);
            mAdapter = new StarredAdapter(recipeList, this);
            mRecyclerView.setAdapter(mAdapter);
        }else showEmpty();
    }

    private void showEmpty() {
        mRecyclerView.setVisibility(View.GONE);
        mEmpty.setVisibility(View.VISIBLE);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        // handle arrow click here
        if (item.getItemId() == android.R.id.home) {
            finish(); // close this activity and return to preview activity (if there is any)
        }

        return super.onOptionsItemSelected(item);
    }
}
