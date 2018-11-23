package com.tribalscale.felipepaiva.telmovoice;

import android.app.Activity;
import android.app.Application;

import com.tribalscale.felipepaiva.telmovoice.dagger.DaggerMyApplicationComponent;
import com.tribalscale.felipepaiva.telmovoice.dagger.DaggerMyComponent;
import com.tribalscale.felipepaiva.telmovoice.dagger.MyComponent;
import com.tribalscale.felipepaiva.telmovoice.dagger.MyModule;

import javax.inject.Inject;

import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.HasActivityInjector;

public class MyApplication extends Application implements HasActivityInjector {
    @Inject DispatchingAndroidInjector<Activity> dispatchingAndroidInjector;

    private MyComponent mMyComponent;

    @Override
    public void onCreate() {
        super.onCreate();
//        DaggerMyApplicationComponent.create().inject(this);
        mMyComponent = createMyComponent();
    }

    MyComponent getMyComponent() {
        return mMyComponent;
    }

    private MyComponent createMyComponent() {
        return DaggerMyComponent
                .builder()
                .myModule(new MyModule(this))
                .build();
    }


    @Override
    public AndroidInjector<Activity> activityInjector() {
        return dispatchingAndroidInjector;
    }
}