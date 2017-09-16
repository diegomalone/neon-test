package com.diegomalone.neontest.utils;

import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

import com.diegomalone.neontest.R;

import org.apache.commons.lang3.StringUtils;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;

/**
 * Created by Diego Malone on 15/09/17.
 */

public class MoneyUtils {

    private static final String TAG = MoneyUtils.class.getSimpleName();

    public static String getMoneyString(Context context, double value) {
        DecimalFormatSymbols otherSymbols = new DecimalFormatSymbols();
        otherSymbols.setDecimalSeparator(',');
        otherSymbols.setGroupingSeparator('.');

        DecimalFormat formatter = new DecimalFormat("0.00", otherSymbols);

        return context.getString(R.string.money_mask, formatter.format(value));
    }

    public static Double getDoubleValue(String valueAsString) {
        if (StringUtils.isBlank(valueAsString)) return 0d;

        String cleanedValue = StringUtils.replacePattern(valueAsString, "[^0-9]", "");

        if (StringUtils.isBlank(cleanedValue)) return 0d;

        BigDecimal bigDecimal = new BigDecimal(cleanedValue).setScale(2, BigDecimal.ROUND_FLOOR)
                .divide(new BigDecimal(100), BigDecimal.ROUND_FLOOR);

        return bigDecimal.doubleValue();
    }

    public static TextWatcher getMoneyTextWatcher(final Context context, final EditText editText) {
        return new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                editText.removeTextChangedListener(this);

                double doubleValue = getDoubleValue(editable.toString());
                String formattedValue = getMoneyString(context, doubleValue);

                editText.setText(formattedValue);
                editText.setSelection(formattedValue.length());
                editText.addTextChangedListener(this);
            }

        };
    }
}
