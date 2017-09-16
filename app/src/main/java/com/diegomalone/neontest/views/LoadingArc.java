package com.diegomalone.neontest.views;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;

/**
 * Created by Diego Malone on 16/09/17.
 */

public class LoadingArc {

    private final String TAG = getClass().getSimpleName();

    private float mStartAngle, mSweepAngle;
    private RectF mOval;
    private boolean mUseCenter = false;
    private Paint mPaint;

    public LoadingArc() {
        mPaint = new Paint();
        mPaint.setAntiAlias(true);
    }

    public void draw(Canvas canvas) {
        canvas.drawArc(mOval, mStartAngle, mSweepAngle, mUseCenter, mPaint);
    }

    public float getStartAngle() {
        return mStartAngle;
    }

    public void setStartAngle(float mmStartAngle) {
        this.mStartAngle = mmStartAngle;
    }

    public float getSweepAngle() {
        return mSweepAngle;
    }

    public void setSweepAngle(float mmSweepAngle) {
        this.mSweepAngle = mmSweepAngle;
    }

    public RectF getOval() {
        return mOval;
    }

    public void setOval(RectF mmOval) {
        this.mOval = mmOval;
    }

    public boolean isUseCenter() {
        return mUseCenter;
    }

    public void setUseCenter(boolean mmUseCenter) {
        this.mUseCenter = mmUseCenter;
    }

    public void setColor(int color) {
        mPaint.setColor(color);
    }

    public void setAlpha(int alpha) {
        mPaint.setAlpha(alpha);
    }

    public void setStrokeWidth(float width) {
        mPaint.setStrokeWidth(width);
    }

    public void setStyle(Paint.Style style) {
        mPaint.setStyle(style);
    }
}
