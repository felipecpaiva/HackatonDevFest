package com.tribalscale.felipepaiva.telmovoice.dagger;

import com.tribalscale.felipepaiva.telmovoice.MyApplication;

import dagger.Component;
import dagger.android.AndroidInjectionModule;
import dagger.android.AndroidInjector;

@Component(modules = { AndroidInjectionModule.class, MyModule.class})
public interface MyApplicationComponent extends AndroidInjector<MyApplication> {
}