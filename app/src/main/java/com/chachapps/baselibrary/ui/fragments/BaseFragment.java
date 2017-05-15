package com.chachapps.baselibrary.ui.fragments;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.Loader;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.achercasky.initialclasses.mvp.presenter.BasePresenter;
import com.chachapps.baselibrary.ui.activities.BaseActivity;

import butterknife.ButterKnife;

/**
 * Created by achercasky on 14/05/2017.
 */

public abstract class BaseFragment<T> extends Fragment implements LoaderManager.LoaderCallbacks<BasePresenter>{

    protected T callbacks;

    protected BasePresenter basePresenter;

    static final int PRESENTER_LOADER_ID = 1;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        try {
            callbacks = (T) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString() + "must implement callback interface");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        this.callbacks = null;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(getMainLayoutResId(), container, false);
        ButterKnife.bind(this, view);
        inflateViews(view);

        return view;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getLoaderManager().initLoader(PRESENTER_LOADER_ID, null, this);

        basePresenter = getPresenter();
    }

    protected void setRecycler(RecyclerView recyclerView, int columns){
        recyclerView.setHasFixedSize(true);

        recyclerView.setLayoutManager(new GridLayoutManager(getActivity(),columns));
    }

    protected abstract int getMainLayoutResId();

    protected void inflateViews(View rootView){}

    @Override
    public Loader<BasePresenter> onCreateLoader(int id, Bundle args) {
        return getPresenterLoader();
    }

    @Override
    public void onLoadFinished(Loader<BasePresenter> loader, BasePresenter data) {
        basePresenter = data;
    }

    @Override
    public void onLoaderReset(Loader<BasePresenter> loader) {
        basePresenter = null;
    }

    public abstract Loader<BasePresenter> getPresenterLoader();

    public abstract BasePresenter getPresenter();

    protected void showProgress() {
        if(getActivity() != null)
            ((BaseActivity)getActivity()).showProgress();
    }

    protected void hideProgress() {
        if(getActivity() != null)
            ((BaseActivity)getActivity()).hideProgress();
    }

}
