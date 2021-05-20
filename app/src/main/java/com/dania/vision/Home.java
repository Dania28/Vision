package com.dania.vision;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.nfc.Tag;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.speech.RecognitionListener;
import android.speech.RecognizerIntent;
import android.speech.SpeechRecognizer;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Locale;
import java.util.Timer;
import java.util.TimerTask;

import static android.app.Activity.RESULT_OK;


public class Home extends Fragment implements RecognitionListener {

    private SpeechRecognizer speech = null;
    private Timer speechTimeout = null;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);


        ImageView fb = (ImageView) view.findViewById(R.id.fb);
        ImageView insta = (ImageView) view.findViewById(R.id.insta);
        ImageView googleplus = (ImageView) view.findViewById(R.id.googleplus);
        ImageView linkedin = (ImageView) view.findViewById(R.id.linkedin);
        ImageView twitter = (ImageView) view.findViewById(R.id.twitter);
        ImageView gmail = (ImageView) view.findViewById(R.id.gmail);
        ImageView flipkart = (ImageView) view.findViewById(R.id.flipkart);
        ImageView quora = (ImageView) view.findViewById(R.id.quora);
        ImageView search_voice_btn = (ImageView) view.findViewById(R.id.search_voice_btn);
        SearchView search_bar = (SearchView) view.findViewById(R.id.search_bar);
        de.hdodenhof.circleimageview.CircleImageView profile_pic_home = (de.hdodenhof.circleimageview.CircleImageView) view.findViewById(R.id.profile_pic_home);
        TextView user_name = (TextView) view.findViewById(R.id.user_name);

       fb.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Intent fb = new Intent(getActivity(),Fb.class);
               startActivity(fb);
               getActivity().finish();
           }
       });

        insta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent insta = new Intent(getActivity(), insta.class);
                startActivity(insta);
                getActivity().finish();
            }
        });


        googleplus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent googleplus = new Intent(getActivity(), Googleplus.class);
                startActivity(googleplus);
                getActivity().finish();
            }
        });


        linkedin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent linkedin = new Intent(getActivity(), linkedin.class);
                startActivity(linkedin);
                getActivity().finish();
            }
        });


        twitter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent twitter = new Intent(getActivity(), twitter.class);
                startActivity(twitter);
                getActivity().finish();
            }
        });


        gmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent gmail = new Intent(getActivity(), Gmail.class);
                startActivity(gmail);
                getActivity().finish();
            }
        });


        flipkart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent flipkart = new Intent(getActivity(), Flipkart.class);
                startActivity(flipkart);
                getActivity().finish();
            }
        });


        profile_pic_home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



            }
        });


        quora.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent quora = new Intent(getActivity(), Quora.class);
                startActivity(quora);
                getActivity().finish();
            }
        });

        search_voice_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    startVoiceRecognition();
                }
        });


        return view;
    }

    private SpeechRecognizer getSpeechRecognizer() {
        if (speech == null) {
            speech = SpeechRecognizer.createSpeechRecognizer(getActivity());
            speech.setRecognitionListener(this);
        }
        return speech;
    }



    public void startVoiceRecognition() {
        Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
        getSpeechRecognizer().startListening(intent);



    }

    public void stopVoiceRecognition(){
        speechTimeout.cancel();
        if (speech != null){
            speech.destroy();
            speech = null;
        }
    }
    public class SilenceTimer extends TimerTask{

        @Override
        public void run() {
            onError(SpeechRecognizer.ERROR_SPEECH_TIMEOUT);
        }
    }

    @Override
    public void onReadyForSpeech(Bundle params) {

        speechTimeout = new Timer();
        speechTimeout.schedule(new SilenceTimer(), 3000);

    }

    @Override
    public void onBeginningOfSpeech() {
        Log.i("Home","onBeginningOfSpeech");

        speechTimeout.cancel();
    }

    @Override
    public void onRmsChanged(float rmsdB) {
        Log.i("Home","onRmsChanged");

    }

    @Override
    public void onBufferReceived(byte[] buffer) {
        Log.i("Home","onBufferReceived");


    }

    @Override
    public void onEndOfSpeech() {
        Log.i("Home","onEndOfSpeech");
        getSpeechRecognizer().stopListening();

    }

    @Override
    public void onError(int error) {

        Log.i("Home","onError");

    }

    @Override
    public void onResults(Bundle results) {

        Log.i("Home","onResults");

        ArrayList<String> matches = results.getStringArrayList(SpeechRecognizer.RESULTS_RECOGNITION);
        String text = " ";
        for (String result : matches)
            text = result + "\n";
        Toast.makeText(getActivity(),text,Toast.LENGTH_SHORT).show();



    }

    @Override
    public void onPartialResults(Bundle partialResults) {
        Log.i("Home","onPartialResults");

    }

    @Override
    public void onEvent(int eventType, Bundle params) {
        Log.i("Home","onEvents");

    }
}
