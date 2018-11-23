package com.tribalscale.felipepaiva.telmovoice.retrofit;

import retrofit2.Retrofit;

public class RetrofitImpl implements RetrofitInterface {

    private final TelmoService service;
    private final Retrofit retrofit;

    public RetrofitImpl() {
        retrofit = new Retrofit.Builder()
                .baseUrl("https://telmo.pagekite.me/")
                .build();
        service = retrofit.create(TelmoService.class);
    }

    @Override
    public Retrofit getRetrofit() {
        return retrofit;
    }

    @Override
    public TelmoService getTelmoService() {
        return service;
    }
}
