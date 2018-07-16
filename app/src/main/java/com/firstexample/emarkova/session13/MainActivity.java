package com.firstexample.emarkova.session13;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;


public class MainActivity extends AppCompatActivity {

    private FragmentTransaction fragmentTransaction;
    private CustomBroadcastReciever mReciever;
    private IntentFilter mFilter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mReciever = new CustomBroadcastReciever();
        mFilter = new IntentFilter("emarkova.GET_WEATHER");
        Intent intent = new Intent(MainActivity.this, WeatherIntentService.class);
        startService(intent);


    }
    protected void onResume() {
        super.onResume();
        registerReceiver(mReciever, mFilter);
    }

    private class CustomBroadcastReciever extends BroadcastReceiver {
        @Override
        public void onReceive(Context context, Intent intent) {
            FragmentList fragmentList = new FragmentList();
            fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransaction.add(R.id.frameLayout, fragmentList);
            fragmentTransaction.commit();
        }
    }
}
