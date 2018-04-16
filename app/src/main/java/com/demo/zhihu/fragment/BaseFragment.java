package com.demo.zhihu.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public abstract class BaseFragment extends Fragment {
    protected final String TAG = getClass().getName();
    protected View mRootView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        initRootView(inflater, container, savedInstanceState);
        initData(savedInstanceState == null);
        return mRootView;
    }

    /**
     * 初始化根布局
     *
     * @return View 视图
     */
    protected abstract void initRootView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState);



    /**
     * 加载数据
     * @param isSavedNull
     */
    protected abstract void initData(boolean isSavedNull);
}
