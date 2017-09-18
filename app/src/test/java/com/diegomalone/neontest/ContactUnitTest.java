package com.diegomalone.neontest;

import com.diegomalone.neontest.model.Contact;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;

/**
 * Created by Diego Malone on 18/09/17.
 */

public class ContactUnitTest {

    private Contact testContact;

    @Before
    public void setupContact() {
        testContact = new Contact(0, "", "", "");
    }

    @Test
    public void testContactInitials() throws Exception {
        testContact.setName("Test Contact");
        assertEquals("TC", testContact.getInitials());

        testContact.setName("Test C");
        assertEquals("TC", testContact.getInitials());

        testContact.setName("Test Contact ");
        assertEquals("TC", testContact.getInitials());

        testContact.setName("Test Contact Contact");
        assertEquals("TC", testContact.getInitials());

        testContact.setName("Test");
        assertEquals("T", testContact.getInitials());

        testContact.setName("T");
        assertEquals("T", testContact.getInitials());

        testContact.setName("");
        assertEquals("", testContact.getInitials());

        testContact.setName("test");
        assertEquals("T", testContact.getInitials());

        testContact.setName("érick");
        assertEquals("É", testContact.getInitials());

        testContact.setName("Érick");
        assertEquals("É", testContact.getInitials());
    }

    @Test
    public void testTransferredValue() {
        assertEquals(false, testContact.hasTransferredValue());
        assertEquals(0d, testContact.getTransferredValue());

        testContact.setTransferredValue(0d);

        assertEquals(false, testContact.hasTransferredValue());
        assertEquals(0d, testContact.getTransferredValue());

        testContact.setTransferredValue(1d);

        assertEquals(true, testContact.hasTransferredValue());
        assertEquals(1d, testContact.getTransferredValue());

        testContact.addTransferredValue(1d);

        assertEquals(true, testContact.hasTransferredValue());
        assertEquals(2d, testContact.getTransferredValue());

        testContact.addTransferredValue(0d);

        assertEquals(true, testContact.hasTransferredValue());
        assertEquals(2d, testContact.getTransferredValue());

        testContact.setTransferredValue(0d);

        assertEquals(false, testContact.hasTransferredValue());
        assertEquals(0d, testContact.getTransferredValue());

        testContact.addTransferredValue(1d);

        assertEquals(true, testContact.hasTransferredValue());
        assertEquals(1d, testContact.getTransferredValue());
    }
}
