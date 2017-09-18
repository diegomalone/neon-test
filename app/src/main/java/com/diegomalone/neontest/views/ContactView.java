package com.diegomalone.neontest.views;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;

import com.diegomalone.neontest.R;
import com.diegomalone.neontest.activity.SendMoneyActivity;
import com.diegomalone.neontest.model.Contact;
import com.diegomalone.neontest.model.Transfer;
import com.diegomalone.neontest.utils.MoneyUtils;
import com.diegomalone.neontest.views.element.PhotoView;

/**
 * Created by Diego Malone on 15/09/17.
 */

public class ContactView extends BaseCardView {

    public final String TAG = getClass().getSimpleName();

    private Context mContext;

    private TextView mNameView, mPhoneView, mTransferredValueView;
    private PhotoView mContactProfileImageView;

    private Contact mContact;

    public ContactView(Context context) {
        super(context);
        initialize(context);
    }

    public ContactView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initialize(context);
    }

    private void initialize(Context context) {
        mContext = context;

        inflate(mContext, R.layout.view_contact, this);

        mContactProfileImageView = findViewById(R.id.contact_profile_view);
        mNameView = findViewById(R.id.name_text_view);
        mPhoneView = findViewById(R.id.phone_text_view);
        mTransferredValueView = findViewById(R.id.transferred_value_text_view);
    }

    public void setContact(final Contact contact) {
        this.mContact = contact;

        mNameView.setText(contact.getName());
        mPhoneView.setText(contact.getPhone());
        mContactProfileImageView.setContact(contact);

        setOnItemSelectedListener();
    }

    private void setOnItemSelectedListener() {
        if (mContext instanceof SendMoneyActivity) {
            setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View view) {
                    ((SendMoneyActivity) mContext).selectContact(mContact);
                }
            });
        }
    }

    private void setTransferredValue(Transfer transfer) {
        mTransferredValueView.setText(MoneyUtils.getMoneyString(mContext, transfer.getValue()));
        mTransferredValueView.setVisibility(VISIBLE);
    }

    public void setTransfer(Transfer transfer) {
        if (!transfer.hasContact()) return;

        setContact(transfer.getContact());

        setTransferredValue(transfer);
    }
}
