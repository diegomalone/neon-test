package com.diegomalone.neontest.views.element;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.v4.content.ContextCompat;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.diegomalone.neontest.R;
import com.diegomalone.neontest.model.Contact;

import org.apache.commons.lang3.StringUtils;

/**
 * Created by Diego Malone on 18/09/17.
 */

public class PhotoView extends RelativeLayout {

    private final String TAG = getClass().getSimpleName();

    protected Context mContext;

    private ImageView mPhotoView;
    private TextView mPhotoInitialsTextView;

    private boolean mGradientCircle = false;
    private Paint mCirclePaint;
    private int mOneDipInPixels;

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
        mCirclePaint.setStrokeWidth(mOneDipInPixels);

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

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        int centerX = getWidth() / 2;
        int centerY = getHeight() / 2;
        int radius = (getWidth() / 2) - mOneDipInPixels;

        mCirclePaint.setColor(ContextCompat.getColor(mContext, R.color.colorAccent));
        canvas.drawCircle(centerX, centerY, radius, mCirclePaint);

        setupTextSize();
    }

    public void setColor(int color) {
        mPhotoInitialsTextView.setTextColor(color);

        invalidate();
    }
}
