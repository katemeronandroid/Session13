package com.firstexample.emarkova.session13;

import android.app.Application;
import android.content.Context;

import javax.inject.Inject;

public class MyApplication extends Application {
    private static MyApplication application;

    @Inject
    public MyApplication() {}

    @Override
    public void onCreate() {
        super.onCreate();
        application = this;
    }

    public static Context getContext() {
        return application.getApplicationContext();
    }
}
