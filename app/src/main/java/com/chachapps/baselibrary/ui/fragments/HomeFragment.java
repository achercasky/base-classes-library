package com.chachapps.baselibrary.ui.fragments;


import android.os.Bundle;
import android.support.annotation.Nullable;

import com.chachapps.baselibrary.mvp.MyJsonPresenter;
import com.chachapps.baselibrary.mvp.MyJsonView;
import com.chachapps.initialclasses.fragment.BaseFragment;
import com.chachapps.initialclasses.mvp.view.BaseMvpView;

/**
 * Created by achercasky on 12/03/2018.
 */

public class HomeFragment extends BaseFragment<MyJsonView, MyJsonPresenter> {


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public MyJsonView getMvpView() {
        return null;
    }

    @Override
    protected int getMainLayoutResId() {
        return 0;
    }
}
