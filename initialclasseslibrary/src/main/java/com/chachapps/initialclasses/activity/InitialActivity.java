package com.chachapps.initialclasses.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.WindowManager;

import com.chachapps.initialclasses.R;

/**
 * Created by arichercasky on 21/3/17.
 */

public abstract class InitialActivity extends AppCompatActivity{

    private String newFragment;
    private String currentFragment;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if(isSplashScreen()) {
            getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                    WindowManager.LayoutParams.FLAG_FULLSCREEN);
        }

        bindView();

        injectClass();

        initListeners();
    }

    /**
     * This method loads the initial fragment
     *
     * @param fragment
     * @param addToBackStack
     */
    protected void changeFragment(Fragment fragment, boolean addToBackStack) {

        newFragment = fragment.getClass().getName();

        if (currentFragment == null || fragment == null || currentFragment.compareTo(newFragment) != 0) {
            FragmentTransaction t = getSupportFragmentManager().beginTransaction();

            t.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
            t.add(getMyFragment(), fragment, newFragment);
            t.commit();
        }
    }

    /**
     * This method loads the fragment with the parameter to define a transition
     * @param fragment
     * @param addToBackStack
     * @param transition
     */
    protected void changeFragment(Fragment fragment, boolean addToBackStack, int transition) {

        newFragment = fragment.getClass().getName();

        if (currentFragment == null || fragment == null || currentFragment.compareTo(newFragment) != 0) {
            FragmentTransaction t = getSupportFragmentManager().beginTransaction();

            t.setTransition(transition);
            t.add(getMyFragment(), fragment, newFragment);
            t.commit();
        }
    }

    protected abstract int getMyFragment();

    protected abstract boolean isSplashScreen();

    protected abstract void bindView();

    protected abstract void injectClass();

    protected abstract void initListeners();
}
