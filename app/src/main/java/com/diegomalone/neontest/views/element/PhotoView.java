package com.diegomalone.neontest.views.element;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Shader;
import android.graphics.SweepGradient;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.diegomalone.neontest.R;
import com.diegomalone.neontest.model.Contact;

import org.apache.commons.lang3.StringUtils;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by Diego Malone on 18/09/17.
 */

public class PhotoView extends RelativeLayout {

    private final String TAG = getClass().getSimpleName();

    protected Context mContext;

    private CircleImageView mPhotoView;
    private TextView mPhotoInitialsTextView;

    private boolean mGradientCircle = false;
    private Paint mCirclePaint;
    private int mOneDipInPixels, mStrokeSizeInDips;

    public PhotoView(Context context) {
        super(context);
        initialize(context);
    }

    public PhotoView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initialize(context);
    }

    public PhotoView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initialize(context);
    }

    private void initialize(Context context) {
        mContext = context;

        inflate(mContext, R.layout.view_photo, this);

        mPhotoView = findViewById(R.id.photo_image_view);
        mPhotoInitialsTextView = findViewById(R.id.photo_initials);

        mOneDipInPixels = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 1, getResources().getDisplayMetrics());

        mCirclePaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mCirclePaint.setStyle(Paint.Style.STROKE);

        mStrokeSizeInDips = 1;
        setLineStroke(mStrokeSizeInDips);

        setWillNotDraw(false);
    }

    private void setupTextSize() {
        if (getWidth() < (40 * mOneDipInPixels)) {
            mPhotoInitialsTextView.setTextSize(TypedValue.COMPLEX_UNIT_PX,
                    getResources().getDimension(R.dimen.text_default));
        } else {
            mPhotoInitialsTextView.setTextSize(TypedValue.COMPLEX_UNIT_PX,
                    getResources().getDimension(R.dimen.text_big));
        }
    }

    public void setContact(Contact contact) {
        String photoUrl = contact.getPhotoUrl();

        if (StringUtils.isNotBlank(photoUrl)) {
            Glide.with(this)
                    .load(photoUrl)
                    .into(mPhotoView);

            mPhotoInitialsTextView.setVisibility(GONE);
            mPhotoView.setVisibility(VISIBLE);
        } else {
            mPhotoInitialsTextView.setText(contact.getInitials());

            mPhotoInitialsTextView.setVisibility(VISIBLE);
            mPhotoView.setVisibility(GONE);
        }

        setupTextSize();
    }

    public void setDrawable(Drawable drawable) {
        mPhotoView.setImageDrawable(drawable);

        mPhotoInitialsTextView.setVisibility(GONE);
        mPhotoView.setVisibility(VISIBLE);
    }

    public boolean isGradientCircle() {
        return mGradientCircle;
    }

    public void setGradientCircle(boolean gradientCircle) {
        this.mGradientCircle = gradientCircle;
    }

    public void setLineStroke(int sizeInDips) {
        mStrokeSizeInDips = sizeInDips;
        mCirclePaint.setStrokeWidth(mOneDipInPixels * sizeInDips);

        int paddingSize = mOneDipInPixels * sizeInDips;
        mPhotoView.setBorderWidth(paddingSize);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        if (mGradientCircle) {
            canvas.save();
            canvas.rotate(-90, getWidth() / 2, getHeight() / 2);
            drawCircle(canvas);
            canvas.restore();
        } else {
            drawCircle(canvas);
        }

        setupTextSize();
    }

    private void drawCircle(Canvas canvas) {
        int centerX = getWidth() / 2;
        int centerY = getHeight() / 2;
        int radius = (getWidth() / 2) - (mOneDipInPixels * mStrokeSizeInDips) / 2;

        if (mGradientCircle) {
            int startColor = ContextCompat.getColor(mContext, R.color.colorAccent);
            int endColor = ContextCompat.getColor(mContext, R.color.colorPrimaryDark);
            Shader shader = new SweepGradient(radius, radius, startColor, endColor);
            mCirclePaint.setShader(shader);
        } else {
            mCirclePaint.setColor(ContextCompat.getColor(mContext, R.color.colorAccent));
        }

        canvas.drawCircle(centerX, centerY, radius, mCirclePaint);
    }

    public void setColor(int color) {
        mPhotoInitialsTextView.setTextColor(color);

        invalidate();
    }
}
