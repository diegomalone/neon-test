package com.diegomalone.neontest.model;

import org.apache.commons.lang3.StringUtils;

/**
 * Created by Diego Malone on 15/09/17.
 */

public class Contact {

    private int id;
    private String name, phone, photoUrl;
    private double transferredValue = 0d;

    public Contact(int id, String name, String phone, String photoUrl) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.photoUrl = photoUrl;
    }

    public boolean equals(Object otherContact) {
        return otherContact instanceof Contact && ((Contact) otherContact).getId() == getId();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPhotoUrl() {
        return photoUrl;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }

    public boolean hasPhotoUrl() {
        return StringUtils.isNotBlank(getPhotoUrl());
    }

    public double getTransferredValue() {
        return transferredValue;
    }

    public void setTransferredValue(double transferredValue) {
        this.transferredValue = transferredValue;
    }

    public void addTransferredValue(double transferredValue) {
        this.transferredValue += transferredValue;
    }

    public boolean hasTransferredValue() {
        return getTransferredValue() != 0d;
    }

    public String getInitials() {
        if (StringUtils.isBlank(getName())) return "";

        String[] names = StringUtils.split(getName(), " ");

        String initials = "";
        if (names.length > 0) {
            initials += StringUtils.substring(names[0], 0, 1);
        }

        if (names.length > 1) {
            initials += StringUtils.substring(names[1], 0, 1);
        }

        return StringUtils.capitalize(initials);
    }

    @Override
    public String toString() {
        return "Contact{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", photoUrl='" + photoUrl + '\'' +
                ", transferredValue=" + transferredValue +
                '}';
    }
}
