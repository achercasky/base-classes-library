package com.chachapps.baselibrary.dagger.module;

import android.content.Context;

import com.chachapps.baselibrary.application.SampleApplication;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by achercasky on 14/05/2017.
 */

@Module
public class AppModule {

    private final SampleApplication app;

    public AppModule(SampleApplication app) {
        this.app = app;
    }

    @Provides
    @Singleton
    public Context provideContext() {
        return app;
    }

}