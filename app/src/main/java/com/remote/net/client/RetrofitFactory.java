package com.remote.net.client;

import com.remote.net.Intercepter.Intercepter;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by huang_jin on 2017/10/27.
 * 维护一个单例的Retrofit客户端对象
 */

public class RetrofitFactory {
    private static Retrofit retrofit;
    private static final String HOST = "http://gank.io/";

    private RetrofitFactory() {
    }

    private static Retrofit init() {
        //初始化OkHttpClient客户端
        OkHttpClient okHttpClient = new OkHttpClient.Builder().connectTimeout(5000, TimeUnit.SECONDS)
                .readTimeout(5000, TimeUnit.SECONDS)
                .writeTimeout(5000, TimeUnit.SECONDS)
                .addInterceptor(Intercepter.defaultInterceptor())
                .addInterceptor(Intercepter.defaultLogger())
                .build();
        //配置Retrofit客户端
        retrofit = new Retrofit.Builder()
                .baseUrl(HOST)
                .client(okHttpClient)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return retrofit;
    }

    public static Retrofit create() {
        if (retrofit == null) {
            synchronized (RetrofitFactory.class) {
                if (retrofit == null) {
                    retrofit = init();
                    return retrofit;
                }
            }
        }
        return retrofit;
    }

}
