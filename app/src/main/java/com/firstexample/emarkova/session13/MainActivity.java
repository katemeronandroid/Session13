package com.firstexample.emarkova.session13;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;

import com.firstexample.emarkova.session13.data.WeatherIntentService;
import com.firstexample.emarkova.session13.presentation.fragment.FragmentList;


public class MainActivity extends AppCompatActivity {

    private FragmentTransaction fragmentTransaction;
    private CustomBroadcastReciever mReciever;
    private IntentFilter mFilter;
    private String title = "Moscow";
    private static final String KEY = "country";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mReciever = new CustomBroadcastReciever();
        mFilter = new IntentFilter("emarkova.GET_WEATHER");
        Intent intent = new Intent(MainActivity.this, WeatherIntentService.class);
        intent.putExtra(KEY, "moscow");
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
            Bundle bundle = new Bundle();
            bundle.putString(KEY, title);
            fragmentList.setArguments(bundle);
            fragmentTransaction.replace(R.id.frameLayout, fragmentList);
            fragmentTransaction.commit();
        }
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        Intent intent = new Intent(MainActivity.this, WeatherIntentService.class);
        switch (id) {
            case R.id.action_moscow:
                intent.putExtra("country", "moscow");
                title = "Moscow";
                break;
            case R.id.action_seul:
                intent.putExtra("country", "seul");
                title = "Seul";
                break;
            case R.id.action_london:
                intent.putExtra("country", "london");
                title = "London";
                break;
            case R.id.action_la:
                intent.putExtra("country", "la");
                title = "LA";
        }
        startService(intent);
        return  true;
        //return super.onOptionsItemSelected(item); // important line
    }
}
