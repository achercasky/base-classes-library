package com.chachapps.initialclasses.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.chachapps.initialclasses.mvp.presenter.BasePresenter;
import com.chachapps.initialclasses.mvp.view.BaseMvpView;

/**
 * Created by arichercasky on 21/3/17.
 */

public abstract class BaseFragment <V extends BaseMvpView, P extends BasePresenter<V>> extends Fragment {

    private P presenter;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(getMainLayoutResId(), container, false);
        inflateViews(view);

        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        presenter.attachMvpView(getMvpView());
    }

    @Override
    public void onStop() {
        super.onStop();
        presenter.dettachMvpView();
    }

    public abstract V getMvpView();

    protected abstract int getMainLayoutResId();

    protected void inflateViews(@NonNull View rootView){}
}
