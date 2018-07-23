package com.firstexample.emarkova.session13.presentation.MVP;

import com.firstexample.emarkova.session13.presentation.datamodel.ViewDay;

import java.util.ArrayList;

public interface MVPView {
    void setData(ViewDay data);
    void setDataAdapter(ArrayList<ViewDay> data);
}
