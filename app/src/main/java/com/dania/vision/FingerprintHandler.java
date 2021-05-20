package com.dania.vision;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.hardware.fingerprint.FingerprintManager;
import android.os.Build;
import android.os.CancellationSignal;
import android.support.v4.content.ContextCompat;
import android.widget.TextView;

@TargetApi(Build.VERSION_CODES.M)
public class FingerprintHandler extends FingerprintManager.AuthenticationCallback{

    private Context context;
    public FingerprintManager.CryptoObject F;

    public FingerprintHandler(Context context){

        this.context = context;

    }

    public void startAuth(FingerprintManager fingerprintManager, FingerprintManager.CryptoObject cryptoObject){

        CancellationSignal cancellationSignal = new CancellationSignal();
        fingerprintManager.authenticate(F, cancellationSignal, 0, this, null);


    }

    @Override
    public void onAuthenticationError(int errorCode, CharSequence errString) {
        this.update("There was an Auth Error"+errString,false);
    }

    @Override
    public void onAuthenticationFailed() {
        this.update("Auth Failed.",false);
    }

    @Override
    public void onAuthenticationHelp(int helpCode, CharSequence helpString) {
        this.update("Error:"+helpString,false);

    }

    @Override
    public void onAuthenticationSucceeded(FingerprintManager.AuthenticationResult result) {
        this.update("Successfully LOGGED IN",true);
        Intent intent = new Intent(context, Dashboard1.class);
        context.startActivity(intent);
        ((Activity)context).finish();
        ((Activity)context).overridePendingTransition(R.anim.fade_in,R.anim.fade_out);





    }

    public void update(String s, boolean b){

        TextView txt1 = (TextView) ((Activity)context).findViewById(R.id.txt1);
        txt1.setText(s);

        if (b == false){
            txt1.setTextColor(ContextCompat.getColor(context,R.color.colorError));
        }
        else {
            txt1.setTextColor(ContextCompat.getColor(context,R.color.colorAccent));

        }


    }
}
