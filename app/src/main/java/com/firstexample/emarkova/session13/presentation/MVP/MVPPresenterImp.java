package com.firstexample.emarkova.session13.presentation.MVP;

public class MVPPresenterImp implements MVPPresenter {
    private MVPModel mvpModel;
    private MVPView mvpView;

    public MVPPresenterImp() {
        this.mvpModel = new MVPModelImp();
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
