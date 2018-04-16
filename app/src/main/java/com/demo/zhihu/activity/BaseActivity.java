package com.demo.zhihu.activity;

import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;


public abstract class BaseActivity extends AppCompatActivity {
    protected final String TAG = getClass().getSimpleName();
    public static BaseActivity activity;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activity = this;
        init();
    }

    @Override
    protected void onResume() {
        super.onResume();
        activity = this;
    }

    @Override
    protected void onPause() {
        super.onPause();
        activity = null;
    }

    public void init() {
        initData();
    }


    protected void initData() {
    }

    @Override
    public void setContentView(@LayoutRes int layoutResID) {

        super.setContentView( layoutResID);
    }




    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
