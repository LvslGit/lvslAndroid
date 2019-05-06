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
    private WeakHandler handler = new WeakHandler(Looper.getMainLooper());

    private static void delayClickableWithTime(final View view, long time) {
        if (view != null) {
//            view.isClickable() = false;
//
//            handler.postDelayed(new Runnable() {
//                @Override
//                public void run() {
//                    view.isClickable() = true;
//                }
//            }, time);
        }


    }

    public static void delayClickable(View view) {
        delayClickableWithTime(view, 300L);
    }
}
