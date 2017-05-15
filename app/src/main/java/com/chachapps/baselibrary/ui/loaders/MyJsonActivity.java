package com.chachapps.baselibrary.ui.loaders;

import com.chachapps.baselibrary.ui.activities.BaseActivity;
import com.chachapps.baselibrary.ui.fragments.MyJsonFragment;

/**
 * Created by achercasky on 14/05/2017.
 */

public class MyJsonActivity extends BaseActivity {

    @Override
    protected void setInitialFragment() {
        changeFragment(MyJsonFragment.newInstance(), false);
    }

    @Override
    public boolean isSplashScreen() {
        return false;
    }

    @Override
    public void bindView() {

    }

    @Override
    public void injectClass() {

    }
}
