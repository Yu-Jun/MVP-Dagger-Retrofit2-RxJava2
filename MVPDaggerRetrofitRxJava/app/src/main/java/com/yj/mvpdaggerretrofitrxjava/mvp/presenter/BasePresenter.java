package com.yj.mvpdaggerretrofitrxjava.mvp.presenter;

/**
 * Created by YJ on 2017/6/5.
 */

public abstract class BasePresenter<T, V extends BaseView> {

    protected V mView;
    protected T mModel;

    public BasePresenter(T model, V view) {
        mModel = model;
        mView = view;
    }

    protected abstract void requestData();

}
