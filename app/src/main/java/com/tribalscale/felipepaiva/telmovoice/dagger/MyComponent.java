package com.tribalscale.felipepaiva.telmovoice.dagger;

import com.tribalscale.felipepaiva.telmovoice.MainActivity;
import com.tribalscale.felipepaiva.telmovoice.MainActivityPresenter;
import com.tribalscale.felipepaiva.telmovoice.RegistrationActivity;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = MyModule.class)
public interface MyComponent {
    void inject(MainActivity mainActivity);
    void inject(MainActivityPresenter mainActivityPresenter);
    void inject(RegistrationActivity registrationActivity);
}
