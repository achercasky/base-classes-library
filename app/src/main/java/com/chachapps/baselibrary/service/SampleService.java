package com.chachapps.baselibrary.service;

import com.chachapps.baselibrary.model.Post;
import com.squareup.moshi.Moshi;

import java.util.List;

import io.reactivex.Observable;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.moshi.MoshiConverterFactory;

/**
 * Created by achercasky on 14/05/2017.
 */

public class SampleService {

    private Retrofit retrofit;

    private SampleApi api;

    public SampleService(String baseUrl, OkHttpClient okHttpClient, Moshi moshi) {

        if(retrofit == null || api == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(baseUrl)
                    .client(okHttpClient)
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .addConverterFactory(MoshiConverterFactory.create(moshi))
                    .build();

            api = retrofit.create(SampleApi.class);
        }
    }

    public Observable<List<Post>> getPosts() {
        return api.post();
    }
}
