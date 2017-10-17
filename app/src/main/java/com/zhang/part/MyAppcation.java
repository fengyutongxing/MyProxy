package com.zhang.part;

import android.app.Application;

/**
 * Created by zhang_shuai on 2017/9/25.
 * Del:
 */

public class MyAppcation extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
//        HttpProxy.init(new VolleyProcessor(this));
//        HttpProxy.init(new OkHttpProcessor());
          HttpProxy.init(new XUtilsProcessor(this));
    }


}
