package com.lewish.start.andfixdemo;

import android.app.Application;

/**
 * author: sundong
 * created at 2017/7/12 15:54
 */
public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        AndFixManager.getInstance().init(this);
    }

}
