package com.tribalscale.felipepaiva.telmovoice.dagger;

import android.app.Application;
import android.content.Context;

import com.tribalscale.felipepaiva.telmovoice.MainActivity;
import com.tribalscale.felipepaiva.telmovoice.MainActivityPresenter;
import com.tribalscale.felipepaiva.telmovoice.retrofit.RetrofitImpl;
import com.tribalscale.felipepaiva.telmovoice.retrofit.RetrofitInterface;
import com.tribalscale.felipepaiva.telmovoice.retrofit.TelmoService;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import dagger.android.ContributesAndroidInjector;
import retrofit2.Retrofit;

@Module
public class MyModule {
    private final Context context;

    public MyModule(Application context) {
        this.context = context;
    }

    @Provides @Singleton
    Context provideContext() {
        return context;
    }

    @Provides
    @Singleton
    static MyExample provideMyExample() {
        return new MyExampleImpl();
    }

    @Provides
    @Singleton
    static TelmoService provideDagger(RetrofitInterface retrofit) {
        return retrofit.getTelmoService();
    }

    @Provides
    @Singleton
    static RetrofitImpl provideRetrofit() {
        return new RetrofitImpl();
    }

    @Provides
    @Singleton
    static RetrofitInterface provideRetrofitInterface() {
        return new RetrofitImpl();
    }

    @Provides
    @Singleton
    static MainActivityPresenter mainActivityPresenter() {
        return new MainActivityPresenter();
    }
}