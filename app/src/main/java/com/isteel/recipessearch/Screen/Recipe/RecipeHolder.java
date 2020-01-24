package com.isteel.recipessearch.Screen.Recipe;


import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.isteel.recipessearch.Content.Recipe;
import com.isteel.recipessearch.Content.Steps.Ingredients.Ingredients;
import com.isteel.recipessearch.R;
import com.isteel.recipessearch.utils.Images;

public class RecipeHolder extends RecyclerView.ViewHolder{
    TextView mName;
    TextView mValue;
    Ingredients mIngredients;

    public RecipeHolder(@NonNull View itemView) {
        super(itemView);
        mName = itemView.findViewById(R.id.name);
        mValue = itemView.findViewById(R.id.value);

    }


    public void bind(Ingredients ingredients) {
        mIngredients = ingredients;
        mName.setText(ingredients.getmName());
        String value = ingredients.getmAmount().getmMetrics().getmValue() + ingredients.getmAmount().getmMetrics().getmUnit();
        mValue.setText(value);
    }

}
