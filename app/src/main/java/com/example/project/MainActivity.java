package com.example.project;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView bottomNav = findViewById(R.id.bottomNav);
        bottomNav.setOnNavigationItemSelectedListener(navListener );

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
                        case R.id.home:
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
}