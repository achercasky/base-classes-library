package com.chachapps.baselibrary.dagger.module;

import android.app.ProgressDialog;
import android.content.Context;

import com.chachapps.baselibrary.service.SampleService;
import com.squareup.moshi.Moshi;

import java.util.concurrent.TimeUnit;


import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;

/**
 * Created by achercasky on 14/05/2017.
 */

@Module
public class NetModule {

    private String baseUrl;

    public NetModule(String baseUrl) {
        this.baseUrl = baseUrl;
    }

    @Provides
    @Singleton
    Moshi provideMoshi(){
        return new Moshi.Builder().build();
    }

    @Provides
    @Singleton
    OkHttpClient provideOkHttpClientInterceptor() {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        return new OkHttpClient.Builder().connectTimeout(30, TimeUnit.SECONDS).readTimeout(30, TimeUnit.SECONDS).
                addInterceptor(interceptor).build();
    }

    @Provides
    @Singleton
    SampleService provideSampleService(Moshi moshi, OkHttpClient okHttpClient) {
        return new SampleService(baseUrl, okHttpClient, moshi);
    }
}
