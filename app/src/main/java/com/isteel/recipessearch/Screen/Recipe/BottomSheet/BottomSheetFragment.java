package com.isteel.recipessearch.Screen.Recipe.BottomSheet;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.bottomappbar.BottomAppBar;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.isteel.recipessearch.Content.Steps.Ingredients.IngredResponse;
import com.isteel.recipessearch.Content.Steps.ResponseStep;
import com.isteel.recipessearch.R;
import com.isteel.recipessearch.Screen.Recipe.RecipeAdapter;
import com.isteel.recipessearch.Screen.RecipeListActivity.RecipeListAdapter;

import butterknife.BindView;
import butterknife.ButterKnife;


public class BottomSheetFragment extends BottomSheetDialogFragment {
    @BindView(R.id.recyclerView)
    RecyclerView mRecyclerView;

    private ResponseStep mResult;
    private IngredResponse responses;
    private BottomSheetAdapter mBottomSheetAdapter;

    public BottomSheetFragment(ResponseStep mResult) {
        this.mResult = mResult;
    }

    public BottomSheetFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_bottom_sheet_dialog, container, false);
        ButterKnife.bind(this, view);

        //  mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity(),LinearLayoutManager.HORIZONTAL, false));
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        mRecyclerView.setHasFixedSize(true);

        mBottomSheetAdapter = new BottomSheetAdapter(mResult, getActivity());

        mRecyclerView.setAdapter(mBottomSheetAdapter);
        // Inflate the layout for this fragment
        return view;
    }

}
