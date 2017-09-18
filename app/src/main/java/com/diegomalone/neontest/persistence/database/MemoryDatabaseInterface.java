package com.diegomalone.neontest.persistence.database;

import com.diegomalone.neontest.model.Contact;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Diego Malone on 16/09/17.
 */

public class MemoryDatabaseInterface implements DatabaseInterface {

    private List<Contact> mContactList = new ArrayList<>();

    public MemoryDatabaseInterface() {
        mContactList = setupContactList();
    }

    @Override
    public List<Contact> getContactList() {
        return mContactList;
    }

    @Override
    public Contact getContact(int id) {

        for (Contact contact : mContactList) {
            if (contact.getId() == id) {
                return contact;
            }
        }

        return null;
    }

    private List<Contact> setupContactList() {
        List<Contact> contactList = new ArrayList<>();

        contactList.add(new Contact(1, "Walter White", "(505) 737-0000", "https://vignette.wikia.nocookie.net/breakingbad/images/4/46/Cast_bb_800x600_walter-white.jpg/revision/latest/scale-to-width-down/700?cb=20170613183854"));
        contactList.add(new Contact(2, "Jesse Pinkman", "(505) 947-1593", "https://vignette.wikia.nocookie.net/breakingbad/images/d/d3/Cast_bb_800x600_jesse-pinkman.jpg/revision/latest/scale-to-width-down/700?cb=20170613183955"));
        contactList.add(new Contact(3, "Hank Shrader", "(505) 946-2312", "https://vignette.wikia.nocookie.net/breakingbad/images/f/f7/Cast_bb_800x600_hank-schrader.jpg/revision/latest/scale-to-width-down/700?cb=20170613184022"));
        contactList.add(new Contact(4, "Skyler White", "(505) 587-3914", "https://vignette.wikia.nocookie.net/breakingbad/images/b/bd/Cast_bb_800x600_skyler-white.jpg/revision/latest/scale-to-width-down/350?cb=20170613183930"));
        contactList.add(new Contact(5, "Jimmy McGill (Saul Goodman)", "(505) 842-5325", null));
        contactList.add(new Contact(6, "Mike Ehrmantraut", "(505) 481-1349", "https://vignette.wikia.nocookie.net/breakingbad/images/8/8d/BCS_S3_MikeEhrmantraut.jpg/revision/latest/scale-to-width-down/350?cb=20170327185046"));
        contactList.add(new Contact(7, "Gustavo Fring", "(505) 239-3949", "https://vignette.wikia.nocookie.net/breakingbad/images/a/ab/BCS_S3_GusFringe.jpg/revision/latest/scale-to-width-down/350?cb=20170327185354"));
        contactList.add(new Contact(8, "Marie Schrader", "(505) 398-5993", "https://vignette.wikia.nocookie.net/breakingbad/images/2/27/Cast_bb_800x600_maria-schrader.jpg/revision/latest/scale-to-width-down/350?cb=20170613184047"));
        contactList.add(new Contact(9, "Walter White Jr.", "(505) 948-3913", "https://vignette.wikia.nocookie.net/breakingbad/images/7/7e/Cast_bb_800x600_walter-white-jr.jpg/revision/latest/scale-to-width-down/350?cb=20170613184113"));
        contactList.add(new Contact(10, "Kim Wexler", "(505) 884-9931", "https://vignette.wikia.nocookie.net/breakingbad/images/1/16/BCS_S3_KimWexler.jpg/revision/latest/scale-to-width-down/350?cb=20170327185119"));
        contactList.add(new Contact(11, "Nacho Varga", "(505) 388-3993", "https://vignette.wikia.nocookie.net/breakingbad/images/c/ce/BCS_S3_Nacho.jpg/revision/latest/scale-to-width-down/350?cb=20170327185236"));
        contactList.add(new Contact(12, "Howard Hamlin", "(505) 990-2252", "https://vignette.wikia.nocookie.net/breakingbad/images/9/92/BCS_S3_HowardHamlin.jpg/revision/latest/scale-to-width-down/350?cb=20170327185156"));
        contactList.add(new Contact(13, "Chuck McGill", "(505) 884-1120", null));
        contactList.add(new Contact(14, "Lydia Rodarte-Quayle", "(505) 393-0099", "https://vignette.wikia.nocookie.net/breakingbad/images/0/04/Cast_bb_800x600_lydia-rodarte-quayle.jpg/revision/latest/scale-to-width-down/350?cb=20170613184238"));
        contactList.add(new Contact(15, "Victor", "(505) 334-0391", "https://vignette.wikia.nocookie.net/breakingbad/images/4/48/Victor2.png/revision/latest?cb=20131009225027"));

        return contactList;
    }
}
