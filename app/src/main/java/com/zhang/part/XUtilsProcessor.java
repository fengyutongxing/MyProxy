package com.zhang.part;

import android.util.Log;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

import java.util.Map;

/**
 * Created by zhang_shuai on 2017/9/26.
 * Del:
 */

public class XUtilsProcessor implements IHttpProcessor {
    public static final String TAG = "XUtilsProcessor";

    public XUtilsProcessor(MyAppcation myAppcation){
        x.Ext.init(myAppcation);
    }
    @Override
    public void post(String url, Map<String, Object> params, final ICallBack callBack) {
        Log.e(TAG, "post: "+"=============XUtilsProcessor" );
        RequestParams requestParams = new RequestParams(url);
        //拼接参数
        for (Map.Entry<String, Object> entry : params.entrySet()) {
            requestParams.addBodyParameter(entry.getKey(),entry.getValue().toString());
        }
        x.http().post(requestParams, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {
                callBack.onSuccess(result);
            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {
                callBack.onFail(ex.toString());
            }

            @Override
            public void onCancelled(CancelledException cex) {

            }

            @Override
            public void onFinished() {

            }
        });
    }

    @Override
    public void get(String url, Map<String, Object> params, final ICallBack callBack) {
        RequestParams requestParams = new RequestParams(url);
        x.http().get(requestParams, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {
                callBack.onSuccess(result);
            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {
                callBack.onFail(ex.toString());
            }

            @Override
            public void onCancelled(CancelledException cex) {

            }

            @Override
            public void onFinished() {

            }
        });
    }
}
