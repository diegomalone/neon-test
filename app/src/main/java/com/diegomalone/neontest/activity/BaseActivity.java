package com.diegomalone.neontest.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.diegomalone.neontest.R;
import com.diegomalone.neontest.persistence.IdentificationPreferences;

/**
 * Created by Diego Malone on 15/09/17.
 */

public class BaseActivity extends AppCompatActivity {

    private final String TAG = getClass().getSimpleName();

    protected IdentificationPreferences mIdentificationPreferences;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mIdentificationPreferences = IdentificationPreferences.getInstance(this);
    }

    protected void setupToolbar() {
        Toolbar toolbar = findViewById(R.id.toolbar);

        if (toolbar != null) {
            setSupportActionBar(toolbar);
        }
    }
}
