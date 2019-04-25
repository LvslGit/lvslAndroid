package com.lvsl.android.base;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * @author lvsl
 * @date 2019-04-25
 */
public abstract class BaseFragment extends Fragment {
    private Context mContext;

    protected boolean isViewInitiated;// view初始化相关
    protected boolean isVisibleToUser;
    protected boolean isHidden;

    /******************             以下对应activity的Created生命周期             ********************/
    /**
     * 生命周期第一项执行
     * <p>
     * fragment与Activity关联之后调调查用
     *
     * @param context
     */
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.mContext = context;
    }

    /**
     * 生命周期第二项执行
     * <p>
     * fragment初次创建时调用,
     * 但这个只是用来创建Fragment的。
     * 此时的Activity还没有创建完成,因为我们的Fragment也是Activity创建的一部分。
     *
     * @param savedInstanceState
     * @Nullable 可传入null值
     */
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        isViewInitiated = true;
    }

    /**
     * 生命周期第三项执行
     *
     * @param inflater
     * @param container
     * @param savedInstanceState
     * @return
     */
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    /**
     * 生命周期第四项执行
     *
     * @param savedInstanceState
     */
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }


    /******************             以下对应activity的onStart生命周期             ********************/
    /**
     * 生命周期第 5 项执行
     */
    @Override
    public void onStart() {
        super.onStart();
    }

    /**
     * 当前fragment是否展示在用户面前
     *
     * @param isVisibleToUser
     */
    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);

        this.isVisibleToUser = isVisibleToUser;
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    /**
     * fragment界面是否显示隐藏
     *
     * @param hidden
     */
    @Override
    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);
        this.isHidden = hidden;

    }
}
