package com.remote.domain.repository;

import com.remote.domain.model.Beauty;
import com.remote.net.response.Response;
import com.remote.net.service.ApiService;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Function;

/**
 * Created by huang_jin on 2017/10/27.
 * 远程加载数据
 */

public class Remote {
    //请求Beauty数据实体
    public static Observable<List<Beauty>> getBeautyList() {
        return ApiService.getRemoteService().beautyList(100, 1).map(new Function<Response, List<Beauty>>() {
            @Override
            public List<Beauty> apply(@NonNull Response response) throws Exception {
                return response.getResults();
            }
        });

    }

}
