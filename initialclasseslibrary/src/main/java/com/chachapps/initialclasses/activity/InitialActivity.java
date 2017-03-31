package com.chachapps.initialclasses.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import com.chachapps.initialclasses.R;

/**
 * Created by arichercasky on 21/3/17.
 */

public abstract class InitialActivity extends AppCompatActivity{

    private String newFragment;
    private String currentFragment;

    public abstract int getMyFragment();

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
}
