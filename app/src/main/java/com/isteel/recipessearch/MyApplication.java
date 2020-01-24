package com.isteel.recipessearch;

import android.app.Application;

<<<<<<< HEAD
=======
import com.isteel.recipessearch.Repository.RepositoryProvider;
import com.isteel.recipessearch.Screen.RecipeListActivity.RecipeListActivity;
import com.orhanobut.hawk.Hawk;
import com.orhanobut.hawk.HawkBuilder;

>>>>>>> 3a0da9f... version 1.25.01
import io.realm.Realm;
import io.realm.RealmConfiguration;

public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        Realm.init(this);
<<<<<<< HEAD
        RealmConfiguration config = new RealmConfiguration.Builder().name("myrealm.realm").build();
=======
        RealmConfiguration config = new RealmConfiguration.Builder().name("steeL.realm").build();
>>>>>>> 3a0da9f... version 1.25.01
        Realm.setDefaultConfiguration(config);
    }
}
