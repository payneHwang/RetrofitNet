package com.remote.net.intercepter;

import android.util.Log;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;

/**
 * Created by huang_jin on 2017/10/27.
 */

public class Intercepter {
    private static HttpLoggingInterceptor logInterceptor;
    private static Interceptor interceptor;

    private Intercepter() {
    }

    public static HttpLoggingInterceptor defaultLogger() {
        if (logInterceptor == null) {
            synchronized (Intercepter.class) {
                if (logInterceptor == null) {
                    logInterceptor = new HttpLoggingInterceptor(new HttpLoggingInterceptor.Logger() {
                        @Override
                        public void log(String message) {
                            Log.w("", "log: " + message);
                        }
                    }).setLevel(HttpLoggingInterceptor.Level.BODY);
                    return logInterceptor;
                }
            }
        }
        return logInterceptor;
    }


    public static Interceptor defaultInterceptor() {
        if (interceptor == null) {
            synchronized (Intercepter.class) {
                if (interceptor == null) {
                    interceptor = new Interceptor() {
                        @Override
                        public Response intercept(Chain chain) throws IOException {
                            //在这里你可以做一些想做的事,比如token失效时,重新获取token
                            //或者添加header等等,PS我会在下一篇文章总写拦截token方法
                            Request request = chain.request();
                            return chain.proceed(request);
                        }
                    };
                    return interceptor;
                }
            }
        }
        return interceptor;
    }

}
