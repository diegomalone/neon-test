package com.diegomalone.neontest.views;

import android.content.Context;
import android.graphics.Canvas;
import android.support.graphics.drawable.ArgbEvaluator;
import android.support.v4.content.ContextCompat;
import android.util.AttributeSet;
import android.widget.LinearLayout;

import com.diegomalone.neontest.R;
import com.diegomalone.neontest.views.graphical.Line;

/**
 * Created by Diego Malone on 17/09/17.
 */

public class ChartBackground extends LinearLayout {

    private final String TAG = getClass().getSimpleName();

    private final int TOTAL_LINES = 10;
    private final int BACKGROUND_OFFSET = 112;

    private Context mContext;

    private Line[] mLines;

    public ChartBackground(Context context) {
        super(context);
        initialize(context);
    }

    public ChartBackground(Context context, AttributeSet attrs) {
        super(context, attrs);
        initialize(context);
    }

    private void initialize(Context context) {
        mContext = context;
        setWillNotDraw(false);
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
        initializeObjects();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        for (Line line : mLines) {
            canvas.drawLine(line.getStartX(), line.getStartY(), line.getEndX(),
                    line.getEndY(), line.getPaint());
        }
    }

    private void initializeObjects() {

        mLines = new Line[TOTAL_LINES];

        int step = (getHeight() - BACKGROUND_OFFSET) / TOTAL_LINES;

        for (int i = 0; i < TOTAL_LINES; i++) {
            int positionY = (i + 1) * step;

            Line line = new Line();
            line.setStartX(0);
            line.setStartY(positionY);
            line.setEndX(getWidth());
            line.setEndY(positionY);
            line.setColor(getColor(i));
            line.setStrokeWidth(1f);

            mLines[i] = line;
        }
    }

    private int getColor(int i) {
        float step = 1f / TOTAL_LINES;

        return (Integer) ArgbEvaluator.getInstance().evaluate(step * i,
                ContextCompat.getColor(mContext, R.color.backgroundLight),
                ContextCompat.getColor(mContext, R.color.colorChartBottom));
    }
}
