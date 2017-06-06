package com.yj.mvpdaggerretrofitrxjava.api;

import io.reactivex.Observable;
import okhttp3.ResponseBody;
import retrofit2.http.GET;

/**
 * Created by YJ on 2017/6/5.
 */

public interface ApiService {

    public static final String BASE_URL = "http://dl.bizhi.sogou.com/";

    @GET("images/2012/03/14/124196.jpg")
    Observable<ResponseBody> getBannerData();


}
