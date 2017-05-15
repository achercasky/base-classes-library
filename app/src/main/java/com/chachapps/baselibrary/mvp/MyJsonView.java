package com.chachapps.baselibrary.mvp;

import com.achercasky.initialclasses.mvp.view.BaseMvpView;
import com.chachapps.baselibrary.model.Post;

import java.util.List;

/**
 * Created by achercasky on 14/05/2017.
 */

public interface MyJsonView extends BaseMvpView{

    void receivedPosts(List<Post> postList);
}
