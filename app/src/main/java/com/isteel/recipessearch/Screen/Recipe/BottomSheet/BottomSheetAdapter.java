package com.isteel.recipessearch.Screen.Recipe.BottomSheet;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.isteel.recipessearch.Content.Steps.ResponseStep;
import com.isteel.recipessearch.Content.Steps.Step;
import com.isteel.recipessearch.R;

public class BottomSheetAdapter extends RecyclerView.Adapter<BottomSheetHolder> {
    final ResponseStep mResult;

    public BottomSheetAdapter(@NonNull ResponseStep mResult) {
        this.mResult = mResult;
    }

    @NonNull
    @Override
    public BottomSheetHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new BottomSheetHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.bottom_sheet_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull BottomSheetHolder holder, int position) {
        Step step = mResult.getmSteps().get(position);
        holder.bind(step);
    }

    @Override
    public int getItemCount() {
        return mResult.getmSteps().size();
    }
}

