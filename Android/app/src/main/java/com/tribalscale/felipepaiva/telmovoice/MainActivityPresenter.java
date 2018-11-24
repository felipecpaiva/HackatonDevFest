package com.tribalscale.felipepaiva.telmovoice;

import com.tribalscale.felipepaiva.telmovoice.retrofit.RetrofitImpl;
import com.tribalscale.felipepaiva.telmovoice.retrofit.RetrofitInterface;

import javax.inject.Inject;

public class MainActivityPresenter {
    @Inject RetrofitInterface retrofit;

    public MainActivityPresenter() {}
}
