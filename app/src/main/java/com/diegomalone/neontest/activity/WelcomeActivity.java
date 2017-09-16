package com.diegomalone.neontest.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.diegomalone.neontest.R;

/**
 * Created by Diego Malone on 15/09/17.
 */

public class WelcomeActivity extends BaseActivity {

    private final String TAG = getClass().getSimpleName();

    private TextView mEmailView, mNameView;
    private ImageView mProfileView;
    private Button mSendMoneyButton, mHistoricButton;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        initializeViews();

        mNameView.setText(mIdentificationPreferences.getName());
        mEmailView.setText(mIdentificationPreferences.getEmail());

        mSendMoneyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(WelcomeActivity.this, SendMoneyActivity.class);
                startActivity(intent);
            }
        });

        mHistoricButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(WelcomeActivity.this, HistoricActivity.class);
                startActivity(intent);
            }
        });
    }

    private void initializeViews() {
        mEmailView = findViewById(R.id.email_text_view);
        mNameView = findViewById(R.id.name_text_view);
        mProfileView = findViewById(R.id.profile_image_view);
        mSendMoneyButton = findViewById(R.id.send_money_button);
        mHistoricButton = findViewById(R.id.historic_button);
    }
}
