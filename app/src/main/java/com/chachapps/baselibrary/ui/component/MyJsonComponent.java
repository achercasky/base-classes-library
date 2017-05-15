package com.chachapps.baselibrary.ui.component;

import android.app.ProgressDialog;

import com.chachapps.baselibrary.dagger.component.AppComponent;
import com.chachapps.baselibrary.dagger.scopes.ActivityScope;
import com.chachapps.baselibrary.mvp.MyJsonPresenter;
import com.chachapps.baselibrary.ui.fragments.MyJsonFragment;
import com.chachapps.baselibrary.ui.module.MyJsonModule;

import dagger.Component;

/**
 * Created by achercasky on 14/05/2017.
 */

@ActivityScope
@Component(dependencies = AppComponent.class)
public interface MyJsonComponent {
    MyJsonPresenter myJsonPresenter();
}
