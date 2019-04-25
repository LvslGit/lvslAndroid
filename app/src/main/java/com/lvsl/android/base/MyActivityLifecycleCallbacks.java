package com.lvsl.android.base;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;

/**
 * activity生命周期管理
 *
 * @author lvsl
 * @date 2019-04-24
 */
public class MyActivityLifecycleCallbacks implements Application.ActivityLifecycleCallbacks {
    private static final String tag = "lvsl";

    private int activityCount = 0;// 当前activity个数
    private static MyActivityLifecycleCallbacks instance;
    public static boolean appIsVisible = true;//app在前台显示
    private long stopTime;

    public static MyActivityLifecycleCallbacks getInstance() {
        if (instance == null) {
            instance = new MyActivityLifecycleCallbacks();
        }

        return instance;
    }

    @Override
    public void onActivityCreated(Activity activity, Bundle savedInstanceState) {
    }

    @Override
    public void onActivityStarted(Activity activity) {
        if (activityCount == 0) {

            // 超过一小时刷新数据操作
            if (System.currentTimeMillis() - stopTime > 3600000L) {
                // 发eventBus操作

            }
        } else {
            appIsVisible = true;
        }

        activityCount++;
    }

    @Override
    public void onActivityResumed(Activity activity) {

    }

    @Override
    public void onActivityPaused(Activity activity) {

    }

    @Override
    public void onActivityStopped(Activity activity) {
        activityCount--;

        if (activityCount == 0) {
            appIsVisible = false;
            //记录退到后台的时间
            stopTime = System.currentTimeMillis();
            //app退到后台eventbus通知
//            EventBus.getDefault().post(new EventBusModel(EventBusEvent.APP_IS_FOREGROUND, false));
        } else {
            appIsVisible = true;
        }
    }

    @Override
    public void onActivitySaveInstanceState(Activity activity, Bundle outState) {

    }

    @Override
    public void onActivityDestroyed(Activity activity) {

    }
}
