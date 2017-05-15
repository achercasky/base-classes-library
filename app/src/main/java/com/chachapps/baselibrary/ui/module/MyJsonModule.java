package com.chachapps.baselibrary.ui.module;

import com.chachapps.baselibrary.dagger.scopes.ActivityScope;
import com.chachapps.baselibrary.mvp.MyJsonPresenter;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by achercasky on 14/05/2017.
 */
@Module
public class MyJsonModule {

    @Provides
    @ActivityScope
    MyJsonPresenter provideMyJsonPresenter() {
        return new MyJsonPresenter();
    }
}
