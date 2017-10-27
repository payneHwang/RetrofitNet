package com.remote.net.service;

import com.remote.net.client.RetrofitFactory;

/**
 * Created by huang_jin on 2017/10/27.
 */

public class ApiService {
    private ApiService() {
    }

    public static Service getRemoteService() {
        return RetrofitFactory.create().create(Service.class);
    }

}
