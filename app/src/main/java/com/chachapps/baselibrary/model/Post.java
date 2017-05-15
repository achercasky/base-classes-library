package com.chachapps.baselibrary.model;

import com.squareup.moshi.Json;

/**
 * Created by achercasky on 14/05/2017.
 */

public class Post {

    @Json(name = "userId")
    private int userId;

    @Json(name = "id")
    private int id;

    @Json(name = "title")
    private String title;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
