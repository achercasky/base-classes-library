package com.chachapps.initialclasses.mvp.view;

import android.content.Context;

/**
 * Created by arichercasky on 21/3/17.
 */

public interface BaseMvpView {

    Context getMvpContext();

    void onError(Throwable throwable);

    void onNoInternetConnection();

    void showRetryLayout();

    void showMainLayout();

    void showNetworkError();

    void showEmptyLayout();
}
