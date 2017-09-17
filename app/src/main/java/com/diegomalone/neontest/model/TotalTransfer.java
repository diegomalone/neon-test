package com.diegomalone.neontest.model;

import android.support.annotation.NonNull;

/**
 * Created by Diego Malone on 16/09/17.
 */

public class TotalTransfer implements Comparable<TotalTransfer> {

    private final String TAG = getClass().getSimpleName();

    private final int MINIMUM_CHART_LINE_HEIGHT = 5;

    private Contact contact;
    private double value;
    private int chartHeight;

    public TotalTransfer(Contact contact, double value) {
        this.contact = contact;
        this.value = value;
        this.chartHeight = 0;
    }

    public Contact getContact() {
        return contact;
    }

    public void setContact(Contact contact) {
        this.contact = contact;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public void addValue(double value) {
        this.value += value;
    }

    public int getChartHeight() {
        if (chartHeight < MINIMUM_CHART_LINE_HEIGHT) {
            return MINIMUM_CHART_LINE_HEIGHT;
        }

        return chartHeight;
    }

    public void setChartHeight(int chartHeight) {
        this.chartHeight = chartHeight;
    }

    @Override
    public String toString() {
        return "TotalTransfer{" +
                "contact=" + contact +
                ", value=" + value +
                ", chartHeight=" + chartHeight +
                '}';
    }

    @Override
    public int compareTo(@NonNull TotalTransfer totalTransfer) {
        return (int) (totalTransfer.getValue() - this.getValue());
    }
}
