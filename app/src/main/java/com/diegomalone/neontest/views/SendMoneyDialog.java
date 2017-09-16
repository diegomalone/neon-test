package com.diegomalone.neontest.views;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.diegomalone.neontest.R;
import com.diegomalone.neontest.model.Contact;
import com.diegomalone.neontest.utils.MoneyUtils;

/**
 * Created by Diego Malone on 16/09/17.
 */

public class SendMoneyDialog extends Dialog {

    public final String TAG = getClass().getSimpleName();

    private Context mContext;

    private View mCloseButton;
    private TextView mNameView, mPhoneView;
    private ImageView mContactProfileImageView;
    private EditText mValueToSendEditText;

    private Contact mContact;

    public SendMoneyDialog(@NonNull Context context) {
        super(context);

        mContext = context;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialog_send_money);

        getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

        initializeViews();
    }

    private void initializeViews() {
        mCloseButton = findViewById(R.id.close_button);
        mContactProfileImageView = findViewById(R.id.contact_profile_view);
        mNameView = findViewById(R.id.name_text_view);
        mPhoneView = findViewById(R.id.phone_text_view);
        mValueToSendEditText = findViewById(R.id.value_to_send_edit_text);

        mValueToSendEditText.addTextChangedListener(MoneyUtils.getMoneyTextWatcher(mContext, mValueToSendEditText));
        mValueToSendEditText.setText("");

        mCloseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SendMoneyDialog.this.cancel();
            }
        });
    }

    public void setContact(Contact contact) {
        this.mContact = contact;

        mNameView.setText(contact.getName());
        mPhoneView.setText(contact.getPhone());

        Glide.with(mContext)
                .load(contact.getPhotoUrl())
                .into(mContactProfileImageView);
    }
}
