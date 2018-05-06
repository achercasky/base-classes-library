package com.chachapps.baselibrary.mvp;

import com.chachapps.baselibrary.application.SampleApplication;
import com.chachapps.baselibrary.model.Post;
import com.chachapps.baselibrary.service.SampleService;
import com.chachapps.baselibrary.ui.component.DaggerMyJsonComponent;
import com.chachapps.initialclasses.mvp.presenter.BasePresenter;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by achercasky on 14/05/2017.
 */

public class MyJsonPresenter extends BasePresenter<MyJsonView> {

    @Inject
    SampleService service;

    @Inject
    public MyJsonPresenter(){

        DaggerMyJsonComponent.builder()
                .appComponent(SampleApplication.getInstance().getAppComponent()).build();
    }

    public void getPost() {

        Disposable disposable = service.getPosts()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableObserver<List<Post>>() {
                    @Override
                    public void onNext(List<Post> responsePubs) {

                        getMvpView().receivedPosts(responsePubs);
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });

        compositeDisposable.add(disposable);
    }
}
