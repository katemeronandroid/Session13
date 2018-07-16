package com.firstexample.emarkova.session13;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.firstexample.emarkova.session13.MVP.MVPModel;
import com.firstexample.emarkova.session13.MVP.MVPModelImp;
import com.firstexample.emarkova.session13.MVP.MVPPresenter;
import com.firstexample.emarkova.session13.MVP.MVPPresenterImp;
import com.firstexample.emarkova.session13.MVP.MVPView;
import com.firstexample.emarkova.session13.database.DBManager;

import java.util.ArrayList;
import java.util.List;

public class FragmentDetail extends Fragment implements MVPView{
    DBManager manager;
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
            manager = new DBManager(getContext());
            key = bundle.getString("dayname");
            MVPModel model = new MVPModelImp(manager);
            MVPPresenter presenter = new MVPPresenterImp(model);
            presenter.connectToView(this);
            presenter.getWeather(key);
        }
    }

    @Override
    public void setData(List<String> list) {
        View view = getView();
        TextView textView = (TextView) view.findViewById(R.id.textViewDay);
        textView.setText("Day:        " +list.get(0));
        textView = (TextView)view.findViewById(R.id.textSummary);
        textView.setText("Summary:    " + list.get(1));
        textView = (TextView)view.findViewById(R.id.textViewTemp);
        textView.setText("Temperature: " +list.get(2));
        textView = (TextView)view.findViewById(R.id.textViewPress);
        textView.setText("Pressure:    " +list.get(3));
        textView = (TextView)view.findViewById(R.id.textViewWind);
        textView.setText("Wind:        " +list.get(4));
    }

}
