package com.diegomalone.neontest.persistence.database;

import com.diegomalone.neontest.model.Contact;

import java.util.List;

/**
 * Created by Diego Malone on 16/09/17.
 */

public interface DatabaseInterface {

    List<Contact> getContactList();

    Contact getContact(int id);
}
