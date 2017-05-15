package com.chachapps.baselibrary.dagger.component;

import android.app.ProgressDialog;
import android.content.Context;

import com.chachapps.baselibrary.dagger.module.AppModule;
import com.chachapps.baselibrary.dagger.module.NetModule;
import com.chachapps.baselibrary.dagger.module.UtilsModule;
import com.chachapps.baselibrary.service.SampleService;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by achercasky on 14/05/2017.
 */

@Singleton
@Component( modules = {AppModule.class, NetModule.class, UtilsModule.class} )
public interface AppComponent {

    Context getContext();
    SampleService getSampleService();
    ProgressDialog getProgressDialog();

}
