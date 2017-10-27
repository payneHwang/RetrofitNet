package com.remote.net.response;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by huang_jin on 2017/10/27.
 * 接口相应的数据结构体
 */

public class Response {
    private boolean error;
    private List results = new ArrayList<>();

    public boolean isError() {
        return error;
    }

    public void setError(boolean error) {
        this.error = error;
    }

    public List getResults() {
        return results;
    }

    public void setResults(List results) {
        this.results = results;
    }
}
