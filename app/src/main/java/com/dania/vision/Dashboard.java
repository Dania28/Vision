package com.dania.vision;

import android.app.KeyguardManager;
import android.content.Intent;
import android.hardware.fingerprint.FingerprintManager;
import android.media.Image;
import android.os.Build;
import android.os.Bundle;
import android.service.voice.AlwaysOnHotwordDetector;
import android.speech.RecognizerIntent;
import android.speech.tts.TextToSpeech;
import android.support.annotation.RequiresApi;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Locale;

public class Dashboard extends AppCompatActivity {

    private ImageView fb,insta,googleplus,linkedin,twitter,gmail,flipkart,quora;
    private FingerprintManager fingerprintManager;
    private KeyguardManager keyguardManager;
    private TextToSpeech textToSpeech;
    private FloatingActionButton fab;
    private EditText editText;


    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        fingerprintManager = (FingerprintManager) getSystemService(FINGERPRINT_SERVICE);
        keyguardManager = (KeyguardManager) getSystemService(KEYGUARD_SERVICE);


        initialize();
    }

    private void initialize() {
        fb = (ImageView) findViewById(R.id.fb);
        insta = (ImageView) findViewById(R.id.insta);
        googleplus = (ImageView) findViewById(R.id.googleplus);
        linkedin = (ImageView) findViewById(R.id.linkedin);
        twitter = (ImageView) findViewById(R.id.twitter);
        gmail = (ImageView) findViewById(R.id.gmail);
        flipkart = (ImageView) findViewById(R.id.flipkart);
        quora = (ImageView) findViewById(R.id.quora);
        fab = (FloatingActionButton)findViewById(R.id.fab);
        editText = (EditText)findViewById(R.id.editText);
        textToSpeech = new TextToSpeech(this, new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if (status == TextToSpeech.SUCCESS){
                    int result = textToSpeech.setLanguage(Locale.ENGLISH);

                    if (result == TextToSpeech.LANG_MISSING_DATA || result == TextToSpeech.LANG_NOT_SUPPORTED){

                        Log.e("Vision Voicec","Language not supported");

                    }else{

                    }
                }else{
                    Log.e("Vision Voice","Initialization Failed");

                }
            }
        });


        fb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent fb = new Intent(getApplicationContext(),Fb.class);
                startActivity(fb);
                finish();

            }
        });



        insta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent insta = new Intent(getApplicationContext(),insta.class);
                startActivity(insta);
                finish();

            }
        });


        googleplus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent googleplus = new Intent(getApplicationContext(),Googleplus.class);
                startActivity(googleplus);
                finish();
            }
        });


        linkedin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent linkedin = new Intent(getApplicationContext(),linkedin.class);
                startActivity(linkedin);
                finish();
            }
        });


        twitter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent twitter = new Intent(getApplicationContext(),twitter.class);
                startActivity(twitter);
                finish();
            }
        });


        gmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent gmail = new Intent(getApplicationContext(),Gmail.class);
                startActivity(gmail);
                finish();
            }
        });



        flipkart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent flipkart = new Intent(getApplicationContext(),Flipkart.class);
                startActivity(flipkart);
                finish();
            }
        });


        quora.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent quora = new Intent(getApplicationContext(),Quora.class);
                startActivity(quora);
                finish();
            }
        });




    }

    public void openid(){

        if (editText.getText().toString().contains("Facebook")){
            Toast.makeText(this,"Opening Facebook",Toast.LENGTH_SHORT).show();
            textToSpeech.speak("Opening Facebook",TextToSpeech.QUEUE_FLUSH,null);
            Intent id = new Intent(getApplicationContext(),Fb.class);
            startActivity(id);
            finish();

        }
        else if (editText.getText().toString().contains("Insta")){
            Toast.makeText(this,"Opening Instagram",Toast.LENGTH_SHORT).show();
            textToSpeech.speak("Opening Instagram",TextToSpeech.QUEUE_FLUSH,null);
            Intent id = new Intent(getApplicationContext(),insta.class);
            startActivity(id);
            finish();


        }
        else if (editText.getText().toString().contains("Google")){
            Toast.makeText(this,"Opening Google Plus",Toast.LENGTH_SHORT).show();
            textToSpeech.speak("Opening Google Plus",TextToSpeech.QUEUE_FLUSH,null);
            Intent id = new Intent(getApplicationContext(),Googleplus.class);
            startActivity(id);
            finish();

        }
        else if (editText.getText().toString().contains("Linkedin")){
            Toast.makeText(this,"Opening Linkedin",Toast.LENGTH_SHORT).show();
            textToSpeech.speak("Opening Linkedin",TextToSpeech.QUEUE_FLUSH,null);
            Intent id = new Intent(getApplicationContext(),linkedin.class);
            startActivity(id);
            finish();


        }
        else if (editText.getText().toString().contains("Twitter")){
            Toast.makeText(this,"Opening Twitter",Toast.LENGTH_SHORT).show();
            textToSpeech.speak("Opening Twitter",TextToSpeech.QUEUE_FLUSH,null);
            Intent id = new Intent(getApplicationContext(),twitter.class);
            startActivity(id);
            finish();


        }
        else if (editText.getText().toString().contains("Gmail")){
            Toast.makeText(this,"Opening Gmail",Toast.LENGTH_SHORT).show();
            textToSpeech.speak("Opening Gmail",TextToSpeech.QUEUE_FLUSH,null);
            Intent id = new Intent(getApplicationContext(),Gmail.class);
            startActivity(id);
            finish();


        }
        else if (editText.getText().toString().contains("Flipkart")){
            Toast.makeText(this,"Opening Flipkart",Toast.LENGTH_SHORT).show();
            textToSpeech.speak("Opening Flipkart",TextToSpeech.QUEUE_FLUSH,null);
            Intent id = new Intent(getApplicationContext(),Flipkart.class);
            startActivity(id);
            finish();


        }

        else if (editText.getText().toString().contains("hello") || editText.getText().toString().contains("hi"))   {
            Toast.makeText(this, "Hello , How Are You ??", Toast.LENGTH_SHORT).show();
            textToSpeech.speak("Hello , How Are You ",TextToSpeech.QUEUE_FLUSH,null);

        }

        else if (editText.getText().toString().contains("fine"))   {
            Toast.makeText(this, "Good", Toast.LENGTH_SHORT).show();
            textToSpeech.speak("Good",TextToSpeech.QUEUE_FLUSH,null);

        }
        else if (editText.getText().toString().contains("who are you")) {
            Toast.makeText(this, "I am Vision Assistant. You can call me Vision, I am here to help you with this App", Toast.LENGTH_SHORT).show();
            textToSpeech.speak("I am Vision Assistant. You can call me Vision, I am here to help you with this App ",TextToSpeech.QUEUE_FLUSH,null);
        }
        else if (editText.getText().toString().contains("exit") || editText.getText().toString().contains("close")) {
            Toast.makeText(this, "Closing the App", Toast.LENGTH_SHORT).show();
            textToSpeech.speak("Closing the App ",TextToSpeech.QUEUE_FLUSH,null);
            finish();

        }
        else if (editText.getText().toString().contains("Quora")){
            Toast.makeText(this,"Opening Quora",Toast.LENGTH_SHORT).show();
            textToSpeech.speak("Opening Quora",TextToSpeech.QUEUE_FLUSH,null);
            Intent id = new Intent(getApplicationContext(),Quora.class);
            startActivity(id);
            finish();


        }

        else{
            Toast.makeText(this,"Sorry, I Don't understand",Toast.LENGTH_SHORT).show();
            textToSpeech.speak("Sorry, I Don't understand",TextToSpeech.QUEUE_FLUSH,null);

        }


    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        switch (requestCode){
            case 10:
                if (resultCode == RESULT_OK && data != null){
                    ArrayList<String> result = data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
                    editText.setText(result.get(0));
                    openid();
                }
                break;
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();

        FingerprintHandler2 fingerprintHandler = new FingerprintHandler2(this);
        fingerprintHandler.startAuth(fingerprintManager,null);
    }

    public void getSpeechInput(View view) {
        editText.setText(null);
        Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL,RecognizerIntent.EXTRA_LANGUAGE);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE, Locale.getDefault());

        if (intent.resolveActivity(getPackageManager()) != null){
            startActivityForResult(intent, 10);

        }
        else{
            Toast.makeText(this,"Your Device doesnot support Speech Input",Toast.LENGTH_SHORT).show();
        }
    }
}
