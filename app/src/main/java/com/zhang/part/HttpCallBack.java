package com.zhang.part;

import com.google.gson.Gson;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;


/**
 * Created by zhang_shuai on 2017/9/25.
 * Del:
 */

public abstract class HttpCallBack<Result> implements ICallBack {

    @Override
    public void onSuccess(String result) {
        Gson gson = new Gson();
        Class<?> cls = clazInfo(this);
        Result objectResult = (Result) gson.fromJson(result, cls);
        onSuccess(objectResult);
    }

    public abstract void onSuccess(Result result);

    //类型转化
    public static Class<?> clazInfo(Object object){
        Type type = object.getClass().getGenericSuperclass();
        Type[] params = ((ParameterizedType)type).getActualTypeArguments();
        return (Class<?>) params[0];
    }
}
