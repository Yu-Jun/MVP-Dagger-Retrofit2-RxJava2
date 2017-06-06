package com.yj.mvpdaggerretrofitrxjava.dagger.component;


import com.yj.mvpdaggerretrofitrxjava.MainActivity;
import com.yj.mvpdaggerretrofitrxjava.dagger.UIScope;
import com.yj.mvpdaggerretrofitrxjava.dagger.module.HomeModule;

import dagger.Component;

/**
 * Created by YJ on 2017/6/5.
 */
@UIScope
@Component(modules = {HomeModule.class}, dependencies = AppComponent.class)
public interface HomeComponent {

    void inject(MainActivity mainActivity);

}
