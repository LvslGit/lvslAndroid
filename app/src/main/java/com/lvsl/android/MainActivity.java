package com.lvsl.android;

import android.view.View;
import android.widget.Button;

import com.lvsl.android.base.BaseActivity;

public class MainActivity extends BaseActivity implements View.OnClickListener {
    private static final String TAG = "lvsl";

    private Button btnMainKotlin;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initViewAData() {
        setCommonStatus();
        btnMainKotlin = findViewById(R.id.btnMainKotlin);
        btnMainKotlin.setText("Kotlin学习");
    }

    @Override
    protected void reqData() {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnMainKotlin:

                break;
            default:
                break;
        }
    }
}