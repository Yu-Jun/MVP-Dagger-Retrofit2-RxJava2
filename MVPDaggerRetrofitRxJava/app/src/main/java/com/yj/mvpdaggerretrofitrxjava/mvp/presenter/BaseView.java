package com.yj.mvpdaggerretrofitrxjava.mvp.presenter;


import java.util.List;

/**
 * Created by YJ on 2017/6/5.
 */

public interface BaseView {

    void showloading();

    void showDismiss();

    void showError(String msg);

    void showResult(String list);

    void showNoData();
}
