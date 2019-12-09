package com.isteel.recipessearch.Screen.StarredActivity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.isteel.recipessearch.Content.Recipe;
import com.isteel.recipessearch.Content.Result;
import com.isteel.recipessearch.R;
import com.isteel.recipessearch.Screen.RecipeListActivity.RecipeListAdapter;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.realm.Realm;
import io.realm.RealmResults;

public class StarredActivity extends AppCompatActivity{
    @BindView(R.id.view)
    RecyclerView mRecyclerView;
    @BindView(R.id.toolbar)
    Toolbar mToolbar;

    private StarredAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_starred);
        ButterKnife.bind(this);

        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
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
            List<Recipe> recipeList = realm.copyFromRealm(recipes);
            mAdapter = new StarredAdapter(recipeList, this);
            mRecyclerView.setAdapter(mAdapter);
            // Toast.makeText(this, ""+recipes.get(0).getmId(), Toast.LENGTH_SHORT).show();
        } catch (Exception ignored) {
            Toast.makeText(this, "Something went wrong", Toast.LENGTH_SHORT).show();
        }
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
