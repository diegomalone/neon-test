package com.diegomalone.neontest.utils;

import android.content.Context;

import com.diegomalone.neontest.network.service.TransferApi;
import com.diegomalone.neontest.persistence.IdentificationPreferences;

import rx.functions.Action1;

/**
 * Created by Diego Malone on 15/09/17.
 */

public class IdentificationUtils {

    private final String TAG = getClass().getSimpleName();

    private static final String USER_NAME = "Diego Malone";
    private static final String USER_EMAIL = "diegomalone@gmail.com";

    private Context mContext;
    private IdentificationPreferences mIdentificationPreferences;

    public IdentificationUtils(Context context) {
        mContext = context;

        mIdentificationPreferences = IdentificationPreferences.getInstance(mContext);
    }

    public void generateIdentificationData() {
        if (!mIdentificationPreferences.hasName()) {
            mIdentificationPreferences.setName(USER_NAME);
        }

        if (!mIdentificationPreferences.hasEmail()) {
            mIdentificationPreferences.setEmail(USER_EMAIL);
        }

        if (!mIdentificationPreferences.hasToken()) {
            generateApiToken(mIdentificationPreferences.getEmail(), mIdentificationPreferences.getName());
        }
    }

    private void generateApiToken(String email, String name) {
        TransferApi transferApi = new TransferApi(mContext);

        transferApi.generateToken(email, name)
                .subscribe(new Action1<String>() {
                    @Override
                    public void call(String stringResponse) {

                        mIdentificationPreferences.setToken(stringResponse);
                    }
                }, new Action1<Throwable>() {
                    @Override
                    public void call(Throwable throwable) {
                        throwable.printStackTrace();
                    }
                });
    }
}
