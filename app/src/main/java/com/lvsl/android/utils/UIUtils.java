package com.lvsl.android.utils;

import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.animation.AnimationUtils;

/**
 * @author lvsl
 * @date 2019-04-28
 */
public class UIUtils {
    private static final String TAG = "lvsl";

    private static long lastClickTime;

    /**
     * 防止快速点击
     *
     * @param MIN_DELAY_TIME 两次点击的间隔
     * @return
     */
    public static boolean isFastClick(final int MIN_DELAY_TIME) {// 两次点击间隔不能少于1000ms
        boolean flag = true;
        long currentClickTime = System.currentTimeMillis();
        if ((currentClickTime - lastClickTime) >= MIN_DELAY_TIME) {
            flag = false;
        }
        lastClickTime = currentClickTime;
        return flag;
    }
}
