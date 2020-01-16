package com.isteel.recipessearch;

import android.app.Application;

import com.isteel.recipessearch.Repository.RepositoryProvider;
import com.orhanobut.hawk.Hawk;
import com.orhanobut.hawk.HawkBuilder;

import io.realm.Realm;
import io.realm.RealmConfiguration;
import io.realm.log.LogLevel;

public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Realm.init(this);
        RealmConfiguration config = new RealmConfiguration.Builder().name("steel.realm").build();
        Realm.setDefaultConfiguration(config);

        Hawk.init(this)
                .build();
        RepositoryProvider.init();
    }
}
