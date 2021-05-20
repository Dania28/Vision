package com.dania.vision;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.util.Timer;
import java.util.TimerTask;

public class twitter extends AppCompatActivity {
    private LinearLayout linear2;
    private WebView webview1;
    private ProgressDialog loginprogress;
    private TimerTask timer;
    private Timer _timer = new Timer();



    private Intent intent = new Intent();
    @Override
    protected void onCreate(Bundle _savedInstanceState) {
        super.onCreate(_savedInstanceState);
        setContentView(R.layout.activity_twitter);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        getWindow().setNavigationBarColor(getResources().getColor(R.color.trans));
        //to remove the action bar (title bar)
        getSupportActionBar().hide();



        loginprogress = new ProgressDialog(this);
        loginprogress.setTitle("Logging In");
        loginprogress.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        loginprogress.setIcon(R.drawable.twitterroundlogo);
        loginprogress.setMessage("Logging you in to Twitter...");
        loginprogress.setCanceledOnTouchOutside(false);
        loginprogress.show();


        final Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                int i = 0;
                while (i < 100) {
                    try {
                        Thread.sleep(20);
                        loginprogress.incrementProgressBy(5);
                        loginprogress.incrementSecondaryProgressBy(5);
                        i++;

                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }

                }
                loginprogress.dismiss();
            }
        }
        );
        thread.start();





        initialize();
        initializeLogic();
    }

    private void initialize() {

        linear2 = (LinearLayout) findViewById(R.id.linear2);
        webview1 = (WebView) findViewById(R.id.webview1);
        webview1.getSettings().setJavaScriptEnabled(true);
        webview1.getSettings().setSupportZoom(true);


        webview1.setWebViewClient(new WebViewClient() {
            @Override
            public void onPageStarted(WebView _param1, String _param2, Bitmap _param3) {
                final String _url = _param2;

                super.onPageStarted(_param1, _param2, _param3);

            }

            @Override
            public void onPageFinished(WebView _param1, String _param2) {
                final String _url = _param2;

                super.onPageFinished(_param1, _param2);

            }
        });
    }
    private void initializeLogic() {
        webview1.loadUrl("https://mobile.twitter.com");
    }

    @Override
    public void onBackPressed() {
        if (webview1.canGoBack()) {
            webview1.goBack();
        }
        else {
            intent.setAction(Intent.ACTION_VIEW);
            intent.setClass(getApplicationContext(), Dashboard1.class);
            startActivity(intent);
            finish();
        }
    }
    @Deprecated
    public void showMessage(String _s) {
        Toast.makeText(getApplicationContext(), _s, Toast.LENGTH_SHORT).show();
    }


}
