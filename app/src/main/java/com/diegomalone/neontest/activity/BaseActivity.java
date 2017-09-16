package com.diegomalone.neontest.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.diegomalone.neontest.R;
import com.diegomalone.neontest.persistence.IdentificationPreferences;
import com.diegomalone.neontest.persistence.database.DatabaseInterface;
import com.diegomalone.neontest.persistence.database.MemoryDatabaseInterface;

/**
 * Created by Diego Malone on 15/09/17.
 */

public class BaseActivity extends AppCompatActivity {

    private final String TAG = getClass().getSimpleName();

    protected IdentificationPreferences mIdentificationPreferences;

    protected DatabaseInterface mDatabaseInterface = new MemoryDatabaseInterface();

    protected View mUpButton;
    protected TextView mActivityTitleTextView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mIdentificationPreferences = IdentificationPreferences.getInstance(this);
    }

    protected void setupTopBar(String activityTitle) {
        mUpButton = findViewById(R.id.up_button);
        mActivityTitleTextView = findViewById(R.id.activity_title);

        if (mUpButton != null) {
            mUpButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    onBackPressed();
                }
            });
        }

        if (mActivityTitleTextView != null) {
            mActivityTitleTextView.setText(activityTitle);
        }
    }
}
