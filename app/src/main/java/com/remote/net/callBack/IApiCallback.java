package com.remote.net.callBack;

import com.remote.domain.model.Beauty;

import java.util.List;

/**
 * Created by huang_jin on 2017/10/27.
 */

public interface IApiCallback {
    void success(List<Beauty> beauties);

    void failure(Throwable e);

    void cancel();

    void networkError();
}
