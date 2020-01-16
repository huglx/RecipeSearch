package com.isteel.recipessearch.Screen.RecipeListActivity;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.isteel.recipessearch.Content.Recipe;
import com.isteel.recipessearch.Content.RecipeResponse;
import com.isteel.recipessearch.Content.Steps.ResponseStep;
import com.isteel.recipessearch.R;

public class RecipeListAdapter extends RecyclerView.Adapter<RecipeListHolder>{
    RecipeResponse mResult;
    private Context mContext;

    public RecipeListAdapter(@NonNull RecipeResponse mResult, @NonNull Context context) {
        this.mResult = mResult;
        mContext = context;
    }

    @NonNull
    @Override
    public RecipeListHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new RecipeListHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recipe_item, parent, false), mContext);
    }

    @Override
    public void onBindViewHolder(@NonNull RecipeListHolder holder, int position) {
        Recipe recipe = mResult.getmRecipe().get(position);
        holder.bind(recipe);
    }

    @Override
    public int getItemCount() {
        return mResult.getmRecipe().size();
    }
}
