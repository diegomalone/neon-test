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

        setupTopBar(getString(R.string.send_money_activity_title));

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
        mContactList.add(new Contact("1", "Walter White", "(505) 737-0000", "https://vignette.wikia.nocookie.net/breakingbad/images/4/46/Cast_bb_800x600_walter-white.jpg/revision/latest/scale-to-width-down/700?cb=20170613183854"));
        mContactList.add(new Contact("2", "Jesse Pinkman", "(505) 947-1593", "https://vignette.wikia.nocookie.net/breakingbad/images/d/d3/Cast_bb_800x600_jesse-pinkman.jpg/revision/latest/scale-to-width-down/700?cb=20170613183955"));
        mContactList.add(new Contact("3", "Hank Shrader", "(505) 946-2312", "https://vignette.wikia.nocookie.net/breakingbad/images/f/f7/Cast_bb_800x600_hank-schrader.jpg/revision/latest/scale-to-width-down/700?cb=20170613184022"));
        mContactList.add(new Contact("4", "Skyler White", "(505) 587-3914", "https://vignette.wikia.nocookie.net/breakingbad/images/b/bd/Cast_bb_800x600_skyler-white.jpg/revision/latest/scale-to-width-down/350?cb=20170613183930"));
        mContactList.add(new Contact("5", "Jimmy McGill (Saul Goldman)", "(505) 842-5325", "https://vignette.wikia.nocookie.net/breakingbad/images/5/56/BCS_S3_JimmyMcGill.jpg/revision/latest/scale-to-width-down/350?cb=20170327184952"));
        mContactList.add(new Contact("6", "Mike Ehrmantraut", "(505) 481-1349", "https://vignette.wikia.nocookie.net/breakingbad/images/8/8d/BCS_S3_MikeEhrmantraut.jpg/revision/latest/scale-to-width-down/350?cb=20170327185046"));
        mContactList.add(new Contact("7", "Gustavo Fring", "(505) 239-3949", "https://vignette.wikia.nocookie.net/breakingbad/images/a/ab/BCS_S3_GusFringe.jpg/revision/latest/scale-to-width-down/350?cb=20170327185354"));
        mContactList.add(new Contact("8", "Marie Schrader", "(505) 398-5993", "https://vignette.wikia.nocookie.net/breakingbad/images/2/27/Cast_bb_800x600_maria-schrader.jpg/revision/latest/scale-to-width-down/350?cb=20170613184047"));
        mContactList.add(new Contact("9", "Walter White Jr.", "(505) 948-3913", "https://vignette.wikia.nocookie.net/breakingbad/images/7/7e/Cast_bb_800x600_walter-white-jr.jpg/revision/latest/scale-to-width-down/350?cb=20170613184113"));
        mContactList.add(new Contact("10", "Kim Wexler", "(505) 884-9931", "https://vignette.wikia.nocookie.net/breakingbad/images/1/16/BCS_S3_KimWexler.jpg/revision/latest/scale-to-width-down/350?cb=20170327185119"));
        mContactList.add(new Contact("11", "Nacho Varga", "(505) 388-3993", "https://vignette.wikia.nocookie.net/breakingbad/images/c/ce/BCS_S3_Nacho.jpg/revision/latest/scale-to-width-down/350?cb=20170327185236"));
        mContactList.add(new Contact("12", "Howard Hamlin", "(505) 990-2252", "https://vignette.wikia.nocookie.net/breakingbad/images/9/92/BCS_S3_HowardHamlin.jpg/revision/latest/scale-to-width-down/350?cb=20170327185156"));
        mContactList.add(new Contact("13", "Chuck McGill", "(505) 884-1120", "https://vignette.wikia.nocookie.net/breakingbad/images/3/3e/BCS_S3_ChuckMcGill.jpg/revision/latest/scale-to-width-down/350?cb=20170327185308"));
        mContactList.add(new Contact("14", "Lydia Rodarte-Quayle", "(505) 393-0099", "https://vignette.wikia.nocookie.net/breakingbad/images/0/04/Cast_bb_800x600_lydia-rodarte-quayle.jpg/revision/latest/scale-to-width-down/350?cb=20170613184238"));
        mContactList.add(new Contact("15", "Victor", "(505) 334-0391", "https://vignette.wikia.nocookie.net/breakingbad/images/4/48/Victor2.png/revision/latest?cb=20131009225027"));
    }
}
