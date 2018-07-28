package com.firstexample.emarkova.session13;

import android.app.Application;
import android.content.Context;

import com.firstexample.emarkova.session13.data.database.DBHelper;

import javax.inject.Inject;

import dagger.Module;
import dagger.Provides;

@Module
public class MyApplication extends Application {
    public static MyApplication application;
    public MyApplication context;

    @Override
    public void onCreate() {
        super.onCreate();
        application = this;
        context = this;
    }

    @Provides
    public MyApplication returnApp() {
        return context;
    }

    /*@Provides
    public DBHelper getHelper() {
        return new DBHelper(context);
    }*/

    public static Context getContext() {
        return application;
    }
}
