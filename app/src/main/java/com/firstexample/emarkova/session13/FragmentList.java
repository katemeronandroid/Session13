package com.firstexample.emarkova.session13;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.firstexample.emarkova.session13.database.DBManager;

import org.w3c.dom.Text;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class FragmentList extends Fragment {
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private static final int SPACE = 10;
    private DBManager manager;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_list, null);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mRecyclerView = (RecyclerView) getView().findViewById(R.id.myRecyclerView);
        mLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.addItemDecoration(new SpaceItemDecoration(SPACE));
        manager = new DBManager(getContext());
        ArrayList<ArrayList<String>> dayInfo = manager.getDayInfo();
        mAdapter = new WeatherAdapter(dayInfo.get(0), dayInfo.get(3));
        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.addOnItemTouchListener(new RecyclerClickListiner(getContext()) {

            @Override
            public void onItemClick(RecyclerView recyclerView, View itemView, int position) {
                //переопределить метод
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
    public void onClick(View view) {
        Intent intent = new Intent(getContext(), WeatherIntentService.class);
        getActivity().startService(intent);
    }

}
