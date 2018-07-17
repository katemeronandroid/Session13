package com.firstexample.emarkova.session13.MVP;

import android.content.Context;
import android.view.View;

import com.firstexample.emarkova.session13.MyApplication;
import com.firstexample.emarkova.session13.database.DBManager;

public class MVPPresenterImp implements MVPPresenter {
    private MVPModel mvpModel;
    private MVPView mvpView;

    public MVPPresenterImp() {
        this.mvpModel = new MVPModelImp(MyApplication.getDBManager());
    }

    @Override
    public void connectToView(MVPView view) {
        this.mvpView = view;
    }

    @Override
    public void getWeather(String day) {
        mvpView.setData(mvpModel.getData(day));
    }

}
