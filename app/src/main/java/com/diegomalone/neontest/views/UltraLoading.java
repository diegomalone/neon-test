package com.diegomalone.neontest.views;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PointF;
import android.graphics.RectF;
import android.support.v4.content.ContextCompat;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.LinearInterpolator;

import com.diegomalone.neontest.R;

/**
 * Created by Diego Malone on 16/09/17.
 */

public class UltraLoading extends View {

    private final String TAG = getClass().getSimpleName();

    protected Context mContext;

    private int mWidth, mHeight;
    private int mDefaultWidth, mDefaultHeight;
    private PointF mCenter;

    private LoadingArc[] mArcs;
    private int mNumberOfArcs;
    private float[] mArcRotation;

    public UltraLoading(Context context) {
        super(context);
        initialize(context);
    }

    public UltraLoading(Context context, AttributeSet attrs) {
        super(context, attrs);
        initialize(context);
    }

    public UltraLoading(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initialize(context);
    }

    private void initialize(Context context) {
        mContext = context;

        mDefaultWidth = 150;
        mDefaultHeight = 150;
        mNumberOfArcs = 3;
    }

    public void setSize(int width, int height) {
        mWidth = width;
        mHeight = height;
        mCenter = new PointF(width / 2f, height / 2f);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        final int measuredWidth = resolveSize(mDefaultWidth, widthMeasureSpec);
        final int measuredHeight = resolveSize(mDefaultHeight, heightMeasureSpec);

        setMeasuredDimension(measuredWidth, measuredHeight);
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
        setSize(getWidth(), getHeight());
        initializeObjects();
        setUpAnimation();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        for (int i = 0; i < mNumberOfArcs; i++) {
            canvas.save();
            canvas.rotate(mArcRotation[i], mCenter.x, mCenter.y);
            mArcs[i].draw(canvas);
            canvas.restore();
        }
    }

    public void reDraw() {
        invalidate();
    }

    private void initializeObjects() {
        float radius = Math.min(mWidth, mHeight) / 2f;
        mArcs = new LoadingArc[mNumberOfArcs];
        mArcRotation = new float[mNumberOfArcs];

        for (int i = 0; i < mNumberOfArcs; i++) {
            float distance = radius / 4 + i * radius / 4;

            RectF rectF = new RectF(mCenter.x - distance, mCenter.y - distance, mCenter.x + distance, mCenter.y + distance);

            LoadingArc loadingArc = new LoadingArc();
            loadingArc.setStartAngle(i * 45);
            loadingArc.setSweepAngle(i * 45 + 90);
            loadingArc.setOval(rectF);
            loadingArc.setStyle(Paint.Style.STROKE);
            loadingArc.setColor(ContextCompat.getColor(mContext, R.color.loading_color));
            loadingArc.setStrokeWidth(radius / 10f);

            mArcs[i] = loadingArc;
        }
    }

    private void setUpAnimation() {
        for (int i = 0; i < mNumberOfArcs; i++) {
            final int index = i;
            int direction = (i % 2 == 0 ? -1 : 1);
            int duration = (i + 1) * 500;

            ValueAnimator valueAnimator = ValueAnimator.ofFloat(mArcs[i].getStartAngle(),
                    mArcs[i].getStartAngle() + 360 * direction);
            valueAnimator.setRepeatCount(ValueAnimator.INFINITE);
            valueAnimator.setDuration(duration);
            valueAnimator.setInterpolator(new LinearInterpolator());
            valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                @Override
                public void onAnimationUpdate(ValueAnimator animation) {
                    mArcRotation[index] = (float) animation.getAnimatedValue();
                    reDraw();
                }
            });

            valueAnimator.start();
        }
    }
}
