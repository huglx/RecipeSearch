package com.isteel.recipessearch;

import android.app.Application;

import com.isteel.recipessearch.Repository.RepositoryProvider;
import com.orhanobut.hawk.Hawk;

import io.realm.Realm;
import io.realm.RealmConfiguration;

public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        Realm.init(this);
        RealmConfiguration config = new RealmConfiguration.Builder().name("steeL.realm").build();
        Realm.setDefaultConfiguration(config);

        Hawk.init(this)
                .build();
        RepositoryProvider.init();
    }
}
