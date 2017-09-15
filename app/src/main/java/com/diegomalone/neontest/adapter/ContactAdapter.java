package com.diegomalone.neontest.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import com.diegomalone.neontest.model.Contact;
import com.diegomalone.neontest.views.ContactView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Diego Malone on 15/09/17.
 */

public class ContactAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context mContext;

    private List<Contact> contactList = new ArrayList<>();

    public ContactAdapter(Context context) {
        this.mContext = context;
    }

    public void setContactList(List<Contact> contactList) {
        this.contactList = contactList;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new ContactViewHolder(new ContactView(mContext));
    }

    @Override
    public int getItemCount() {
        return contactList.size();
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder contactViewHolder, int i) {
        ((ContactView) contactViewHolder.itemView).setContact(contactList.get(i));
    }


    public static class ContactViewHolder extends RecyclerView.ViewHolder {
        public ContactViewHolder(View v) {
            super(v);
        }
    }
}
