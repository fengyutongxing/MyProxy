package com.zhang.part;

import android.util.Log;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;


/**
 * Created by zhang_shuai on 2017/9/25.
 * Del:
 */

public class HttpProxy implements IHttpProcessor {
    public static final String TAG = "HttpProxy";
    private static HttpProxy install;
    private static IHttpProcessor mIHttpProcessor = null;
    private Map<String, Object> mParams = null;

    private HttpProxy() {
        mParams = new HashMap<>();
    }


    public static HttpProxy obtain() {
        synchronized (HttpProxy.class) {
            if (install == null) {
                install = new HttpProxy();
            }
        }
        return install;
    }

    public static void init(IHttpProcessor httpProcessor) {
        mIHttpProcessor = httpProcessor;
    }

    @Override
    public void post(String url, Map<String, Object> params, ICallBack callBack) {
        final String finalUrl = appendParams(url, params);
        Log.e(TAG, "post: " + finalUrl);
        mIHttpProcessor.post(finalUrl, params, callBack);
    }

    @Override
    public void get(String url, Map<String, Object> params, ICallBack callBack) {
        final String finalUrl = appendParams(url, params);
        mIHttpProcessor.get(finalUrl, params, callBack);
    }

    //拼接参数
    public static String appendParams(String url, Map<String, Object> params) {
        if (params == null || params.isEmpty()) {
            return url;
        }


        StringBuilder builder = new StringBuilder();
        builder.append(url);
        if (builder.indexOf("?") < 0) {
            builder.append("?");
        }
        for (Map.Entry<String, Object> entry : params.entrySet()) {
            if (entry.getValue().equals("%E5%8D%A7%E8%96%AA%E5%B0%9D%E8%83%86")) {
                entry.setValue("卧薪尝胆");
            }
            builder.append(entry.getKey()).append("=").append(encodes(entry.getValue().toString())).append("&");
        }
        return builder.toString();

    }

    public static String encodes(String str) {
        try {
            return URLEncoder.encode(str, "utf-8");
        } catch (UnsupportedEncodingException e) {
            Log.e("参数转码异常", e.toString());
            e.printStackTrace();
        }
        return null;
    }
}
