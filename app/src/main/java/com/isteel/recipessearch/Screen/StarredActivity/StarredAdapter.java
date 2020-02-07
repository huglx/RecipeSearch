package com.isteel.recipessearch.Screen.StarredActivity;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.isteel.recipessearch.Content.Recipe;
import com.isteel.recipessearch.R;

import java.util.List;

public class StarredAdapter extends RecyclerView.Adapter<StarredHolder>{
    List<Recipe> mResult;
    private Context mContext;

    public StarredAdapter(@NonNull List<Recipe> mResult, @NonNull Context context) {
        this.mResult = mResult;
        mContext = context;
    }


    @NonNull
    @Override
    public StarredHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new StarredHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recipe_item, parent, false), mContext);
    }

    @Override
    public void onBindViewHolder(@NonNull StarredHolder holder, int position) {
        Recipe recipe = mResult.get(position);
        holder.bind(recipe);
    }

    @Override
    public int getItemCount() {
        return mResult.size();
    }
}
