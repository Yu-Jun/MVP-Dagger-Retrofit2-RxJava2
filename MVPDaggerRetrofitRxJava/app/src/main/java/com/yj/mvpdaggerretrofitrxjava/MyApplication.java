package com.yj.mvpdaggerretrofitrxjava;

import android.app.Application;
import android.content.Context;

import com.yj.mvpdaggerretrofitrxjava.dagger.component.AppComponent;
import com.yj.mvpdaggerretrofitrxjava.dagger.component.DaggerAppComponent;
import com.yj.mvpdaggerretrofitrxjava.dagger.module.AppModule;
import com.yj.mvpdaggerretrofitrxjava.dagger.module.HttpModule;


/**
 * Created by YJ on 2017/6/5.
 */

public class MyApplication extends Application {

    private AppComponent mAppComponent;

    public static MyApplication get(Context context) {
        return (MyApplication) context.getApplicationContext();
    }

    public AppComponent getAppComponent() {
        return mAppComponent;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        mAppComponent = DaggerAppComponent.builder().appModule(new AppModule(this)).httpModule(new HttpModule()).build();
    }
}
