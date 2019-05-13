package com.chachapps.baselibrary;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;


import com.chachapps.initial.mvvm.activities.AbstractActivity;
import com.chachapps.initial.mvvm.viewmodels.BaseViewModel;

public class HomeActivity extends AbstractActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        showToolbar();
        Toolbar mToolbar = findViewById(R.id.my_toolbar);
        setSupportActionBar(mToolbar);
        showToolbar();
//        showMainLayout();
        showProgress();
    }

    @Override
    protected int getLayoutResourceId() {
        return R.layout.activity_home;
    }

    @Override
    protected int getProgressLayoutResourceId() {
        return 0;
    }

    @Override
    protected int getEmptyLayoutResourceId() {
        return 0;
    }

    @Override
    protected int getErrorLayoutResourceId() {
        return 0;
    }

    @Override
    protected int getToolbarLayoutResourceId() {
        return R.layout.toolbar;
    }

    @Override
    protected Class<? extends BaseViewModel> initViewModel() {
        return null;
    }
}
