package com.isteel.recipessearch.Screen.StarredActivity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

<<<<<<< HEAD
import com.google.android.material.snackbar.BaseTransientBottomBar;
=======
>>>>>>> 3a0da9f... version 1.25.01
import com.google.android.material.snackbar.Snackbar;
import com.isteel.recipessearch.Content.Recipe;
import com.isteel.recipessearch.Content.Result;
import com.isteel.recipessearch.R;
import com.isteel.recipessearch.Screen.RecipeListActivity.RecipeListAdapter;

<<<<<<< HEAD
=======
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
<<<<<<< HEAD
>>>>>>> 3a0da9f... version 1.25.01
=======
>>>>>>> 3a0da9f... version 1.25.01
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
<<<<<<< HEAD
<<<<<<< HEAD
            List<Recipe> recipeList = realm.copyFromRealm(recipes);
            mAdapter = new StarredAdapter(recipeList, this);
            mRecyclerView.setAdapter(mAdapter);
            // Toast.makeText(this, ""+recipes.get(0).getmId(), Toast.LENGTH_SHORT).show();
        } catch (Exception ignored) {

=======
            Comparator<Recipe> compareByDate = (Recipe o1, Recipe o2) ->
                    o2.getWhenAdded().compareTo( o1.getWhenAdded() );
            List<Recipe> recipeList = realm.copyFromRealm(recipes);
=======
            Comparator<Recipe> compareByDate = (Recipe o1, Recipe o2) ->
                    o2.getWhenAdded().compareTo( o1.getWhenAdded() );
            List<Recipe> recipeList = realm.copyFromRealm(recipes);
>>>>>>> 3a0da9f... version 1.25.01
            Collections.sort(recipeList, compareByDate);
            Log.i("INFO", Arrays.toString(recipeList.toArray()));

            mAdapter = new StarredAdapter(recipeList, this);
            mRecyclerView.setAdapter(mAdapter);
        } catch (Exception e) {
            Snackbar snackbar = Snackbar.make(mRecyclerView,R.string.error, Snackbar.LENGTH_LONG)
                    .setAction("Try again", action -> getCachedRecipe());
<<<<<<< HEAD
            snackbar.setDuration(BaseTransientBottomBar.LENGTH_INDEFINITE);
            snackbar.show();
>>>>>>> 3a0da9f... version 1.25.01
=======
            snackbar.setDuration(4000);
            snackbar.show();
>>>>>>> 3a0da9f... version 1.25.01
        }
    }

    @Override
    public void show(Result recipes) {

    }
}
