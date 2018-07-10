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

import com.firstexample.emarkova.session13.database.DBManager;

import java.util.ArrayList;

public class FragmentDetail extends Fragment {
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
            ArrayList<String> list = manager.getDetailInfo(key);
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
}
