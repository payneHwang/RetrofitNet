package com.remote.net.service;

import com.remote.net.response.Response;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by huang_jin on 2017/10/27.
 * 远程访问的接口
 */

public interface Service {

    @GET("api/data/福利/{count}/{page}")
    Observable<Response> beautyList(@Path("count") int count, @Path("page") int page);


}
