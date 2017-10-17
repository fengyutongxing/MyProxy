package com.zhang.part;

import java.util.Map;

/**
 * Created by zhang_shuai on 2017/9/25.
 * Del:代理
 */

public interface IHttpProcessor {
    void post(String url, Map<String,Object> params,ICallBack callBack);
    void get(String url, Map<String,Object> params,ICallBack callBack);
}
