package com.yj.mvpdaggerretrofitrxjava.dagger.component;



import com.yj.mvpdaggerretrofitrxjava.api.ApiService;
import com.yj.mvpdaggerretrofitrxjava.dagger.module.AppModule;
import com.yj.mvpdaggerretrofitrxjava.dagger.module.HttpModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by YJ on 2017/6/5.
 */

@Singleton
@Component(modules = {AppModule.class, HttpModule.class})
public interface AppComponent {

    ApiService getApi();
}
