package com.yj.mvpdaggerretrofitrxjava.mvp.model;


import com.yj.mvpdaggerretrofitrxjava.api.ApiService;

import io.reactivex.Observable;
import okhttp3.ResponseBody;

/**
 * Created by YJ on 2017/6/5.
 */

public class HomeModel {

    ApiService mApiService;

    public HomeModel(ApiService apiService) {
        mApiService = apiService;
    }

    public Observable<ResponseBody> getData() {
        Observable<ResponseBody> data = mApiService.getBannerData();
        return data;
    }


}
