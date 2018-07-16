package com.firstexample.emarkova.session13.MVP;

import android.view.View;

public interface MVPPresenter{
    void connectToView(MVPView view);
    void getWeather(String day);
}
