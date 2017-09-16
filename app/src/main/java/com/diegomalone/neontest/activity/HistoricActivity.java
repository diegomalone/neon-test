package com.diegomalone.neontest.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.diegomalone.neontest.R;
import com.diegomalone.neontest.adapter.ContactAdapter;
import com.diegomalone.neontest.persistence.ContactDatabase;

/**
 * Created by Diego Malone on 15/09/17.
 */

public class HistoricActivity extends BaseActivity {

    private final String TAG = getClass().getSimpleName();

    private RecyclerView mContactRecyclerView;

    private ContactAdapter mContactAdapter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_historic);

        setupTopBar(getString(R.string.historic_activity_title));

        initializeViews();

        setupRecyclerView();
    }

    private void setupRecyclerView() {
        mContactAdapter = new ContactAdapter(this);

        mContactRecyclerView.setAdapter(mContactAdapter);
        mContactRecyclerView.setHasFixedSize(true);
        mContactRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mContactRecyclerView.setItemAnimator(new DefaultItemAnimator());

        mContactAdapter.setContactList(ContactDatabase.getContactListWithTransfers());
    }

    private void initializeViews() {
        mContactRecyclerView = findViewById(R.id.payment_history_recycler_view);
    }

}
