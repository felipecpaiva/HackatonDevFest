package com.tribalscale.felipepaiva.telmovoice;

import android.content.Intent;
import android.os.Bundle;
import android.speech.RecognitionListener;
import android.speech.RecognizerIntent;
import android.speech.SpeechRecognizer;
import android.speech.tts.TextToSpeech;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import java.util.ArrayList;
import java.util.Locale;

public class BaseActivity extends AppCompatActivity  implements TextToSpeech.OnInitListener, RecognitionListener {
    private String TAG = BaseActivity.class.getName();
    private TextToSpeech mTts;
    private SpeechRecognizer stt;
    private int MY_DATA_CHECK_CODE = 0001;
    private boolean phoneReadyToSpeak = false;
    private Intent recognizer_intent;
    private boolean readyToListen = false;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initTextToSpech();
    }

    private void initTextToSpech() {
        Intent checkIntent = new Intent();
        checkIntent.setAction(TextToSpeech.Engine.ACTION_CHECK_TTS_DATA);
        startActivityForResult(checkIntent, MY_DATA_CHECK_CODE);
    }

    protected void onActivityResult(
            int requestCode, int resultCode, Intent data) {
        if (requestCode == MY_DATA_CHECK_CODE) {
            if (resultCode == TextToSpeech.Engine.CHECK_VOICE_DATA_PASS) {
                // success, create the TTS instance
                mTts = new TextToSpeech(this, this);
                mTts.setSpeechRate(0.8f);
                initSTT();
            } else {
                // missing data, install it
                Intent installIntent = new Intent();
                installIntent.setAction(
                        TextToSpeech.Engine.ACTION_INSTALL_TTS_DATA);
                startActivity(installIntent);
            }
        }
    }

    private void initSTT() {
        stt = SpeechRecognizer.createSpeechRecognizer(this);
        stt.setRecognitionListener(this);

        recognizer_intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
    }

    @Override
    public void onInit(int i) {
        mTts.setLanguage(Locale.US);
        phoneReadyToSpeak = true;
    }

    public void speakText(String text) {
        mTts.speak(text, TextToSpeech.QUEUE_ADD, null);
    }

    @Override
    public void onReadyForSpeech(Bundle bundle) {
        readyToListen = true;
    }

    @Override
    public void onBeginningOfSpeech() {

    }

    @Override
    public void onRmsChanged(float v) {

    }

    @Override
    public void onBufferReceived(byte[] bytes) {

    }

    @Override
    public void onEndOfSpeech() {

    }

    @Override
    public void onError(int i) {

    }

    @Override
    public void onResults(Bundle results) {
        String str = new String();
        Log.d(TAG, "onResults " + results);
        ArrayList data = results.getStringArrayList(SpeechRecognizer.RESULTS_RECOGNITION);
        for (int i = 0; i < data.size(); i++) {
            Log.d(TAG, "result " + data.get(i));
            str += data.get(i);
        }
        Log.d(TAG, "results: "+String.valueOf(data.size()));
    }

    @Override
    public void onPartialResults(Bundle bundle) {
        ArrayList data = bundle.getStringArrayList(SpeechRecognizer.RESULTS_RECOGNITION);
        String word = (String) data.get(data.size() - 1);
//        recognisedText.setText(word);

        Log.i("TEST", "partial_results: " + word);
    }

    @Override
    public void onEvent(int i, Bundle bundle) {

    }

    public void startListening(){
        stt = SpeechRecognizer.createSpeechRecognizer(this);
        stt.setRecognitionListener(this);

        Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL,RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
        intent.putExtra(RecognizerIntent.EXTRA_CALLING_PACKAGE,"voice.recognition.test");
        intent.putExtra(RecognizerIntent.EXTRA_MAX_RESULTS,1);
        stt.startListening(intent);
    }

    public void stopListening(){
        stt.stopListening();
    }
}
