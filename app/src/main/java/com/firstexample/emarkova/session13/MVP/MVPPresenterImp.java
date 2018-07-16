package com.firstexample.emarkova.session13.MVP;

import android.view.View;

public class MVPPresenterImp implements MVPPresenter {
    private MVPModel mvpModel;
    private MVPView mvpView;

    public MVPPresenterImp(MVPModel model) {
        this.mvpModel = model;
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
