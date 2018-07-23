package com.firstexample.emarkova.session13.presentation.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.firstexample.emarkova.session13.R;
import com.firstexample.emarkova.session13.WeatherAdapter;
import com.firstexample.emarkova.session13.data.WeatherIntentService;
import com.firstexample.emarkova.session13.data.database.DBManager;
import com.firstexample.emarkova.session13.presentation.MVP.MVPPresenter;
import com.firstexample.emarkova.session13.presentation.MVP.MVPPresenterAdapter;
import com.firstexample.emarkova.session13.presentation.MVP.MVPView;
import com.firstexample.emarkova.session13.presentation.RecyclerClickListiner;
import com.firstexample.emarkova.session13.presentation.SpaceItemDecoration;
import com.firstexample.emarkova.session13.presentation.datamodel.ViewDay;
import com.firstexample.emarkova.session13.presentation.datamodel.WeatherCell;

import java.util.ArrayList;


public class FragmentList extends Fragment implements MVPView{
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private static final int SPACE = 10;
    private DBManager manager;
    private Toolbar toolbar;
    private static final String KEY = "country";

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        setHasOptionsMenu(true);
        return inflater.inflate(R.layout.fragment_list, null);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        toolbar = (Toolbar)view.findViewById(R.id.my_toolbar);
        ((AppCompatActivity)getActivity()).setSupportActionBar(toolbar);
        Bundle bundle = getArguments();
        if(bundle != null)
            toolbar.setTitle(bundle.getString(KEY));
        mRecyclerView = (RecyclerView) getView().findViewById(R.id.myRecyclerView);
        mLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.addItemDecoration(new SpaceItemDecoration(SPACE));
        MVPPresenter presenter = new MVPPresenterAdapter();
        presenter.connectToView(this);
        presenter.getWeather(null);
    }
    public void onClick(View view) {
        Intent intent = new Intent(getContext(), WeatherIntentService.class);
        getActivity().startService(intent);
    }


    @Override
    public void setData(ViewDay data) {

    }

    @Override
    public void setDataAdapter(ArrayList<ViewDay> data) {
        ArrayList<WeatherCell> infoRecView = new ArrayList<>();
        for (int i = 0; i < data.size(); i++) {
            infoRecView.add(new WeatherCell(data.get(i).getDayName(), String.valueOf(data.get(i).getTemperatureMax())));
        }
        mAdapter = new WeatherAdapter(infoRecView, getContext());
        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.addOnItemTouchListener(new RecyclerClickListiner(getContext()) {

            @Override
            public void onItemClick(RecyclerView recyclerView, View itemView, int position) {
                FragmentTransaction fragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction();
                FragmentDetail fragmentDetail = new FragmentDetail();
                Bundle bundle = new Bundle();
                bundle.putString("dayname", ((TextView)itemView.findViewById(R.id.fileName)).getText().toString());
                fragmentDetail.setArguments(bundle);
                fragmentTransaction.replace(R.id.frameLayout, fragmentDetail);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }
        });
    }
}
