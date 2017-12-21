package com.example.lenovo.addcar.inter;

import android.app.Application;

import com.facebook.drawee.backends.pipeline.Fresco;

/**
 * Created by lenovo on 2017/12/21.
 */

public class MyApp extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Fresco.initialize(this);
    }
}
