package com.diegomalone.neontest.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.diegomalone.neontest.R;
import com.diegomalone.neontest.adapter.ContactAdapter;
import com.diegomalone.neontest.model.Contact;
import com.diegomalone.neontest.views.dialog.SendMoneyDialog;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Diego Malone on 15/09/17.
 */

public class SendMoneyActivity extends BaseActivity {

    private final String TAG = getClass().getSimpleName();

    private RecyclerView mContactRecyclerView;

    private List<Contact> mContactList = new ArrayList<>();
    private ContactAdapter mContactAdapter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send_money);

        setupDefaultViews(getString(R.string.send_money_activity_title));

        mContactList = mDatabaseInterface.getContactList();

        initializeViews();

        setupRecyclerView();
    }

    private void setupRecyclerView() {
        mContactAdapter = new ContactAdapter(this);

        mContactRecyclerView.setAdapter(mContactAdapter);
        mContactRecyclerView.setHasFixedSize(true);
        mContactRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mContactRecyclerView.setItemAnimator(new DefaultItemAnimator());

        mContactAdapter.setContactList(mContactList);
    }

    private void initializeViews() {
        mContactRecyclerView = findViewById(R.id.contact_recycler_view);
    }

    public void selectContact(Contact contact) {
        SendMoneyDialog customDialog = new SendMoneyDialog(this);
        customDialog.show();

        customDialog.setContact(contact);
    }
}
