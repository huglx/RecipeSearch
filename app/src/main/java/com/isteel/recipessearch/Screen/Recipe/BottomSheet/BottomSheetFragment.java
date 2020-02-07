package com.isteel.recipessearch.Screen.Recipe.BottomSheet;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.isteel.recipessearch.Content.Steps.ResponseStep;
import com.isteel.recipessearch.R;

import butterknife.BindView;
import butterknife.ButterKnife;


public class BottomSheetFragment extends BottomSheetDialogFragment {
    @BindView(R.id.recyclerView)
    RecyclerView mRecyclerView;
    @BindView(R.id.adView)
    AdView mAd;


    private ResponseStep mResult;
    private Context mContext;
    private BottomSheetAdapter mBottomSheetAdapter;

    public BottomSheetFragment() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        mContext = context;
    }

    @Override
    public void onDetach() {
        super.onDetach();
        if(mContext!=null) {
            mContext = null;
        }
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

        // Initialize the Mobile Ads SDK.
        if(mContext != null) {
            MobileAds.initialize(mContext, initializationStatus -> {
            });
        }
        // Create an ad request. Check your logcat output for the hashed device ID to
        // get test ads on a physical device. e.g.
        // "Use AdRequest.Builder.addTestDevice("ABCDEF012345") to get test ads on this device."
        AdRequest adRequest = new AdRequest.Builder()
                .build();
        // Start loading the ad in the background.
        mAd.loadAd(adRequest);

        Bundle bundle = getArguments();
        if (bundle != null) {
            this.mResult = (ResponseStep) bundle.getSerializable("content");
        }

        if(mContext != null) {
            mRecyclerView.setLayoutManager(new LinearLayoutManager(mContext));
            mRecyclerView.setHasFixedSize(true);

            mBottomSheetAdapter = new BottomSheetAdapter(mResult);
        }
        mRecyclerView.setAdapter(mBottomSheetAdapter);
        // Inflate the layout for this fragment
        return view;
    }

}
