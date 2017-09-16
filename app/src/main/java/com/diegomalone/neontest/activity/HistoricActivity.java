package com.diegomalone.neontest.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.diegomalone.neontest.R;
import com.diegomalone.neontest.adapter.TransferAdapter;
import com.diegomalone.neontest.model.Contact;
import com.diegomalone.neontest.model.Transfer;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Diego Malone on 15/09/17.
 */

public class HistoricActivity extends BaseActivity {

    private final String TAG = getClass().getSimpleName();

    private RecyclerView mContactRecyclerView;

    private TransferAdapter transferAdapter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_historic);

        setupTopBar(getString(R.string.historic_activity_title));

        initializeViews();

        setupRecyclerView();
    }

    private void setupRecyclerView() {
        transferAdapter = new TransferAdapter(this);

        mContactRecyclerView.setAdapter(transferAdapter);
        mContactRecyclerView.setHasFixedSize(true);
        mContactRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mContactRecyclerView.setItemAnimator(new DefaultItemAnimator());

        transferAdapter.setTransferList(addContactsToTransfer(setupTransferList()));
    }

    private void initializeViews() {
        mContactRecyclerView = findViewById(R.id.payment_history_recycler_view);
    }

    private List<Transfer> setupTransferList() {
        List<Transfer> transferList = new ArrayList<>();

        transferList.add(new Transfer(1, 1, 120, ""));
        transferList.add(new Transfer(2, 1, 1220, ""));
        transferList.add(new Transfer(3, 7, 100, ""));

        return transferList;
    }

    private List<Transfer> addContactsToTransfer(List<Transfer> transferList) {
        List<Transfer> transferListWithContact = new ArrayList<>();

        for (Transfer transfer : transferList) {
            Contact contact = mDatabaseInterface.getContact(transfer.getContactId());
            transfer.setContact(contact);

            transferListWithContact.add(transfer);
        }


        return transferListWithContact;
    }
}
