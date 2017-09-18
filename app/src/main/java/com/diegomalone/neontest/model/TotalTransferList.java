package com.diegomalone.neontest.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Diego Malone on 16/09/17.
 */

public class TotalTransferList {

    private final String TAG = getClass().getSimpleName();

    private List<TotalTransfer> totalTransferList = new ArrayList<>();

    private double highestValue;

    public List<TotalTransfer> getTotalTransferList() {
        return totalTransferList;
    }

    public void setTotalTransferList(List<TotalTransfer> totalTransferList) {
        this.totalTransferList = totalTransferList;
        configureValues();
    }

    public void add(TotalTransfer totalTransfer) {
        totalTransferList.add(totalTransfer);
        configureValues();
    }

    public int size() {
        return totalTransferList.size();
    }

    public TotalTransfer get(int i) {
        return totalTransferList.get(i);
    }

    public TotalTransfer get(Contact contact) {
        if (contact == null) return null;

        for (TotalTransfer totalTransfer : totalTransferList) {
            if (contact.equals(totalTransfer.getContact())) {
                return totalTransfer;
            }
        }

        return null;
    }

    public boolean has(Contact contact) {
        return get(contact) != null;
    }

    public void configureValues() {
        Collections.sort(totalTransferList);

        highestValue = get(0).getValue();

        for (TotalTransfer totalTransfer : totalTransferList) {
            totalTransfer.setChartHeight(calculateHeight(totalTransfer.getValue()));
        }
    }

    private int calculateHeight(double value) {
        return (int) ((value / highestValue) * 100f);
    }

    public double getHighestValue() {
        return highestValue;
    }

    public void setHighestValue(double highestValue) {
        this.highestValue = highestValue;
    }

    @Override
    public String toString() {
        return "TotalTransferList{" +
                ", totalTransferList=" + totalTransferList +
                ", highestValue=" + highestValue +
                '}';
    }
}
