package com.diegomalone.neontest.activity;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.diegomalone.neontest.R;

/**
 * Created by Diego Malone on 15/09/17.
 */

public class BaseActivity extends AppCompatActivity {

    protected void setupToolbar() {
        Toolbar toolbar = findViewById(R.id.toolbar);

        if (toolbar != null) {
            setSupportActionBar(toolbar);
        }
    }
}
