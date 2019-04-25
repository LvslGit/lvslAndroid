package com.lvsl.android.base;

import android.app.Application;
import android.content.Context;

/**
 * application配置
 *
 * @author lvsl
 * @date 2019-04-24
 */
public class TheApplication extends Application {
    private static TheApplication _instance;

    public synchronized static TheApplication getInstance() {
        return _instance;
    }

    public synchronized static Context getAppContext() {
        return _instance.getApplicationContext();
    }

    @Override
    public void onCreate() {
        super.onCreate();
        _instance = this;

//        Fresco.initialize(this);
    }
}
