package com.isteel.recipessearch.Screen.general;

import android.app.AlertDialog;
import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.Window;
import android.widget.ProgressBar;

import androidx.annotation.NonNull;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.isteel.recipessearch.R;

import java.lang.ref.Reference;
import java.lang.ref.WeakReference;
import java.util.concurrent.atomic.AtomicBoolean;

import io.reactivex.disposables.Disposable;

public class LoadingDialog extends DialogFragment {
    ProgressBar mProgressBar;


    private static final Handler HANDLER = new Handler(Looper.getMainLooper());

    @NonNull
    public static LoadingView view(@NonNull FragmentManager fm) {
        return new LoadingDialogView(fm);
    }

    @NonNull
    public static LoadingView view(@NonNull Fragment fragment) {
        return view(fragment.getFragmentManager());
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setStyle(STYLE_NORMAL, getTheme());
        setCancelable(true);
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        View view = getActivity().getLayoutInflater().inflate(R.layout.dialog_loading, null);
        Drawable drawable = getResources().getDrawable(R.drawable.progress_bar, null);

        this.mProgressBar = view.findViewById(R.id.progress_circular);
        this.mProgressBar.setIndeterminateDrawable(drawable);
        this.mProgressBar.setIndeterminate(true);

        //return new Builder(getActivity(), C1335R.style.DialogTheme).setView(view).create();
        Dialog alertDialog = new Dialog(getActivity());
        alertDialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        alertDialog.setContentView(view);
        alertDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        alertDialog.show();
        return alertDialog;

       /* return new AlertDialog.Builder(getActivity(), R.style.DialogTheme)
                .setView(view)
                .create();*/
    }

    private static class LoadingDialogView implements LoadingView {

        private final FragmentManager mFm;

        private final AtomicBoolean mWaitForHide;

        private LoadingDialogView(@NonNull FragmentManager fm) {
            mFm = fm;
            boolean shown = fm.findFragmentByTag(LoadingDialog.class.getName()) != null;
            mWaitForHide = new AtomicBoolean(shown);
        }

        @Override
        public void showLoading(Disposable disposable) {
            if (mWaitForHide.compareAndSet(false, true)) {
                if (mFm.findFragmentByTag(LoadingDialog.class.getName()) == null) {
                    DialogFragment dialog = new LoadingDialog();
                    dialog.show(mFm, LoadingDialog.class.getName());
                }
            }
        }

        @Override
        public void hideLoading() {
            if (mWaitForHide.compareAndSet(true, false)) {
                HANDLER.post(new HideTask(mFm));
            }
        }
    }

    private static class HideTask implements Runnable {

        private final Reference<FragmentManager> mFmRef;

        private int mAttempts = 10;

        public HideTask(@NonNull FragmentManager fm) {
            mFmRef = new WeakReference<>(fm);
        }

        @Override
        public void run() {
            HANDLER.removeCallbacks(this);
            final FragmentManager fm = mFmRef.get();
            if (fm != null) {
                final LoadingDialog dialog = (LoadingDialog) fm.findFragmentByTag(LoadingDialog.class.getName());
                if (dialog != null) {
                    dialog.dismissAllowingStateLoss();
                } else if (--mAttempts >= 0) {
                    HANDLER.postDelayed(this, 300);
                }
            }
        }
    }

}
