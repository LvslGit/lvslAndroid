package com.lvsl.android.base;

import android.content.Context;
import android.content.pm.ActivityInfo;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import com.githang.statusbar.StatusBarCompat;
import com.lvsl.android.R;

/**
 * activity基类
 *
 * @author lvsl
 * @date 2019-04-24
 */
public abstract class BaseActivity extends AppCompatActivity {
    private Context mContext;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        configScreenOrientation();

        mContext = BaseActivity.this;
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(getLayoutId());
        initViewAData();
        reqData();
    }

    protected abstract int getLayoutId();

    protected abstract void initViewAData();

    protected abstract void reqData();

    /**
     * 状态栏相关
     */
    // 普通设置状态栏颜色(6.0以下状态栏字体颜色无法改变，改变透明度)
    protected void setCommonStatus() {
//        setCommonStatus(false);
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.M && Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            StatusBarCompat.setStatusBarColor(this, ContextCompat.getColor(mContext, R.color.color_a6a5a6));
        } else {
            StatusBarCompat.setStatusBarColor(this, ContextCompat.getColor(mContext, R.color.color_ffffff));
        }
    }

    // 设置沉浸式状态栏(5.0以下状态栏背景颜色无法改变，隐藏占位view)
    protected void setTranslucentStatus() {
        setViewStatusSpace(null);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = getWindow();
            // 设置状态栏全透明
            window.getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN | View.SYSTEM_UI_FLAG_LAYOUT_STABLE);
            window.setStatusBarColor(Color.TRANSPARENT);
            // 沉浸式状态栏
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        } else {
            setCommonStatus();
        }
    }

    // 隐藏显示沉浸栏占位
    public void setViewStatusSpace(View v) {
        View viewStatusSpace;
        if (v != null) {
            viewStatusSpace = v.findViewById(R.id.view_status_space);
        } else {
            viewStatusSpace = findViewById(R.id.view_status_space);
        }
        if (viewStatusSpace == null) return;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            viewStatusSpace.setVisibility(View.VISIBLE);
        } else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            viewStatusSpace.setVisibility(View.VISIBLE);
        } else {
            viewStatusSpace.setVisibility(View.GONE);
        }
    }

    /**
     * 默认所有子Activity都是强制竖屏
     */
    protected void configScreenOrientation() {
        if (getRequestedOrientation() != ActivityInfo.SCREEN_ORIENTATION_PORTRAIT) {
            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        }
    }
}
