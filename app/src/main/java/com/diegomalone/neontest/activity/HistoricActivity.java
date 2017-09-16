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
import com.diegomalone.neontest.network.response.TransferResponse;
import com.diegomalone.neontest.network.service.TransferApi;
import com.diegomalone.neontest.network.response.ApiResponseConverter;

import java.util.ArrayList;
import java.util.List;

import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;

/**
 * Created by Diego Malone on 15/09/17.
 */

public class HistoricActivity extends BaseActivity {

    private final String TAG = getClass().getSimpleName();

    private TransferApi mTransferApi;

    private RecyclerView mContactRecyclerView;

    private TransferAdapter mTransferAdapter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_historic);

        setupTopBar(getString(R.string.historic_activity_title));

        mTransferApi = new TransferApi(this);

        initializeViews();

        setupRecyclerView();

        requestTransferList();
    }

    private void setupRecyclerView() {
        mTransferAdapter = new TransferAdapter(this);

        mContactRecyclerView.setAdapter(mTransferAdapter);
        mContactRecyclerView.setHasFixedSize(true);
        mContactRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mContactRecyclerView.setItemAnimator(new DefaultItemAnimator());
    }

    private void initializeViews() {
        mContactRecyclerView = findViewById(R.id.payment_history_recycler_view);
    }

    private void requestTransferList() {
        mTransferApi.getTransfers(mIdentificationPreferences.getToken())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<List<TransferResponse>>() {
                    @Override
                    public void call(List<TransferResponse> transferListResponse) {
                        ApiResponseConverter<Transfer> apiResponseConverter = new ApiResponseConverter<>();
                        List<Transfer> transferList = apiResponseConverter.getModelList(transferListResponse);

                        receivedTransferList(transferList);
                    }
                }, new Action1<Throwable>() {
                    @Override
                    public void call(Throwable throwable) {
                        throwable.printStackTrace();
                    }
                });
    }

    private void receivedTransferList(List<Transfer> transferList) {
        mTransferAdapter.setTransferList(addContactsToTransfer(transferList));
        mTransferAdapter.notifyDataSetChanged();
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
