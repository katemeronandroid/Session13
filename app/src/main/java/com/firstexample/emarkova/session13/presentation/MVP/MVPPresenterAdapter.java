package com.firstexample.emarkova.session13.presentation.MVP;

public class MVPPresenterAdapter implements MVPPresenter {
    private MVPModel mvpModel;
    private MVPView mvpView;

    public MVPPresenterAdapter() {
        this.mvpModel = new MVPModelImp();
    }

    @Override
    public void connectToView(MVPView view) {
        this.mvpView = view;
    }

    @Override
    public void getWeather(String day) {
        mvpView.setDataAdapter(mvpModel.getDataAdapter());
    }
}
