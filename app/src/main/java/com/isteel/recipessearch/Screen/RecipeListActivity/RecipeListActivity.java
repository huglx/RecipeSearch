package com.isteel.recipessearch.Screen.RecipeListActivity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.isteel.recipessearch.Content.Result;
import com.isteel.recipessearch.R;
import com.miguelcatalan.materialsearchview.MaterialSearchView;

import butterknife.BindView;
import butterknife.ButterKnife;
//todo appearance of recipe activity(color of toolbar)

public class RecipeListActivity extends AppCompatActivity implements RecipeListView{
    RecipeListPresenter mRecipeListPresenter;
    RecipeListAdapter mRecipeListAdapter;

    @BindView(R.id.view)
    RecyclerView mRecyclerView;
    @BindView(R.id.toolbar)
    Toolbar mToolbar;
    @BindView(R.id.search_view)
    MaterialSearchView mSearchView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe_list);
        ButterKnife.bind(this);

        setSupportActionBar(mToolbar);
        getSupportActionBar().setTitle("Recipe search");
        mToolbar.setTitleTextColor(Color.parseColor("#fafafa")); //setting toolbar

        // mRecipeListAdapter = new RecipeAdapter(new Result());
        createSearchListener();

        mRecyclerView = findViewById(R.id.view);
        mRecyclerView.setLayoutManager(new GridLayoutManager(this,2,RecyclerView.VERTICAL, false));
        mRecyclerView.setHasFixedSize(true);

        mRecipeListPresenter = new RecipeListPresenter(this, this);
        mRecipeListPresenter.init();

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
    }

    @Override
    public void show(Result recipes) {
        Log.i("234444", recipes.getmRecipe().get(0).getmTitle());
        mRecipeListAdapter = new RecipeListAdapter(recipes, this);
        mRecyclerView.setAdapter(mRecipeListAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.search_menu, menu);

        MenuItem item = menu.findItem(R.id.action_search);
        mSearchView.setMenuItem(item);

        return true;
    }
}
