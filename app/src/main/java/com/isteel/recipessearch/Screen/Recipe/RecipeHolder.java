package com.isteel.recipessearch.Screen.Recipe;


import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.isteel.recipessearch.Content.Steps.Ingredients.Ingredients;
import com.isteel.recipessearch.R;

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
