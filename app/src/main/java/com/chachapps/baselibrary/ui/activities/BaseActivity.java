//package com.chachapps.baselibrary.ui.activities;
//
//import android.app.ProgressDialog;
//import android.os.Bundle;
//import android.support.annotation.Nullable;
//import android.support.v4.app.Fragment;
//import android.support.v4.app.FragmentTransaction;
//import android.widget.FrameLayout;
//
//import com.chachapps.baselibrary.R;
//import com.chachapps.initialclasses.activity.InitialActivity;
//
///**
// * Created by arichercasky on 31/3/17.
// */
//
//public abstract class BaseActivity extends InitialActivity {
//
//    private FrameLayout frameLayout;
//
//    protected ProgressDialog progressDialog;
//
//    @Override
//    protected void onCreate(@Nullable Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//
//        setContentView(R.layout.activity_base);
//
//        frameLayout = findViewById(R.id.frame);
//
//        progressDialog = new ProgressDialog(this);
//        progressDialog.setMessage("cargando");
//
//        setInitialFragment();
//    }
//
//    @Override
//    public int getMyFragment() {
//        return frameLayout.getId();
//    }
//
//    protected void hideToolBar() {
//        getSupportActionBar().hide();
//    }
//
//    /**
//     * This method is used for the InitialFragment class.
//     *
//     * @param fragment
//     */
//    public void changeFragment(Fragment fragment, boolean addToBackStack) {
//        changeFragment(fragment, addToBackStack, true, FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
//    }
//
//    public void showProgress() {
//        if (progressDialog != null)
//            progressDialog.show();
//    }
//
//    public void hideProgress() {
//        if (progressDialog != null)
//            progressDialog.dismiss();
//    }
//
//    protected abstract void setInitialFragment();
//}
