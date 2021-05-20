package com.dania.vision;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class fingerprint2 extends AppCompatActivity {

    private LinearLayout lnr1,lnr2,lnr3,lnr4;
    private TextView txt1,txt2,txt3;
    private ImageView img1;
    private Button btn1;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fingerprint2);
        getSupportActionBar().hide();
        initailize();

    }

    private void initailize() {
        lnr1 = (LinearLayout) findViewById(R.id.lnr1);
        lnr2 = (LinearLayout) findViewById(R.id.lnr2);
        lnr3 = (LinearLayout) findViewById(R.id.lnr3);
        lnr4 = (LinearLayout) findViewById(R.id.lnr4);
        txt1 = (TextView) findViewById(R.id.txt1);
        txt2 = (TextView) findViewById(R.id.txt2);
        txt3 = (TextView) findViewById(R.id.txt3);
        img1 = (ImageView) findViewById(R.id.img1);
        btn1 = (Button) findViewById(R.id.btn1);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent fingerprint3 = new Intent(getApplicationContext(),fingerprint3.class);
                startActivity(fingerprint3);
            }
        });

    }
}
