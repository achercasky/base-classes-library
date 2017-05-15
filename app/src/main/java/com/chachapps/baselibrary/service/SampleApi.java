package com.chachapps.baselibrary.service;

import com.chachapps.baselibrary.model.Post;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.POST;

/**
 * Created by achercasky on 14/05/2017.
 */

public interface SampleApi {

    @GET("posts")
    Observable<List<Post>> post();
}
