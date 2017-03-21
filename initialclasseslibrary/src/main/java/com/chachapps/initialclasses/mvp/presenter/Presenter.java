package com.chachapps.initialclasses.mvp.presenter;

/**
 * Created by arichercasky on 21/3/17.
 */

public interface Presenter <MvpView> {

    void attachMvpView(MvpView mvpView);

    void dettachMvpView();
}
