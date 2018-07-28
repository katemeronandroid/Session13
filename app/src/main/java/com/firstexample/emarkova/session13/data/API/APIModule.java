package com.firstexample.emarkova.session13.data.API;

import javax.inject.Inject;

import dagger.Module;
import dagger.Provides;

@Module
public class APIModule {
    private APIHelper helper;

    @Inject
    public APIModule(APIHelper helper) {
        this.helper = helper;
    }

    @Provides
    APIHelper getHelper(){
        return helper;
    }
}
