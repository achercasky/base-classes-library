package com.chachapps.initial.mvvm.activities;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.FrameLayout;

import com.chachapps.initial.mvvm.R;
import com.chachapps.initial.mvvm.callbacks.Callback;
import com.chachapps.initial.mvvm.viewmodels.BaseViewModel;

import io.reactivex.disposables.CompositeDisposable;

/**
 * Created by achercasky on 28/04/2019.
 */
public abstract class AbstractActivity<T extends BaseViewModel> extends AppCompatActivity implements Callback {

    private CompositeDisposable mCompositeDisposable;

    private FrameLayout mMainView;
    private FrameLayout mProgressView;
    private FrameLayout mErrorView;
    private FrameLayout mEmptyView;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.initial_abstract_activity);

        mMainView = findViewById(R.id.initial_main_view);
        mProgressView = findViewById(R.id.initial_progress_view);
        mErrorView = findViewById(R.id.initial_error_view);
        mProgressView = findViewById(R.id.initial_error_view);
        mEmptyView = findViewById(R.id.initial_empty_view);

        if (getLayoutResourceId() != 0) {
            mMainView.addView(getLayoutInflater().inflate(getLayoutResourceId(), null));
        }

        mCompositeDisposable = new CompositeDisposable();
    }

    /**
     * @return the ViewModel instance
     */
    protected T getViewModel() {
        if (initViewModel() == null) {
            throw new AssertionError("You must set a View Model class!");
        }

        return (T) ViewModelProviders.of(this).get(initViewModel());
    }

    /**
     * Show the loader
     */
    protected void showProgress() {
        mProgressView.setVisibility(View.VISIBLE);
        mMainView.setVisibility(View.GONE);
        mErrorView.setVisibility(View.GONE);
        mEmptyView.setVisibility(View.GONE);
    }

    /**
     * Show the main layout
     */
    protected void showMainLayout() {
        mMainView.setVisibility(View.VISIBLE);
        mProgressView.setVisibility(View.GONE);
        mEmptyView.setVisibility(View.GONE);
        mErrorView.setVisibility(View.GONE);
    }

    /**
     * Show the error view
     */
    protected void showRetryError() {
        mErrorView.setVisibility(View.VISIBLE);
        mProgressView.setVisibility(View.GONE);
        mMainView.setVisibility(View.GONE);
        mEmptyView.setVisibility(View.GONE);
    }

    /**
     * Show the empty view
     */
    protected void showEmpty() {
        mEmptyView.setVisibility(View.VISIBLE);
        mProgressView.setVisibility(View.GONE);
        mMainView.setVisibility(View.GONE);
        mErrorView.setVisibility(View.GONE);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        mCompositeDisposable.clear();
    }

    /**
     * @return the activity layout
     */
    protected abstract int getLayoutResourceId();

    /**
     * @return the current ViewModel for the activity
     */
    protected abstract Class<? extends BaseViewModel> initViewModel();
}
