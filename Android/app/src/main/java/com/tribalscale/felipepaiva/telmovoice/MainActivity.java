package com.tribalscale.felipepaiva.telmovoice;

import android.os.Bundle;

import com.tribalscale.felipepaiva.telmovoice.retrofit.RetrofitInterface;

import javax.inject.Inject;

public class MainActivity extends BaseActivity {

    @Inject RetrofitInterface retrofit;
    @Inject MainActivityPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onResume() {
        super.onResume();
    }
}
