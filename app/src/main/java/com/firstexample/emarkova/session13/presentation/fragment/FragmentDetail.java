package com.firstexample.emarkova.session13.presentation.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.firstexample.emarkova.session13.R;
import com.firstexample.emarkova.session13.presentation.MVP.MVPPresenter;
import com.firstexample.emarkova.session13.presentation.MVP.MVPPresenterImp;
import com.firstexample.emarkova.session13.presentation.MVP.MVPView;
import com.firstexample.emarkova.session13.presentation.datamodel.ViewDay;

import java.util.ArrayList;

public class FragmentDetail extends Fragment implements MVPView{
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_detail, null);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Bundle bundle = getArguments();
        String key;
        if(bundle != null) {
            key = bundle.getString("dayname");
            MVPPresenter presenter = new MVPPresenterImp();
            presenter.connectToView(this);
            presenter.getWeather(key);
        }
    }

    @Override
    public void setData(ViewDay data) {
        View view = getView();
        TextView textView = (TextView) view.findViewById(R.id.textViewDay);
        textView.setText("Day:        " +data.getDayName());
        textView = (TextView)view.findViewById(R.id.textSummary);
        textView.setText("Summary:    " + data.getIconString());
        textView = (TextView)view.findViewById(R.id.textViewTemp);
        textView.setText("Temperature: " +data.getTemperatureMax() + " C");
        textView = (TextView)view.findViewById(R.id.textViewPress);
        textView.setText("Pressure:    " +data.getPressure());
        textView = (TextView)view.findViewById(R.id.textViewWind);
        textView.setText("Wind:        " +data.getWindSpeed());
    }

    @Override
    public void setDataAdapter(ArrayList<ViewDay> data) {

    }

}
