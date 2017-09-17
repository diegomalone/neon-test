package com.diegomalone.neontest.views;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.diegomalone.neontest.R;
import com.diegomalone.neontest.activity.BaseActivity;
import com.diegomalone.neontest.model.Contact;
import com.diegomalone.neontest.network.service.TransferApi;
import com.diegomalone.neontest.persistence.IdentificationPreferences;
import com.diegomalone.neontest.utils.MoneyUtils;

import org.apache.commons.lang3.StringUtils;

import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;

import static android.view.View.GONE;
import static android.view.View.VISIBLE;

/**
 * Created by Diego Malone on 16/09/17.
 */

public class SendMoneyDialog extends Dialog {

    public final String TAG = getClass().getSimpleName();

    private Context mContext;

    private IdentificationPreferences mIdentificationPreferences;
    private TransferApi mTransferApi;

    private View mCloseButton;
    private TextView mNameView, mPhoneView;
    private ImageView mContactProfileImageView;
    private EditText mValueToSendEditText;
    private Button mSendMoneyButton;
    private UltraLoading mUltraLoading;

    private String mSendMoneyButtonText;

    private Contact mContact;

    public SendMoneyDialog(@NonNull Context context) {
        super(context);

        mContext = context;

        mIdentificationPreferences = IdentificationPreferences.getInstance(mContext);
        mTransferApi = new TransferApi(mContext);
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
        mSendMoneyButton = findViewById(R.id.send_money_button);
        mValueToSendEditText = findViewById(R.id.value_to_send_edit_text);
        mUltraLoading = findViewById(R.id.loading);

        mValueToSendEditText.addTextChangedListener(MoneyUtils.getMoneyTextWatcher(mContext, mValueToSendEditText));
        mValueToSendEditText.setText("");

        mSendMoneyButtonText = mSendMoneyButton.getText().toString();

        mCloseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SendMoneyDialog.this.cancel();
            }
        });

        mSendMoneyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendMoney();
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

    private void sendMoney() {
        double value = MoneyUtils.getDoubleValue(mValueToSendEditText.getText().toString());

        showLoading();

        mTransferApi.sendMoney(mContact.getId(), mIdentificationPreferences.getToken(), value)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<String>() {
                    @Override
                    public void call(String response) {
                        if (StringUtils.equalsIgnoreCase(response, "true")) {
                            SendMoneyDialog.this.cancel();
                        }

                        ((BaseActivity) mContext).showSuccessMessage(mContext.getString(R.string.send_money_success));

                        hideLoading();
                    }
                }, new Action1<Throwable>() {
                    @Override
                    public void call(Throwable throwable) {
                        hideLoading();
                        throwable.printStackTrace();
                    }
                });
    }

    private void showLoading() {
        mUltraLoading.setVisibility(VISIBLE);
        mSendMoneyButton.setText(null);
    }

    private void hideLoading() {
        mUltraLoading.setVisibility(GONE);
        mSendMoneyButton.setText(mSendMoneyButtonText);
    }
}
