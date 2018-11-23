package com.tribalscale.felipepaiva.telmovoice;

import android.content.Intent;
import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.tribalscale.felipepaiva.telmovoice.dagger.MyExample;
import com.tribalscale.felipepaiva.telmovoice.retrofit.RetrofitImpl;
import com.tribalscale.felipepaiva.telmovoice.retrofit.RetrofitInterface;

import java.util.Locale;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity implements TextToSpeech.OnInitListener {

    private TextToSpeech mTts;
    private int MY_DATA_CHECK_CODE = 0001;
    private boolean phoneReadyToSpeak = false;

    @Inject RetrofitInterface retrofit;
    @Inject MainActivityPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent checkIntent = new Intent();
        checkIntent.setAction(TextToSpeech.Engine.ACTION_CHECK_TTS_DATA);
        startActivityForResult(checkIntent, MY_DATA_CHECK_CODE);
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    protected void onActivityResult(
            int requestCode, int resultCode, Intent data) {
        if (requestCode == MY_DATA_CHECK_CODE) {
            if (resultCode == TextToSpeech.Engine.CHECK_VOICE_DATA_PASS) {
                // success, create the TTS instance
                mTts = new TextToSpeech(this, this);
            } else {
                // missing data, install it
                Intent installIntent = new Intent();
                installIntent.setAction(
                        TextToSpeech.Engine.ACTION_INSTALL_TTS_DATA);
                startActivity(installIntent);
            }
        }
    }

    @Override
    public void onInit(int i) {
        mTts.setLanguage(Locale.US);
        phoneReadyToSpeak = true;
    }

    private void speakText(String text) {
        mTts.speak(text, TextToSpeech.QUEUE_FLUSH, null);
    }
}
