package com.yj.mvpdaggerretrofitrxjava.dagger.module;

import android.app.ProgressDialog;
import android.content.Context;

import com.yj.mvpdaggerretrofitrxjava.api.ApiService;
import com.yj.mvpdaggerretrofitrxjava.dagger.UIScope;
import com.yj.mvpdaggerretrofitrxjava.mvp.model.HomeModel;
import com.yj.mvpdaggerretrofitrxjava.mvp.presenter.BaseView;
import com.yj.mvpdaggerretrofitrxjava.mvp.presenter.HomePresenter;

import dagger.Module;
import dagger.Provides;

/**
 * Created by YJ on 2017/6/5.
 */

@Module
public class HomeModule {

    private BaseView mView;

    public HomeModule(BaseView view) {
        mView = view;
    }

    @Provides
    @UIScope
    public BaseView provideView() {
        return mView;
    }

    @Provides
    @UIScope
    public HomeModel provideHomeModel(ApiService apiService) {
        return new HomeModel(apiService);
    }

    @Provides
    @UIScope
    public HomePresenter provideHomePresenter(HomeModel model, BaseView view) {
        return new HomePresenter(model, view);
    }

    @Provides
    @UIScope
    public ProgressDialog provideProgressDialog(BaseView view) {
        return new ProgressDialog((Context) view);
    }

}
