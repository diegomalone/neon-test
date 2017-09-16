package com.diegomalone.neontest.model;

/**
 * Created by Diego Malone on 16/09/17.
 */

public class Transfer {

    private int id, contactId;
    private double value;
    private String token;
    private Contact contact;

    public Transfer(int id, int contactId, double value, String token) {
        this.id = id;
        this.contactId = contactId;
        this.value = value;
        this.token = token;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getContactId() {
        return contactId;
    }

    public void setContactId(int contactId) {
        this.contactId = contactId;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Contact getContact() {
        return contact;
    }

    public void setContact(Contact contact) {
        this.contact = contact;
    }

    public boolean hasContact() {
        return getContact() != null;
    }

    @Override
    public String toString() {
        return "Transfer{" +
                "id=" + id +
                ", contactId=" + contactId +
                ", value=" + value +
                ", token='" + token + '\'' +
                ", contact=" + contact +
                '}';
    }
}
