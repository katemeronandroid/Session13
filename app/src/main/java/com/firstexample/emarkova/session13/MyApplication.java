package com.firstexample.emarkova.session13;

import android.app.Application;
import android.content.Context;

import com.firstexample.emarkova.session13.database.DBManager;

public class MyApplication extends Application {
    static Context context;
    @Override
    public void onCreate() {
        super.onCreate();
        MyApplication.context = getApplicationContext();
    }

    public static DBManager getDBManager() {
        return new DBManager(context);
    }
}
