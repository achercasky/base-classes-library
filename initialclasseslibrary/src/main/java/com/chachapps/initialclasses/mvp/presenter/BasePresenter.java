package com.chachapps.initialclasses.mvp.presenter;

import com.chachapps.initialclasses.mvp.view.BaseMvpView;

import io.reactivex.disposables.CompositeDisposable;

/**
 * Created by arichercasky on 21/3/17.
 */

public abstract class BasePresenter <T extends BaseMvpView> implements Presenter<T> {

    protected T mvpView;
    protected CompositeDisposable compositeDisposable;

    @Override
    public void attachMvpView(T t) {
        this.mvpView = t;
        this.compositeDisposable = new CompositeDisposable();
    }

    @Override
    public void dettachMvpView() {
        this.mvpView = null;
        if (this.compositeDisposable != null)
            this.compositeDisposable.clear();
    }

    public T getMvpView() {
        return this.mvpView;
    }

    protected void checkError() {


    }
}
