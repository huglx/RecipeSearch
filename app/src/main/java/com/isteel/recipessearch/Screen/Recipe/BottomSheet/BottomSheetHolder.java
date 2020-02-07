package com.isteel.recipessearch.Screen.Recipe.BottomSheet;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.isteel.recipessearch.Content.Steps.Step;
import com.isteel.recipessearch.R;

public class BottomSheetHolder extends RecyclerView.ViewHolder {
    TextView mStepText;
    TextView mStepNumber;


    public BottomSheetHolder(@NonNull View itemView) {
        super(itemView);
        mStepText = itemView.findViewById(R.id.stepText);
        mStepNumber = itemView.findViewById(R.id.stepNumber);
    }


    public void bind(Step step) {
        mStepText.setText(step.getmStep());
        mStepNumber.setText(step.getmNumber());
    }


}
