package com.firstexample.emarkova.session13.presentation.MVP;

import com.firstexample.emarkova.session13.presentation.datamodel.ViewDay;

import java.util.ArrayList;

public interface MVPModel {
    ViewDay getData(String day);
    ArrayList<ViewDay> getDataAdapter();
}
