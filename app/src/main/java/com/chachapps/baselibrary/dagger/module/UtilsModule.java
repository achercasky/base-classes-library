package com.chachapps.baselibrary.dagger.module;

import android.app.ProgressDialog;
import android.content.Context;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by achercasky on 14/05/2017.
 */

@Module
public class UtilsModule {

    @Provides
    @Singleton
    ProgressDialog provideProgressDialog(Context context) {
        ProgressDialog progressDialog = new ProgressDialog(context);
        progressDialog.setMessage("cargando");
        return progressDialog;
    }
}
