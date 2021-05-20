package com.dania.vision;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class Dashboard1 extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard1);
        getSupportActionBar().hide();

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        navigation.setSelectedItemId(R.id.navigation_home);
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new Home()).commit();



     }


    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {

            android.support.v4.app.Fragment selectedFragment = null;

            switch (item.getItemId()) {
                case R.id.navigation_profile:
                    selectedFragment = new Profile();
                    break;

                case R.id.navigation_home:
                    selectedFragment = new Home();
                    break;

                case R.id.navigation_add:
                    selectedFragment = new Add();
                    break;

                case R.id.navigation_settings:
                    selectedFragment = new Settings();
                    break;

                case R.id.navigation_notification:
                    selectedFragment = new Notification();
                    break;

            }
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,selectedFragment).commit();

            return true;

        }
    };



}
