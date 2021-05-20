package com.dania.vision;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.hardware.fingerprint.FingerprintManager;
import android.os.Build;
import android.os.CancellationSignal;
import android.support.v4.content.ContextCompat;
import android.support.v4.hardware.fingerprint.FingerprintManagerCompat;
import android.widget.TextView;
import android.widget.Toast;

import java.security.PrivateKey;

@TargetApi(Build.VERSION_CODES.M)
public class FingerprintHandler2 extends FingerprintManager.AuthenticationCallback{

    int i;
    private Context context;
    public FingerprintManager.CryptoObject A ;
    public FingerprintManager.CryptoObject B = null;

    public FingerprintHandler2(Context context){

        this.context = context;

    }

    public void startAuth(FingerprintManager fingerprintManager, FingerprintManager.CryptoObject cryptoObject){



        CancellationSignal cancellationSignal = new CancellationSignal();
        fingerprintManager.authenticate(A, cancellationSignal, 0, this, null);


    }
    @Override
    public void onAuthenticationSucceeded(FingerprintManager.AuthenticationResult result) {


        Intent intent = new Intent(context, Dashboard.class);
        context.startActivity(intent);
        ((Activity) context).finish();

    }






}
