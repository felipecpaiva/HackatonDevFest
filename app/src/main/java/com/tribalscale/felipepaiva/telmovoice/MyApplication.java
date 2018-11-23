package com.tribalscale.felipepaiva.telmovoice;

import android.app.Application;

import com.tribalscale.felipepaiva.telmovoice.dagger.DaggerMyComponent;
import com.tribalscale.felipepaiva.telmovoice.dagger.MyComponent;
import com.tribalscale.felipepaiva.telmovoice.dagger.MyModule;

public class MyApplication extends Application {
    private MyComponent mMyComponent;

    @Override
    public void onCreate() {
        super.onCreate();
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
}