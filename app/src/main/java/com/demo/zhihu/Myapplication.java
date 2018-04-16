package com.demo.zhihu;

import android.app.Application;

import com.zhy.http.okhttp.OkHttpUtils;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;

/**
 * Created by xnn on 2018/4/15.
 */

public class Myapplication  extends Application{

    private static Myapplication application;
    @Override
    public void onCreate() {
        super.onCreate();
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
//                .addInterceptor(new LoggerInterceptor("TAG"))
                .connectTimeout(10000L, TimeUnit.MILLISECONDS)
                .readTimeout(10000L, TimeUnit.MILLISECONDS)
                //其他配置
                .build();

        OkHttpUtils.initClient(okHttpClient);
    }

    public static Myapplication getContext(){
        if(application==null){
            application= (Myapplication) new Application();
        }
        return application;
    }

}
