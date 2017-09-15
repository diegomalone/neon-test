package com.diegomalone.neontest.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.diegomalone.neontest.R;
import com.diegomalone.neontest.adapter.ContactAdapter;
import com.diegomalone.neontest.model.Contact;

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

        setupToolbar();

        setupFakeContactList();

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

    private void setupFakeContactList() {
        mContactList.add(new Contact("1", "Walter White", "(505) 836-1928", "https://vignette.wikia.nocookie.net/breakingbad/images/4/46/Cast_bb_800x600_walter-white.jpg/revision/latest/scale-to-width-down/700?cb=20170613183854"));
        mContactList.add(new Contact("2", "Jesse Pinkman", "(505) 947-1593", "https://vignette.wikia.nocookie.net/breakingbad/images/d/d3/Cast_bb_800x600_jesse-pinkman.jpg/revision/latest/scale-to-width-down/700?cb=20170613183955"));
        mContactList.add(new Contact("3", "Hank Shrader", "(505) 946-2312", "https://vignette.wikia.nocookie.net/breakingbad/images/f/f7/Cast_bb_800x600_hank-schrader.jpg/revision/latest/scale-to-width-down/700?cb=20170613184022"));
    }
}
