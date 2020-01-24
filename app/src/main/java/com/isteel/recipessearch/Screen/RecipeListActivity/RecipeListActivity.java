package com.isteel.recipessearch.Screen.RecipeListActivity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.Toolbar;
<<<<<<< HEAD
=======
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.lifecycle.LifecycleOwner;
>>>>>>> 3a0da9f... version 1.25.01
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.tabs.TabLayout;
<<<<<<< HEAD
import com.isteel.recipessearch.Content.Result;
=======
import com.isteel.recipessearch.Content.Recipe;
import com.isteel.recipessearch.Content.RecipeResponse;
>>>>>>> 3a0da9f... version 1.25.01
import com.isteel.recipessearch.R;
import com.isteel.recipessearch.Repository.RepositoryProvider;
import com.isteel.recipessearch.Screen.StarredActivity.StarredActivity;
import com.isteel.recipessearch.Screen.general.LoadingDialog;
import com.isteel.recipessearch.Screen.general.LoadingView;
<<<<<<< HEAD
import com.miguelcatalan.materialsearchview.MaterialSearchView;

=======
import com.isteel.recipessearch.utils.KeyValueStorage;
import com.isteel.recipessearch.utils.TypeSearchPrefence;
import com.miguelcatalan.materialsearchview.MaterialSearchView;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

>>>>>>> 3a0da9f... version 1.25.01
import butterknife.BindView;
import butterknife.ButterKnife;
import io.reactivex.disposables.Disposable;
//todo appearance of recipe activity(color of toolbar)

public class RecipeListActivity extends AppCompatActivity implements RecipeListView{
    RecipeListPresenter mRecipeListPresenter;
    RecipeListAdapter mRecipeListAdapter;
    private KeyValueStorage mStorage = RepositoryProvider.getmKeyValueStorage();
    RecipeResponse mRecipeResponse = new RecipeResponse();
    List<Recipe> recipes = new ArrayList<>();

    private LoadingView mLoadingView;

    @BindView(R.id.view)
    RecyclerView mRecyclerView;
    @BindView(R.id.toolbar)
    Toolbar mToolbar;
    @BindView(R.id.search_view)
    MaterialSearchView mSearchView;
    @BindView(R.id.action_button)
    FloatingActionButton mActionButton;
<<<<<<< HEAD
=======
    @BindView(R.id.nav_view)
    NavigationView mNavigationView;
//    @BindView(R.id.error_screen)
    AppCompatImageView mError;

    @OnClick(R.id.diet_picker)
    public void diet() {
        setPicker();
    }
>>>>>>> 3a0da9f... version 1.25.01

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.AppTheme);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe_list);
        ButterKnife.bind(this);
        mLoadingView = LoadingDialog.view(getSupportFragmentManager());

        setSupportActionBar(mToolbar);
<<<<<<< HEAD
        getSupportActionBar().setTitle("Recipe search");
        mToolbar.setTitleTextColor(Color.parseColor("#fafafa")); //setting toolbar
=======
        getSupportActionBar().setTitle("Recipes");
        mToolbar.setTitleTextColor(Color.parseColor("#ffffff")); //setting toolbar
        // mRecipeListAdapter = new RecipeAdapter(new Result());

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, mDrawerLayout, mToolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        mDrawerLayout.addDrawerListener(toggle);
        mDrawerLayout.setScrimColor(Color.parseColor("#000000ff"));
        toggle.syncState();
        mNavigationView.setNavigationItemSelectedListener(this);
>>>>>>> 3a0da9f... version 1.25.01

        // mRecipeListAdapter = new RecipeAdapter(new Result());
        createSearchListener();
        setButtonListener();
        mRecyclerView.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));
        mRecyclerView.setHasFixedSize(true);
        mRecipeResponse.setmRecipe(recipes);
        mRecipeListAdapter = new RecipeListAdapter(mRecipeResponse, this);
        mRecyclerView.setAdapter(mRecipeListAdapter);

        LifecycleOwner lifecycleOwner = this;
        mRecipeListPresenter = new RecipeListPresenter(this, lifecycleOwner);
        mRecipeListPresenter.init();
    }

    private void setFABanimation() {
        Animation anim = AnimationUtils.loadAnimation(this, R.anim.fab_rotate);
        mActionButton.startAnimation(anim);
    }

    private void setButtonListener() {
        mActionButton.setOnClickListener(view -> {
<<<<<<< HEAD
        new CountDownTimer(500, 500) { //timer for a small delay in animation to make it look more nicer

            public void onTick(long millisUntilFinished) {
                setFABanimation();
                mActionButton.setEnabled(false);
            }
            public void onFinish() {
                mActionButton.setEnabled(true);
                Intent intent = new Intent(view.getContext(), StarredActivity.class);
                startActivity(intent);
=======
            Intent intent = new Intent(view.getContext(), StarredActivity.class);
            startActivity(intent);
        });
    }

    private void setPicker() {
        AlertDialog.Builder builder = new AlertDialog.Builder(RecipeListActivity.this);
        builder.setTitle("Select Option");
        builder.setSingleChoiceItems(R.array.select_items, mStorage.getCurrentType(), (dialog, which) -> {
            switch (which) {
                case 0:
                    mStorage.setType(TypeSearchPrefence.TYPE_DEF);
                    mRecipeListPresenter.init();
                    break;
                case 1:
                    mStorage.setType(TypeSearchPrefence.TYPE_VEG);
                    mRecipeListPresenter.init();
                    break;
                case 2:
                    break;
                case 3:
                    break;
>>>>>>> 3a0da9f... version 1.25.01
            }
        }.start();
        });
<<<<<<< HEAD
=======
        builder.show();
>>>>>>> 3a0da9f... version 1.25.01
    }

    private void createSearchListener() {
        mSearchView.setOnQueryTextListener(new MaterialSearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                mRecipeListPresenter.querySearch(query);
                return true;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });
        mSearchView.setOnSearchViewListener(new MaterialSearchView.SearchViewListener() {
            @Override
            public void onSearchViewShown() {
                //Do some magic
            }

            @Override
            public void onSearchViewClosed() {
                mRecipeListPresenter.init();
            }
        });

    }

    @Override
<<<<<<< HEAD
    public void show(Result recipes) {
        Log.i("234444", recipes.getmRecipe().get(0).getmTitle());
        mRecipeListAdapter = new RecipeListAdapter(recipes, this);
        mRecyclerView.setAdapter(mRecipeListAdapter);
=======
    public void showRecipeList(RecipeResponse recipes) {

        if(recipes.getmRecipe() != null) {
            mRecipeResponse.getmRecipe().clear();
            mRecipeResponse.setmRecipe(recipes.getmRecipe());
            mRecyclerView.getLayoutManager().scrollToPosition(0);
            mRecipeListAdapter.notifyDataSetChanged();
        }else error();
>>>>>>> 3a0da9f... version 1.25.01
    }

    @Override
    public void error() {/*
        mRecyclerView.setVisibility(View.GONE);
        mActionButton.setVisibility(View.GONE);
        mToolbar.setVisibility(View.GONE);
        mError.setVisibility(View.VISIBLE);*/
        Snackbar snackbar = Snackbar.make(mRecyclerView,R.string.error, Snackbar.LENGTH_LONG)
                .setAction("Try again", action -> mRecipeListPresenter.init());
        snackbar.setDuration(4000);
        snackbar.show();
        //Log.i("Error RLA", throwable.getMessage()+"");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.search_menu, menu);

        MenuItem item = menu.findItem(R.id.action_search);
        mSearchView.setMenuItem(item);

        return true;
    }

    @Override
    public void hideLoading() {
        mLoadingView.hideLoading();
    }

    @Override
    public void showLoading(Disposable disposable) {
        mLoadingView.showLoading(disposable);
    }
<<<<<<< HEAD
=======

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        Intent intent;
        switch (item.getItemId()){
            case R.id.nav_starred:
                intent = new Intent(this, StarredActivity.class);
                startActivity(intent);
                break;
            case R.id.nav_about:
                intent = new Intent(this, AboutActivity.class);
                startActivity(intent);
                break;
        }

        return true;
    }

    @Override
    public void onBackPressed() {
        if (mSearchView.isSearchOpen()) {
            mSearchView.closeSearch();
        }else if (mDrawerLayout.isDrawerOpen(GravityCompat.START)) {
            mDrawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

>>>>>>> 3a0da9f... version 1.25.01
}
