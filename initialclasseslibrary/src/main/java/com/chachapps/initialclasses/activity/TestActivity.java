package com.chachapps.initialclasses.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.WindowManager;

import com.chachapps.initialclasses.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by achercasky on 25/08/2017.
 */

public abstract class TestActivity extends AppCompatActivity {

    private String newFragment;
    private String currentFragment;

    private List<String> backStackList;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

//        getSupportFragmentManager().addOnBackStackChangedListener(this);
        backStackList = new ArrayList<>();

        if(isSplashScreen()) {
            getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                    WindowManager.LayoutParams.FLAG_FULLSCREEN);
        }

        bindView();

        injectClass();
    }

    protected void changeFragment(Fragment fragment, Boolean addToBackStack) {
        fragment.setArguments(getIntent().getExtras());
        newFragment = fragment.getClass().getName();

        if (currentFragment == null || fragment == null || currentFragment.compareTo(newFragment) != 0) {
            FragmentTransaction t = getSupportFragmentManager().beginTransaction();
//            t.setCustomAnimations(R.anim.fade_in, R.anim.fade_out);
            t.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
            if (currentFragment != null) {
                t.detach(getSupportFragmentManager().findFragmentByTag(currentFragment));
            }

            t.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
            if (getSupportFragmentManager().findFragmentByTag (newFragment) != null) {
                t.attach(getSupportFragmentManager().findFragmentByTag(newFragment));
            } else {
                t.add(getMyFragment(), fragment, newFragment);
            }

            if (addToBackStack) {
                t.addToBackStack(fragment.getClass().getName());
                backStackList.add(newFragment);
            }else {
                backStackList.clear();
                backStackList.add(newFragment);
            }


            currentFragment = newFragment;

            t.commit();
            getSupportFragmentManager().executePendingTransactions();
        }
    }

    @Override
    public void onBackPressed() {
//        setAnimation();
        if (backStackList.size() > 0 ) {
            getFragmentManager().popBackStack();
            backStackList.remove(backStackList.size() - 1);
            if (backStackList.size() > 0) {
                currentFragment = backStackList.get(backStackList.size() - 1);
            }
        }

        super.onBackPressed();
    }

    protected Fragment getCurrentFragment() {
        return getSupportFragmentManager().findFragmentByTag(currentFragment);
    }

    public abstract int getMyFragment();

    public abstract boolean isSplashScreen();

    public abstract void bindView();

    public abstract void injectClass();
}
