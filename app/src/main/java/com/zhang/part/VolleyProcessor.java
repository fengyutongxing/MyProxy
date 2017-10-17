package com.zhang.part;

import android.content.Context;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.Map;

/**
 * Created by zhang_shuai on 2017/9/25.
 * Del:
 */

public class VolleyProcessor implements IHttpProcessor {
    public static final String TAG = "VolleyProcessor";
    private static RequestQueue sQueue = null;

    public VolleyProcessor(Context context){
        sQueue = Volley.newRequestQueue(context);
    }
    @Override
    public void post(String url, Map<String, Object> params, final ICallBack callBack) {
        Log.e(TAG, "post: "+"=============VolleyProcessor");
        StringRequest stringRequest = new StringRequest(Request.Method.POST, url,
                new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                callBack.onSuccess(response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                callBack.onFail(error.toString());
            }
        });
        sQueue.add(stringRequest);
    }

    @Override
    public void get(String url, Map<String, Object> params, final ICallBack callBack) {
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                callBack.onSuccess(response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                callBack.onFail(error.toString());
            }
        });
        sQueue.add(stringRequest);
    }
}
