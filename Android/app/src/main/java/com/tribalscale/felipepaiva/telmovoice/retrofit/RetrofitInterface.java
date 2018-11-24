package com.tribalscale.felipepaiva.telmovoice.retrofit;

import retrofit2.Retrofit;

public interface RetrofitInterface {
    Retrofit getRetrofit();
    TelmoService getTelmoService();
}
