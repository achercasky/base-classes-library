package com.achercasky.initialclasses.loader;

import android.content.Context;
import android.support.v4.content.Loader;

import com.achercasky.initialclasses.mvp.presenter.BasePresenter;

/**
 * Created by achercasky on 14/05/2017.
 */

public abstract class BaseLoader <T extends BasePresenter> extends Loader{

    private T presenter;

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
    public BaseLoader(Context context) {
        super(context);
    }

    @Override
    protected void onStartLoading() {
        super.onStartLoading();

        if(presenter != null) {
            deliverResult(presenter);
            return;
        }

        forceLoad();
    }

    @Override
    protected void onForceLoad() {
        super.onForceLoad();

        presenter = getPresenter();

        if(presenter == null) {
            throw new NullPointerException("Presenter is null. Check if the getPresenter() returns null");
        }

        deliverResult(presenter);
    }

    @Override
    protected void onReset() {
        super.onReset();

        if (presenter != null) {
            presenter = null;
        }
    }

    public abstract T getPresenter();
}
