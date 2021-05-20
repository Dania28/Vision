package com.dania.vision;

import android.annotation.SuppressLint;
import android.app.KeyguardManager;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.drawable.Drawable;
import android.hardware.fingerprint.FingerprintManager;
import android.os.Build;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.Timer;
import java.util.TimerTask;

public class FullscreenActivity extends AppCompatActivity {

    private LinearLayout lnr1;
    private ImageView img1;
    private TextView txt1;
    private ProgressDialog loginprogress;
    private TimerTask timer;
    private Timer _timer = new Timer();
    private FingerprintManager fingerprintManager;
    private KeyguardManager keyguardManager;



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fullscreen);
        getSupportActionBar().hide();


        lnr1 = (LinearLayout)findViewById(R.id.lnr1);
        img1 = (ImageView) findViewById(R.id.img1);
        txt1 = (TextView) findViewById(R.id.txt1);


        //Check1: Android version should be greater or equal to Marshmallow
        //Check2: Device has fingerprint scanner
        //Check3: Have permission to use fingerprint scanner in the app
        //Check4: Lock screen is secured with at least 1 type of lock
        //Check5: Atleast 1 fingerprint is registered

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M){

            fingerprintManager = (FingerprintManager) getSystemService(FINGERPRINT_SERVICE);
            keyguardManager = (KeyguardManager) getSystemService(KEYGUARD_SERVICE);

            if (!fingerprintManager.isHardwareDetected()){

                txt1.setText("Fingerprint Scanner is not detected in your device");

            }
            else if (ContextCompat.checkSelfPermission(this, android.Manifest.permission.USE_FINGERPRINT)!= PackageManager.PERMISSION_GRANTED){
                txt1.setText("Permission not granted to use Fingerprint Scanner");
            }

            else if (!keyguardManager.isKeyguardSecure()){
                txt1.setText("Add lock to your phone in Settings");
            }

            else if (!fingerprintManager.hasEnrolledFingerprints()){
                txt1.setText("Add atleast one fingerprint to use the app");

            }
            else {
                txt1.setText("Place your Fingerprint to LOG IN");
                FingerprintHandler fingerprintHandler = new FingerprintHandler(this);
                fingerprintHandler.startAuth(fingerprintManager,null);



            }

        }

        else {
            txt1.setText("Android Version is low." +
                    "\nIt should be greater than Android Version_CODE 22");
        }



        initialize();

    }

    private void initialize() {

        txt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addnewid();
            }
        });


    }

    private void addnewid() {
        Intent intentadd = new Intent(getApplicationContext(),Addnewid.class);
        startActivity(intentadd);
    }


}
