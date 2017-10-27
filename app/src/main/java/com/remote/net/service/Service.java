package com.remote.net.service;

import com.remote.net.response.Response;
import com.remote.net.url.UrlConstance;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by huang_jin on 2017/10/27.
 * 远程访问的接口
 */

public interface Service {

    @GET(UrlConstance.BEATUTY_DATA)
    Observable<Response> beautyList(@Path("count") int count, @Path("page") int page);


}
