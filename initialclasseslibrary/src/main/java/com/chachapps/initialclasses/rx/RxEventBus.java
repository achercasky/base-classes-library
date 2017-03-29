package com.chachapps.initialclasses.rx;

import android.os.Handler;
import android.os.Looper;

import io.reactivex.Observable;
import io.reactivex.functions.Action;
import io.reactivex.subjects.PublishSubject;


/**
 * Created by arichercasky on 29/3/17.
 */

public class RxEventBus {

    private static RxEventBus instance;

    private final PublishSubject<Object> eventBus = PublishSubject.create();

    public static RxEventBus getInstance() {
        if (instance == null)
            instance = new RxEventBus();
        return instance;
    }

    private RxEventBus() {}

    public void send(Object o) {
        eventBus.onNext(o);
    }

    public Observable<Object> toObservable() {
        return eventBus;
    }

    public boolean hasObservers() {
        return eventBus.hasObservers();
    }
}
