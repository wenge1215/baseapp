package com.wenge.baseapplication.mvp.model.db;

import javax.inject.Inject;

import io.realm.Realm;
import io.realm.RealmConfiguration;

/**
 * Created by Administrator on 2018/4/18.
 */

public class RealmHelper implements DBHelper {
    private static final String DB_NAME = "myRealm.realm";

    private Realm mRealm;

    @Inject
    public RealmHelper() {
        mRealm = Realm.getInstance(new RealmConfiguration.Builder()
                .deleteRealmIfMigrationNeeded()
                .name(DB_NAME)
                .build());
    }
}
