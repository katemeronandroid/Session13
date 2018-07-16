package com.firstexample.emarkova.session13.MVP;

import com.firstexample.emarkova.session13.database.DBManager;

import java.util.List;

public class MVPModelImp implements MVPModel {
    private DBManager manager;

    public MVPModelImp(DBManager manager) {
        this.manager = manager;
    }

    @Override
    public List<String> getData(String day) {
        return manager.getDetailInfo(day);
    }

}
