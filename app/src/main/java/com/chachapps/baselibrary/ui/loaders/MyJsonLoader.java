package com.chachapps.baselibrary.ui.loaders;

import android.content.Context;

import com.achercasky.initialclasses.loader.BaseLoader;
import com.chachapps.baselibrary.application.SampleApplication;
import com.chachapps.baselibrary.mvp.MyJsonPresenter;
import com.chachapps.baselibrary.ui.component.DaggerMyJsonComponent;
import com.chachapps.baselibrary.ui.component.MyJsonComponent;
import com.chachapps.baselibrary.ui.module.MyJsonModule;

/**
 * Created by achercasky on 14/05/2017.
 */

public class MyJsonLoader extends BaseLoader<MyJsonPresenter> {

    private MyJsonComponent component;

    /**
     * Stores away the application context associated with context.
     * Since Loaders can be used across multiple activities it's dangerous to
     * store the context directly; always use {@link #getContext()} to retrieve
     * the Loader's Context, don't use the constructor argument directly.
     * The Context returned by {@link #getContext} is safe to use across
     * Activity instances.
     *
     * @param context used to retrieve the application context.
     */
    public MyJsonLoader(Context context) {
        super(context);

        component = DaggerMyJsonComponent.builder()
                .appComponent(SampleApplication.getInstance().getAppComponent())
                .myJsonModule(new MyJsonModule())
                .build();
    }

    @Override
    public MyJsonPresenter getPresenter() {
        return component.myJsonPresenter();
    }
}
