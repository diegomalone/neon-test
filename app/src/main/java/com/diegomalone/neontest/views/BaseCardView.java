package com.diegomalone.neontest.views;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.CardView;
import android.util.AttributeSet;

/**
 * Created by Diego Malone on 15/09/17.
 */

public abstract class BaseCardView extends CardView {

    public BaseCardView(Context context) {
        super(context);
        setupBackground();
    }

    public BaseCardView(Context context, AttributeSet attrs) {
        super(context, attrs);
        setupBackground();
    }

    protected void setupBackground() {
        setCardBackgroundColor(Color.TRANSPARENT);
        setCardElevation(0);
    }
}
