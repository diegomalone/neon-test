package com.diegomalone.neontest.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import com.diegomalone.neontest.model.Transfer;
import com.diegomalone.neontest.views.ContactView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Diego Malone on 16/09/17.
 */

public class TransferAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context mContext;

    private List<Transfer> transferList = new ArrayList<>();

    public TransferAdapter(Context context) {
        this.mContext = context;
    }

    public void setTransferList(List<Transfer> transferList) {
        this.transferList = transferList;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new ContactAdapter.ContactViewHolder(new ContactView(mContext));
    }

    @Override
    public int getItemCount() {
        return transferList.size();
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder contactViewHolder, int i) {
        ((ContactView) contactViewHolder.itemView).setTransfer(transferList.get(i));
    }


    public static class ContactViewHolder extends RecyclerView.ViewHolder {
        public ContactViewHolder(View v) {
            super(v);
        }
    }
}
