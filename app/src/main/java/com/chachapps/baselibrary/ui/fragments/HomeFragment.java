package com.chachapps.baselibrary.ui.fragments;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.chachapps.baselibrary.R;
import com.chachapps.baselibrary.model.Post;
import com.chachapps.baselibrary.mvp.MyJsonPresenter;
import com.chachapps.baselibrary.mvp.MyJsonView;
import com.chachapps.initialclasses.fragment.BaseFragment;
import com.chachapps.initialclasses.mvp.view.BaseMvpView;

import java.util.List;

/**
 * Created by achercasky on 12/03/2018.
 */

public class HomeFragment extends BaseFragment<MyJsonView, MyJsonPresenter> implements MyJsonView{

    public static HomeFragment newInstance() {

        Bundle args = new Bundle();

        HomeFragment fragment = new HomeFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public MyJsonView getMvpView() {
        return this;
    }

    @Override
    protected int getMainLayoutResId() {
        return R.layout.fragment_my_json;
    }

    @Override
    public Context getMvpContext() {
        return null;
    }

    @Override
    public void onError(Throwable throwable) {

    }

    @Override
    public void onNoInternetConnection() {

    }

    @Override
    public void onErrorCode(String message) {

    }

    @Override
    public void showLoader() {

    }

    @Override
    public void showMainLayout() {

    }

    @Override
    public void receivedPosts(List<Post> postList) {

    }
}
