package com.firstexample.emarkova.session13.data.database;

import com.firstexample.emarkova.session13.data.API.APIHelper;
import com.firstexample.emarkova.session13.data.API.APIModule;
import com.firstexample.emarkova.session13.domain.DayMapper;
import com.firstexample.emarkova.session13.data.entity.DataDay;
import com.firstexample.emarkova.session13.domain.model.Day;

import dagger.Component;

@Component(modules = {APIModule.class})
public interface DBComponent{
    DBManager getDBManager();
    APIHelper getHelper();
}
