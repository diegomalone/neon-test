package com.diegomalone.neontest.application;

import android.app.Application;

import com.diegomalone.neontest.utils.IdentificationUtils;

/**
 * Created by Diego Malone on 15/09/17.
 */

public class NeonApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        IdentificationUtils identificationUtils = new IdentificationUtils(this);
        identificationUtils.generateIdentificationData();
    }
}
