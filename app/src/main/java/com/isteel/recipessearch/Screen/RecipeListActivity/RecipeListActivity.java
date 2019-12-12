package com.isteel.recipessearch.Screen.RecipeListActivity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import androidx.viewpager.widget.ViewPager;

import android.content.DialogInterface;
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
import android.widget.Button;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.tabs.TabLayout;
import com.isteel.recipessearch.Content.Result;
import com.isteel.recipessearch.R;
import com.isteel.recipessearch.Screen.StarredActivity.StarredActivity;
import com.isteel.recipessearch.Screen.general.LoadingDialog;
import com.isteel.recipessearch.Screen.general.LoadingView;
import com.isteel.recipessearch.utils.TypeSearchPrefence;
import com.miguelcatalan.materialsearchview.MaterialSearchView;

import java.lang.reflect.Type;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import io.reactivex.disposables.Disposable;
//todo redo onclinck||selector

public class RecipeListActivity extends AppCompatActivity implements RecipeListView, NavigationView.OnNavigationItemSelectedListener {
    RecipeListPresenter mRecipeListPresenter;
    RecipeListAdapter mRecipeListAdapter;

    private LoadingView mLoadingView;

    @BindView(R.id.view)
    RecyclerView mRecyclerView;
    @BindView(R.id.drawer_layout)
    DrawerLayout mDrawerLayout;
    @BindView(R.id.toolbar)
    Toolbar mToolbar;
    @BindView(R.id.search_view)
    MaterialSearchView mSearchView;
    @BindView(R.id.action_button)
    FloatingActionButton mActionButton;
    @BindView(R.id.nav_view)
    NavigationView mNavigationView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe_list);
        ButterKnife.bind(this);

        mLoadingView = LoadingDialog.view(getSupportFragmentManager());
        createSearchListener();
        setButtonListener();

        setSupportActionBar(mToolbar);
        getSupportActionBar().setTitle("");
        mToolbar.setTitleTextColor(Color.parseColor("#ffffff")); //setting toolbar
        // mRecipeListAdapter = new RecipeAdapter(new Result());

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, mDrawerLayout, mToolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        mDrawerLayout.addDrawerListener(toggle);
        mDrawerLayout.setScrimColor(Color.parseColor("#fafafa"));
        toggle.syncState();
        mNavigationView.setNavigationItemSelectedListener(this);

        mRecyclerView.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));
        mRecyclerView.setHasFixedSize(true);

        mRecipeListPresenter = new RecipeListPresenter(this, this);
        mRecipeListPresenter.init();
    }

    private void setButtonListener() {
        mActionButton.setOnClickListener(view -> {
        new CountDownTimer(500, 500) { //timer for a small delay in animation to make it look more nicer

            public void onTick(long millisUntilFinished) {
                Animation anim = AnimationUtils.loadAnimation(view.getContext(), R.anim.fab_rotate);
                mActionButton.startAnimation(anim);

                mActionButton.setEnabled(false);
            }
            public void onFinish() {
                mActionButton.setEnabled(true);

                Intent intent = new Intent(view.getContext(), StarredActivity.class);
                startActivity(intent);
            }
        }.start();
        });
    }

   /* private void setSelector() {
        AlertDialog.Builder builder = new AlertDialog.Builder(RecipeListActivity.this);
        builder.setTitle("Select Option");
        builder.setItems(R.array.select_items, (dialog, which) -> {
            Log.e("value is", "" + which);
            switch (which) {
                case 0:
                    TypeSearchPrefence.setType("Def");
                    break;
                case 1:
                    TypeSearchPrefence.setType("Vegi");
                    break;
                case 2:
                    break;
                case 3:
                    break;
            }
        });
        builder.show();
    }*/

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
    }

    @Override
    public void showRecipeList(Result recipes) {
        mRecipeListAdapter = new RecipeListAdapter(recipes, this);
        mRecyclerView.setAdapter(mRecipeListAdapter);
    }

    @Override
    public void error() {
        Snackbar snackbar = Snackbar.make(mRecyclerView,"Something went wrong", Snackbar.LENGTH_LONG)
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

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        return false;
    }
}
