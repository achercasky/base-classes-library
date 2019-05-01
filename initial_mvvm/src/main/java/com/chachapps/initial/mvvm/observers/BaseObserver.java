package com.chachapps.initial.mvvm.observers;

import android.arch.lifecycle.Observer;
import android.support.annotation.NonNull;

/**
 * Created by achercasky on 01/05/2019.
 *
 * @param <P> the callback interface
 * @param <T> the dto response
 */
public abstract class BaseObserver<P, T> implements Observer<T> {

    private final P callback;

    /**
     * Default constructor
     *
     * @param callback the view's callback
     */
    public BaseObserver(@NonNull final P callback) {
        this.callback = callback;
    }

    protected P getCallback() {
        return callback;
    }
}