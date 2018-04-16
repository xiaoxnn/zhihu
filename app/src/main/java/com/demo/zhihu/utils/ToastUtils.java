package com.demo.zhihu.utils;

import android.widget.Toast;

import com.demo.zhihu.Myapplication;


/**
 * Author   :hymane
 * Email    :hymanme@163.com
 * Create at 2016-12-26
 * Description:
 */
public class ToastUtils {
    public static void showShort(String msg) {
        Toast.makeText(Myapplication.getContext(), msg, Toast.LENGTH_SHORT).show();
    }

    public static void showLong(String msg) {
        Toast.makeText(Myapplication.getContext(), msg, Toast.LENGTH_LONG).show();
    }
}
