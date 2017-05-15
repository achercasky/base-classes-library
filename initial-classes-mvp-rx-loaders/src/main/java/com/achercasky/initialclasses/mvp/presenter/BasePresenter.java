package com.achercasky.initialclasses.mvp.presenter;


import com.achercasky.initialclasses.mvp.view.BaseMvpView;

import io.reactivex.disposables.CompositeDisposable;

/**
 * Created by arichercasky on 21/3/17.
 */

public class BasePresenter<T extends BaseMvpView> implements Presenter<T> {

    protected T mvpView;
    protected CompositeDisposable compositeSubscription;


    @Override
    public void attachMvpView(T t) {
        this.mvpView = t;
        this.compositeSubscription = new CompositeDisposable();
    }

    @Override
    public void dettachMvpView() {
        this.mvpView = null;
        if (this.compositeSubscription != null)
            this.compositeSubscription.clear();
    }

    public T getMvpView() {
        return this.mvpView;
    }
}
