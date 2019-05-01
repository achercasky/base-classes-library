package com.chachapps.initial.mvvm.viewmodels;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;

import io.reactivex.disposables.CompositeDisposable;

/**
 * Created by achercasky on 01/05/2019.
 */
public abstract class BaseViewModel<T> extends ViewModel {

    protected final CompositeDisposable compositeDisposable;

    /**
     * Default constructor
     */
    public BaseViewModel() {

        compositeDisposable = new CompositeDisposable();
    }

    /**
     * @return the live data object with the model
     */
    public abstract LiveData<T> getData();

    @Override
    protected void onCleared() {
        super.onCleared();

        if (this.compositeDisposable != null) {
            this.compositeDisposable.clear();
            this.compositeDisposable.dispose();
        }
    }
}