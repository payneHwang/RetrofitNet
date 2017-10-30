package com.remote.net.client;

import com.remote.BuildConfig;
import com.remote.net.intercepter.Intercepter;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by huang_jin on 2017/10/27.
 * 维护一个单例的Retrofit客户端对象
 */

public class RetrofitFactory {
    private static final String HOST = "http://gank.io/";
    private static final int NET_READ_TIMEOUT = 5000;
    private static final int NET_WRITE_TIMEOUT = 5000;
    private static final int NET_CONNECT_TIMEOUT = 5000;
    private static RetrofitFactory factory;
    private Retrofit retrofit;

    private RetrofitFactory() {
        init();
    }

    //提供静态实例获取RetrofitFactory对象
    public static RetrofitFactory create() {
        if (factory == null) {
            synchronized (RetrofitFactory.class) {
                if (factory == null) {
                    factory = new RetrofitFactory();
                    return factory;
                }
            }
        }
        return factory;
    }

    private void init() {
        //初始化OkHttpClient客户端
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        if (BuildConfig.DEBUG) {
            interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        } else
            interceptor.setLevel(HttpLoggingInterceptor.Level.NONE);
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .connectTimeout(NET_CONNECT_TIMEOUT, TimeUnit.SECONDS)
                .readTimeout(NET_READ_TIMEOUT, TimeUnit.SECONDS)
                .writeTimeout(NET_WRITE_TIMEOUT, TimeUnit.SECONDS)
                .addInterceptor(Intercepter.defaultInterceptor())
                .addInterceptor(interceptor)//设置网络请求和相应的日志拦截器
                .retryOnConnectionFailure(true)
                .build();

        //配置Retrofit客户端
        retrofit = new Retrofit.Builder()
                .baseUrl(HOST)
                .client(okHttpClient)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    //获取服务对象
    public <T> T createReq(Class<T> service) {
        return retrofit.create(service);
    }

}
