package com.firstexample.emarkova.session13;

import com.firstexample.emarkova.session13.data.database.DBHelper;

import dagger.Component;

@Component(modules = MyApplication.class)
public interface ContextComponent {
   DBHelper getHelper();
}
