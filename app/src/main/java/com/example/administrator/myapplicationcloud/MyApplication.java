package com.example.administrator.myapplicationcloud;

import android.app.Application;

import com.avos.avoscloud.AVOSCloud;

/**
 * Created by Administrator on 2016/11/30 0030.
 */

public class MyApplication extends Application{
    @Override
    public void onCreate() {
        super.onCreate();
        AVOSCloud.initialize(this,"WDJrKEXfRNm1pyO93U52YSr4-gzGzoHsz","enoKaTywTnmD8cnVrL5eMjXg");
    }
}
