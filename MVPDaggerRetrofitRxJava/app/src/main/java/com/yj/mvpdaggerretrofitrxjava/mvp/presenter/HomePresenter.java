package com.yj.mvpdaggerretrofitrxjava.mvp.presenter;

import com.yj.mvpdaggerretrofitrxjava.mvp.model.HomeModel;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import okhttp3.ResponseBody;

/**
 * Created by YJ on 2017/6/5.
 */

public class HomePresenter extends BasePresenter<HomeModel, BaseView> {

    public HomePresenter(HomeModel model, BaseView view) {
        super(model, view);
    }

    @Override
    public void requestData() {

        mModel.getData()
                .subscribeOn(Schedulers.io())
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ResponseBody>() {
                    Disposable mDisposable;

                    @Override
                    public void onSubscribe(@NonNull Disposable d) {
                        mDisposable = d;
                    }

                    @Override
                    public void onNext(@NonNull ResponseBody responseBody) {
                        mView.showloading();
                        if (responseBody != null) {
                            mView.showResult(responseBody.toString());
                        } else {
                            mView.showNoData();
                        }
                        mView.showDismiss();
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                        mView.showDismiss();
                        mView.showError(e.getMessage().toString());
                    }

                    @Override
                    public void onComplete() {
                        mView.showDismiss();
                        mDisposable.dispose();
                    }
                });
    }

}
