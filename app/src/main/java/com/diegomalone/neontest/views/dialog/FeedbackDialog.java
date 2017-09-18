package com.diegomalone.neontest.views.dialog;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.diegomalone.neontest.R;

import java.util.concurrent.TimeUnit;

import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;

/**
 * Created by Diego Malone on 17/09/17.
 */

public class FeedbackDialog extends Dialog {

    public final String TAG = getClass().getSimpleName();

    private final long DELAY_TO_DISMISS = 3000;

    private Context mContext;

    private View mCloseButton;
    private ImageView mInformationIcon;
    private TextView mInformationTextView;

    private Drawable mDrawable;
    private String mMessage;

    public FeedbackDialog(@NonNull Context context, Drawable drawable, String messageToShow) {
        super(context);

        mContext = context;
        mMessage = messageToShow;
        mDrawable = drawable;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialog_feedback);

        getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

        initializeViews();

        Observable.timer(DELAY_TO_DISMISS, TimeUnit.MILLISECONDS)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<Long>() {
                    @Override
                    public void call(Long aLong) {
                        FeedbackDialog.this.cancel();
                    }
                });
    }

    private void initializeViews() {
        mCloseButton = findViewById(R.id.close_button);
        mInformationTextView = findViewById(R.id.information_text);
        mInformationIcon = findViewById(R.id.information_icon);

        mCloseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FeedbackDialog.this.cancel();
            }
        });

        mInformationTextView.setText(mMessage);

        mInformationIcon.setImageDrawable(mDrawable);
    }
}
