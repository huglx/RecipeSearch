package com.isteel.recipessearch.Screen.Recipe;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.isteel.recipessearch.Content.Steps.Ingredients.IngredResponse;
import com.isteel.recipessearch.Content.Steps.Ingredients.Ingredients;
import com.isteel.recipessearch.R;

public class RecipeAdapter extends RecyclerView.Adapter<RecipeHolder>{
    IngredResponse mResult;
    private Context mContext;

    public RecipeAdapter(@NonNull IngredResponse mResult, @NonNull Context context) {
        this.mResult = mResult;
        mContext = context;
    }

    @NonNull
    @Override
    public RecipeHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new RecipeHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.ingredients_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull RecipeHolder holder, int position) {
        Ingredients ingredients = mResult.getmIngredients().get(position);
        holder.bind(ingredients);
    }

    @Override
    public int getItemCount() {
        return mResult.getmIngredients().size();
    }
}
