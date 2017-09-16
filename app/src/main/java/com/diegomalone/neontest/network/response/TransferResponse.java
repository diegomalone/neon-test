package com.diegomalone.neontest.network.response;

import com.diegomalone.neontest.model.Transfer;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Diego Malone on 15/09/17.
 */

public class TransferResponse extends BaseApiResponse<Transfer> {

    @SerializedName("Id")
    private int id;

    @SerializedName("ClienteId")
    private int contactId;

    @SerializedName("Valor")
    private double value;

    @SerializedName("Token")
    private String token;

    public TransferResponse(int id, int contactId, double value, String token) {
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

    public Transfer toModel() {
        return new Transfer(getId(), getContactId(), getValue(), getToken());
    }

    @Override
    public String toString() {
        return "TransferResponse{" +
                "id=" + id +
                ", contactId=" + contactId +
                ", value=" + value +
                ", token='" + token + '\'' +
                '}';
    }
}
