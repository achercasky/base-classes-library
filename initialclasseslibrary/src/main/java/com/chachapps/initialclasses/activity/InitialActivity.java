package com.chachapps.initialclasses.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.WindowManager;

import com.chachapps.initialclasses.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by arichercasky on 21/3/17.
 */

public abstract class InitialActivity extends AppCompatActivity implements FragmentManager.OnBackStackChangedListener{

    private String newFragment;
    private String currentFragment;

    private List<String> backStackList;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getSupportFragmentManager().addOnBackStackChangedListener(this);
        backStackList = new ArrayList<>();

        if(isSplashScreen()) {
            getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                    WindowManager.LayoutParams.FLAG_FULLSCREEN);
        }

        bindView();

        injectClass();
    }

    public List<String> getBackStackList() {
        return backStackList;
    }

    protected void clearBackStack() {
        this.backStackList.clear();
    }

    /**
     * This method loads the initial fragment
     *
     * @param fragment
     */
    protected void changeFragment(Fragment fragment) {

        newFragment = fragment.getClass().getName();

        if (currentFragment == null || fragment == null || currentFragment.compareTo(newFragment) != 0) {
            FragmentTransaction t = getSupportFragmentManager().beginTransaction();
//            t.addToBackStack(fragment.getClass().getName());
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
            if (addToBackStack) {
                t.addToBackStack(fragment.getClass().getName());
            } else {
                backStackList.clear();
                backStackList.add(newFragment);
                if (currentFragment != null)
                    t.remove(getSupportFragmentManager().findFragmentByTag(currentFragment));
                currentFragment = newFragment;
            }
            t.setTransition(transition);
            t.add(getMyFragment(), fragment, newFragment);
            t.commit();
        }
    }
//    protected void changeFragment(Fragment fragment, boolean addToBackStack, int transition) {
//
//        newFragment = fragment.getClass().getName();
//
//        if (currentFragment == null || fragment == null || currentFragment.compareTo(newFragment) != 0) {
//            FragmentTransaction t = getSupportFragmentManager().beginTransaction();
//
//            t.setTransition(transition);
//            t.add(getMyFragment(), fragment, newFragment);
//            t.commit();
//        }
//    }

    /**
     * This method replace or add a fragment if you use a bottom navigation view. Also you can set your transition.
     * @param fragment
     * @param addToBackStack
     * @param isFromBottomNavigation
     * @param transition
     */
    protected void changeFragment(Fragment fragment, boolean addToBackStack, boolean isFromBottomNavigation, int transition) {
        newFragment = fragment.getClass().getName();

        if (currentFragment == null || fragment == null || currentFragment.compareTo(newFragment) != 0) {
            FragmentTransaction t = getSupportFragmentManager().beginTransaction();
            if (addToBackStack) {
                t.addToBackStack(fragment.getClass().getName());
            } else {
                backStackList.clear();
                backStackList.add(newFragment);
                if (currentFragment != null)
                    t.remove(getSupportFragmentManager().findFragmentByTag(currentFragment));
//                currentFragment = newFragment;
            }
            t.setTransition(transition);
            if(isFromBottomNavigation) {
                t.replace(getMyFragment(), fragment, newFragment);
            } else {
                t.add(getMyFragment(), fragment, newFragment);
            }
            t.commit();

            //currentFragment = newFragment;
        }
    }

    /**
     * This method replace or add a fragment if you use a bottom navigation view. Also you can set your transition and custom animations.
     * @param fragment
     * @param addToBackStack
     * @param isFromBottomNavigation
     * @param enter
     * @param exit
     */
    protected void changeFragment(Fragment fragment, boolean addToBackStack, boolean isFromBottomNavigation, int enter, int exit, int animEnter, int animExist) {
        newFragment = fragment.getClass().getName();

        if (currentFragment == null || fragment == null || currentFragment.compareTo(newFragment) != 0) {
            FragmentTransaction t = getSupportFragmentManager().beginTransaction();
            if (addToBackStack) {
                t.addToBackStack(fragment.getClass().getName());
            } else {
                backStackList.clear();
                backStackList.add(newFragment);
                if (currentFragment != null)
                    t.remove(getSupportFragmentManager().findFragmentByTag(currentFragment));
                currentFragment = newFragment;
            }
            t.setCustomAnimations(enter, exit, animEnter, animExist);
           // t.setTransition(transition);
            if(isFromBottomNavigation) {
                t.replace(getMyFragment(), fragment, newFragment);
            } else {
                t.add(getMyFragment(), fragment, newFragment);
            }
            t.commit();
        }
    }

    protected void changeFragment(Fragment fragment, boolean addToBackStack, boolean isFromBottomNavigation) {

        newFragment = fragment.getClass().getName();

        if (currentFragment == null || fragment == null || currentFragment.compareTo(newFragment) != 0) {
            FragmentTransaction t = getSupportFragmentManager().beginTransaction();

            t.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);

            if(isFromBottomNavigation) {
                t.replace(getMyFragment(),fragment);
            } else {
                t.add(getMyFragment(), fragment, newFragment);
            }

            t.commit();
        }
    }



    @Override
    public void onBackStackChanged() {
        int count = getSupportFragmentManager().getBackStackEntryCount();
        int lastPos = backStackList.size() - 1;
        FragmentTransaction t = getSupportFragmentManager().beginTransaction();


        if (count > lastPos) {

            if(!backStackList.contains(newFragment)) {

                backStackList.add(newFragment);

                t.hide(getSupportFragmentManager().findFragmentByTag(currentFragment));
                t.show(Fragment.instantiate(this, newFragment));
                currentFragment = newFragment;
                t.commit();
            }

        } else if (count < lastPos) {

            currentFragment = backStackList.get(lastPos);
            backStackList.remove(lastPos);
            t.show(getSupportFragmentManager().findFragmentByTag(backStackList.get(lastPos - 1)));
            currentFragment = backStackList.get(lastPos - 1);
            t.commit();

        }
    }

    public abstract int getMyFragment();

    public abstract boolean isSplashScreen();

    public abstract void bindView();

    public abstract void injectClass();

}
