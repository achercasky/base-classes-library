package com.chachapps.baselibrary.ui.loaders;

import com.chachapps.baselibrary.ui.activities.BaseActivity;
import com.chachapps.baselibrary.ui.fragments.HomeFragment;

/**
 * Created by achercasky on 14/05/2017.
 */

public class MyJsonActivity extends BaseActivity {

    @Override
    protected void setInitialFragment() {
        changeFragment(HomeFragment.newInstance(), false);
    }

    @Override
    public boolean isSplashScreen() {
        return false;
    }

    @Override
    public String[] getPermissions() {
        return null;
    }

    @Override
    public void onPermissionAccepted() {

    }

    @Override
    public void onPermissionDenied() {

    }
}
