
package com.example.project;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    WifiManager wifiManager;
    int     currentStatue = 0 ,wifiStateExtra;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView bottomNav = findViewById(R.id.bottomNav);
        bottomNav.setOnNavigationItemSelectedListener(navListener );
        wifiManager = (WifiManager) getApplicationContext().getSystemService(Context.WIFI_SERVICE);

    }

    @Override
    protected void onStart()
    {
        super.onStart();

            IntentFilter intentFilter = new IntentFilter(WifiManager.WIFI_STATE_CHANGED_ACTION);
            registerReceiver(wifiStateReceiver,intentFilter);

    }

    @Override
    protected void onStop()
    {
        super.onStop();
        unregisterReceiver(wifiStateReceiver);

    }

    private BottomNavigationView.OnNavigationItemSelectedListener navListener  =
            new BottomNavigationView.OnNavigationItemSelectedListener()
            {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item)
                {
                    Fragment selectedFargment = null;
                    switch (item.getItemId())
                    {
                        case R.id.home1:
                            selectedFargment = new Home();
                            break;
                        case R.id.cartfrag:
                            selectedFargment = new Cart();
                            break;
                        case R.id.profile:
                            selectedFargment = new Profile();
                            break;
                        case R.id.offers:
                            selectedFargment = new Offers();
                            break;
                    }
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainerView,selectedFargment).commit();
                    return true;
                }
            };


    public void about(View v)
    {
        Intent intent = new Intent(this,Aboutus.class);
        startActivity(intent);
    }

    private BroadcastReceiver wifiStateReceiver = new BroadcastReceiver()
    {
        @Override
        public void onReceive(Context context, Intent intent)
        {

             wifiStateExtra = intent.getIntExtra(WifiManager.EXTRA_WIFI_STATE,WifiManager.WIFI_STATE_UNKNOWN);
            if (wifiStateExtra == WifiManager.WIFI_STATE_ENABLED && currentStatue != wifiStateExtra)
            {
                Toast.makeText(context, "Connected,nice, now wait for new meals", Toast.LENGTH_SHORT).show();
                currentStatue = wifiStateExtra;
            } else if (wifiStateExtra == WifiManager.WIFI_STATE_DISABLED && currentStatue != wifiStateExtra)
            {
                Toast.makeText(context, "no internet means only looking at the food 😥", Toast.LENGTH_LONG).show();
                currentStatue = wifiStateExtra;
            }
        }
    };
    public void Location(View L)
    {
        Uri gmmIntentUri = Uri.parse("google.navigation:q=31.207553,29.918972");
        Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
        mapIntent.setPackage("com.google.android.apps.maps");
        startActivity(mapIntent);
    }

}