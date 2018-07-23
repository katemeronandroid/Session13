package com.firstexample.emarkova.session13.presentation.MVP;

public interface MVPPresenter{
    void connectToView(MVPView view);
    void getWeather(String day);
}
