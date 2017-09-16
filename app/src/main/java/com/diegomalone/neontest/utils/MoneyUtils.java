package com.diegomalone.neontest.utils;

import android.content.Context;

import com.diegomalone.neontest.R;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;

/**
 * Created by Diego Malone on 15/09/17.
 */

public class MoneyUtils {

    private final String TAG = getClass().getSimpleName();

    public static String getMoneyString(Context context, double value) {
        DecimalFormatSymbols otherSymbols = new DecimalFormatSymbols();
        otherSymbols.setDecimalSeparator(',');
        otherSymbols.setGroupingSeparator('.');

        DecimalFormat formatter = new DecimalFormat("#.00", otherSymbols);

        return context.getString(R.string.money_mask, formatter.format(value));
    }
}
