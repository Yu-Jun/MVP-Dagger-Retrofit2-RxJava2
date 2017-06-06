package com.yj.mvpdaggerretrofitrxjava;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.Toast;

import com.yj.mvpdaggerretrofitrxjava.dagger.component.DaggerHomeComponent;
import com.yj.mvpdaggerretrofitrxjava.dagger.module.HomeModule;
import com.yj.mvpdaggerretrofitrxjava.mvp.presenter.BaseView;
import com.yj.mvpdaggerretrofitrxjava.mvp.presenter.HomePresenter;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity implements BaseView {

    @Inject
    HomePresenter mHomePresenter;

    @Inject
    ProgressDialog mProgressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        DaggerHomeComponent.builder()
                .appComponent(MyApplication.get(this).getAppComponent())
                .homeModule(new HomeModule(this))
                .build()
                .inject(this);
        mHomePresenter.requestData();
    }

    @Override
    public void showloading() {
        mProgressDialog.show();
    }

    @Override
    public void showDismiss() {
        mProgressDialog.dismiss();
    }

    @Override
    public void showError(String msg) {
        mProgressDialog.dismiss();
        Toast.makeText(this, "" + msg, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showResult(String list) {
        Toast.makeText(this, "SUCCESS:" + list.toString(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showNoData() {
        Toast.makeText(this, "" + "数据NULL", Toast.LENGTH_SHORT).show();

    }
}
