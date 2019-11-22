package com.isteel.recipessearch.Screen.StarredActivity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
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

public class StarredActivity extends AppCompatActivity implements StarredView{
    @BindView(R.id.view)
    RecyclerView mRecyclerView;

    private StarredPresenter mPresenter;
    private StarredAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_starred);
        ButterKnife.bind(this);

        mRecyclerView.setLayoutManager(new GridLayoutManager(this,2,RecyclerView.VERTICAL, false));
        mRecyclerView.setHasFixedSize(true);

        mPresenter = new StarredPresenter(this, this);
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

        }
    }

    @Override
    public void show(Result recipes) {

    }
}
