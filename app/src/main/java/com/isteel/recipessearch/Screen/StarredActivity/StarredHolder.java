package com.isteel.recipessearch.Screen.StarredActivity;


import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.isteel.recipessearch.Content.Recipe;
import com.isteel.recipessearch.R;
import com.isteel.recipessearch.Screen.Recipe.RecipeActivity;
import com.isteel.recipessearch.utils.Images;

import static com.isteel.recipessearch.R.string.cook_time;

public class StarredHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
    TextView mTitle;
    TextView mTime;
    Recipe mRecipe;
    ImageView mRecipeImage;
    Context mContext;

    public StarredHolder(@NonNull View itemView, Context context) {
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
        mTime.setText(mContext.getResources().getString(cook_time,recipe.getmTime()));

        Images.loadRecipe(mRecipeImage, recipe, "312x231");
    }

    @Override
    public void onClick(View view) {
        Log.i("OMOMO", getItemId()+"");
        Intent intent = new Intent(view.getContext(), RecipeActivity.class);
        intent.putExtra("RECIPE_ID", mRecipe.getmId());
        intent.putExtra("RECIPE_NAME", mRecipe.getmTitle());
        intent.putExtra("RECIPE_SERVINGS", mRecipe.getServings());

        view.getContext().startActivity(intent);
    }
}
