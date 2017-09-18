package com.diegomalone.neontest.views.graphical;

import android.graphics.Canvas;
import android.graphics.Paint;

/**
 * Created by Diego Malone on 17/09/17.
 */

public class Line {

    private final String TAG = getClass().getSimpleName();

    private Paint mPaint;

    private int startX, startY, endX, endY;

    public Line() {
        mPaint = new Paint();
        mPaint.setAntiAlias(true);
    }

    public void draw(Canvas canvas) {
        canvas.drawLine(startX, startY, endX, endY, mPaint);
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

    public int getStartX() {
        return startX;
    }

    public void setStartX(int startX) {
        this.startX = startX;
    }

    public int getStartY() {
        return startY;
    }

    public void setStartY(int startY) {
        this.startY = startY;
    }

    public int getEndX() {
        return endX;
    }

    public void setEndX(int endX) {
        this.endX = endX;
    }

    public int getEndY() {
        return endY;
    }

    public void setEndY(int endY) {
        this.endY = endY;
    }

    public Paint getPaint() {
        return mPaint;
    }

    public void setPaint(Paint mPaint) {
        this.mPaint = mPaint;
    }

    @Override
    public String toString() {
        return "Line{" +
                ", mPaint=" + mPaint +
                ", startX=" + startX +
                ", startY=" + startY +
                ", endX=" + endX +
                ", endY=" + endY +
                '}';
    }
}
