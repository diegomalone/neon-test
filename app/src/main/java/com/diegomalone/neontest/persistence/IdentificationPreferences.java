package com.diegomalone.neontest.persistence;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

/**
 * Created by Diego Malone on 15/09/17.
 */

public class IdentificationPreferences {

    private final String TAG = getClass().getSimpleName();

    private static final String PREF_NAME = "identificationPreferences";

    private static final String KEY_NAME = "name";
    private static final String KEY_EMAIL = "email";
    private static final String KEY_TOKEN = "token";

    private SharedPreferences mSharedPreferences;
    private SharedPreferences.Editor mEditor;

    private Context mContext;

    private static IdentificationPreferences mInstance;

    public static IdentificationPreferences getInstance(Context context) {
        if (mInstance == null) {
            mInstance = new IdentificationPreferences(context);
        }

        return mInstance;
    }

    private IdentificationPreferences(Context context) {
        mContext = context;
        mSharedPreferences = mContext.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
        mEditor = mSharedPreferences.edit();
    }

    public void setName(String name) {
        mEditor.putString(KEY_NAME, name);
        mEditor.commit();
    }

    public String getName() {
        return mSharedPreferences.getString(KEY_NAME, null);
    }

    public boolean hasName() {
        return getName() != null;
    }

    public void setEmail(String email) {
        mEditor.putString(KEY_EMAIL, email);
        mEditor.commit();
    }

    public String getEmail() {
        return mSharedPreferences.getString(KEY_EMAIL, null);
    }

    public boolean hasEmail() {
        return getEmail() != null;
    }

    public void setToken(String token) {
        Log.i(TAG, "storing token: " + token);
        mEditor.putString(KEY_TOKEN, token);
        mEditor.commit();
    }

    public String getToken() {
        return mSharedPreferences.getString(KEY_TOKEN, null);
    }

    public boolean hasToken() {
        return getToken() != null;
    }
}
