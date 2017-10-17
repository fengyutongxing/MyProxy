package com.zhang.part;

import android.os.Handler;
import android.util.Log;

import java.io.IOException;
import java.util.Map;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;



/**
 * Created by zhang_shuai on 2017/9/26.
 * Del:
 */

public class OkHttpProcessor implements IHttpProcessor {
    public static final String TAG = "OkHttpProcessor";
    private OkHttpClient mOkHttpClient;
    private Handler mHandler;

    public OkHttpProcessor() {
        mOkHttpClient = new OkHttpClient();
        mHandler = new Handler();
    }

    @Override
    public void post(String url, Map<String, Object> params, final ICallBack callBack) {
        Log.e(TAG, "post: "+"=============OkHttpProcessor");
        RequestBody requestBody = appendBody(params);
        final Request request = new Request.Builder()
                .url(url)
                .post(requestBody)
                .header("User-Agent", "a")
                .build();
        mOkHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, final IOException e) {
                mHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        callBack.onFail(e.toString());
                    }
                });
            }

            @Override
            public void onResponse(Call call, final Response response) throws IOException {

                if (response.isSuccessful()) {
                    final String result = response.body().string();
                    Log.e(TAG, "post: "+"=============OkHttpProcessor==========="+result);
                    mHandler.post(new Runnable() {
                        @Override
                        public void run() {
                            callBack.onSuccess(result);
                        }
                    });
                }else{
                    mHandler.post(new Runnable() {
                        @Override
                        public void run() {
                            callBack.onFail(response.toString());
                        }
                    });
                }
            }
        });

    }

    @Override
    public void get(String url, Map<String, Object> params, ICallBack callBack) {

    }

    private RequestBody appendBody(Map<String, Object> params) {
        FormBody.Builder body = new FormBody.Builder();
        if (params != null || params.isEmpty()) {
            return body.build();
        }
        for (Map.Entry<String, Object> entry : params.entrySet()) {

            body.add(entry.getKey(), entry.getValue().toString());
        }
        return body.build();
    }
}
