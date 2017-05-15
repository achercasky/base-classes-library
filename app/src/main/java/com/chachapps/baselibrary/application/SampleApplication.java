package com.chachapps.baselibrary.application;

import android.app.Application;

import com.chachapps.baselibrary.dagger.component.AppComponent;
import com.chachapps.baselibrary.dagger.component.DaggerAppComponent;
import com.chachapps.baselibrary.dagger.module.AppModule;
import com.chachapps.baselibrary.dagger.module.NetModule;
import com.chachapps.baselibrary.dagger.module.UtilsModule;

/**
 * Created by achercasky on 14/05/2017.
 */

public class SampleApplication extends Application {

    private static AppComponent component;

    private static SampleApplication instance;

    @Override
    public void onCreate() {
        super.onCreate();

        getAppComponent();
    }

    public AppComponent getAppComponent() {

        if(component == null) {
            component = DaggerAppComponent.builder()
                    .appModule(new AppModule(this))
                    .netModule(new NetModule("https://jsonplaceholder.typicode.com/"))
//                    .utilsModule(new UtilsModule())
                    .build();
        }

        return component;
    }

    public static SampleApplication getInstance() {

        if(instance == null) {
            instance = new SampleApplication();
        }

        return instance;
    }
}
