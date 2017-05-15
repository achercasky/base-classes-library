package com.chachapps.baselibrary.ui.fragments;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.content.Loader;
import android.util.Log;
import android.widget.Toast;

import com.achercasky.initialclasses.mvp.presenter.BasePresenter;
import com.chachapps.baselibrary.R;
import com.chachapps.baselibrary.application.SampleApplication;
import com.chachapps.baselibrary.dagger.component.DaggerAppComponent;
import com.chachapps.baselibrary.model.Post;
import com.chachapps.baselibrary.mvp.MyJsonPresenter;
import com.chachapps.baselibrary.mvp.MyJsonView;
import com.chachapps.baselibrary.ui.component.DaggerMyJsonComponent;
import com.chachapps.baselibrary.ui.loaders.MyJsonLoader;
import com.chachapps.baselibrary.ui.module.MyJsonModule;

import java.util.List;

import javax.inject.Inject;


/**
 * Created by achercasky on 14/05/2017.
 */

public class MyJsonFragment extends BaseFragment implements MyJsonView{

    @Inject
    MyJsonPresenter presenter;

//    @Inject


    public static MyJsonFragment newInstance() {
        
        Bundle args = new Bundle();
        
        MyJsonFragment fragment = new MyJsonFragment();
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    protected int getMainLayoutResId() {
        return R.layout.fragment_my_json;
    }

    @Override
    public Loader<BasePresenter> getPresenterLoader() {
        return new MyJsonLoader(getContext());
    }

    @Override
    public BasePresenter getPresenter() {
        return new MyJsonPresenter();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

     DaggerMyJsonComponent.builder()
                .appComponent(SampleApplication.getInstance().getAppComponent())
                .myJsonModule(new MyJsonModule()).build().inject(this);

        showProgress();
    }

    @Override
    public void onResume() {
        super.onResume();
//

        presenter.attachMvpView(this);
        presenter.getPost();
    }

    @Override
    public Context getMvpContext() {
        return getActivity();
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
    public void receivedPosts(List<Post> postList) {
        hideProgress();

        Toast.makeText(getActivity(), postList.get(0).getTitle(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onStop() {
        super.onStop();

        Log.i("Paso", "paso por en onStop");
        hideProgress();
        presenter.dettachMvpView();
    }
}
