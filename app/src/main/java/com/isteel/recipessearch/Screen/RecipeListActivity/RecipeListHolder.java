package com.isteel.recipessearch.Screen.RecipeListActivity;


import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.drawable.IconCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.isteel.recipessearch.Content.Recipe;
import com.isteel.recipessearch.R;
import com.isteel.recipessearch.Screen.Recipe.RecipeActivity;
import com.isteel.recipessearch.utils.Images;

import static android.provider.Settings.Secure.getString;
import static com.isteel.recipessearch.R.string.cook_time;

public class RecipeListHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
    TextView mTitle;
    TextView mTime;
    Recipe mRecipe;
    ImageView mRecipeImage;
    Context mContext;


    public RecipeListHolder(@NonNull View itemView, Context context) {
        super(itemView);
        mContext = context;

        itemView.setOnClickListener(this);
        mTitle = itemView.findViewById(R.id.title);
        mTime = itemView.findViewById(R.id.time);
        mRecipeImage = itemView.findViewById(R.id.recipeImage);
    }


    public void bind(Recipe recipe) {
        mRecipe = recipe;
        mTitle.setText(recipe.getmTitle());
       // String content =  + recipe.getmTime();
        mTime.setText(mContext.getResources().getString(cook_time,recipe.getmTime()));
        Images.loadRecipe(mRecipeImage, recipe, "556x370");
    }

    @Override
    public void onClick(View view) {
        Log.i("OMOMO", getItemId()+"");
        Intent intent = new Intent(view.getContext(), RecipeActivity.class);
        intent.putExtra("RECIPE_ID", mRecipe.getmId());
        intent.putExtra("RECIPE_NAME", mRecipe.getmTitle());
        intent.putExtra("RECIPE_TIME", mRecipe.getmTime());

        view.getContext().startActivity(intent);
    }
}
