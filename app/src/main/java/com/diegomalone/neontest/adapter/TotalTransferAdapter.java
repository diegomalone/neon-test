package com.diegomalone.neontest.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import com.diegomalone.neontest.model.TotalTransferList;
import com.diegomalone.neontest.views.TotalTransferChartItemView;

/**
 * Created by Diego Malone on 16/09/17.
 */

public class TotalTransferAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context mContext;

    private TotalTransferList totalTransferList = new TotalTransferList();

    public TotalTransferAdapter(Context context) {
        this.mContext = context;
    }

    public void setTotalTransferList(TotalTransferList totalTransferList) {
        this.totalTransferList = totalTransferList;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new TotalTransferViewHolder(new TotalTransferChartItemView(mContext));
    }

    @Override
    public int getItemCount() {
        return totalTransferList.size();
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder totalTransferViewHolder, int i) {
        ((TotalTransferChartItemView) totalTransferViewHolder.itemView).setTotalTransfer(totalTransferList.get(i));
    }


    public static class TotalTransferViewHolder extends RecyclerView.ViewHolder {
        public TotalTransferViewHolder(View v) {
            super(v);
        }
    }
}
