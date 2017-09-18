package com.diegomalone.neontest.views;

import android.content.Context;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.diegomalone.neontest.R;
import com.diegomalone.neontest.model.TotalTransfer;
import com.diegomalone.neontest.utils.MoneyUtils;
import com.diegomalone.neontest.views.element.PhotoView;

/**
 * Created by Diego Malone on 16/09/17.
 */

public class TotalTransferChartItemView extends LinearLayout {

    private final String TAG = getClass().getSimpleName();

    private final int MAXIMUM_CHART_LINE_HEIGHT = 70;

    private Context mContext;

    private View mChartLineView;
    private TextView mTransferredValueView;
    private PhotoView mContactProfileImageView;

    private TotalTransfer mTotalTransfer;

    public TotalTransferChartItemView(Context context) {
        super(context);
        initialize(context);
    }

    public TotalTransferChartItemView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initialize(context);
    }

    private void initialize(Context context) {
        mContext = context;

        inflate(mContext, R.layout.view_total_transfer_chart_item, this);

        mContactProfileImageView = findViewById(R.id.contact_profile_view);
        mTransferredValueView = findViewById(R.id.transferred_value_text_view);
        mChartLineView = findViewById(R.id.graph_line);
    }

    public void setTotalTransfer(TotalTransfer totalTransfer) {
        this.mTotalTransfer = totalTransfer;

        mTransferredValueView.setText(MoneyUtils.getMoneyWithoutMask(mContext, totalTransfer.getValue()));

        mContactProfileImageView.setContact(totalTransfer.getContact());

        LayoutParams params = (LinearLayout.LayoutParams) mChartLineView.getLayoutParams();
        params.height = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,
                totalTransfer.getChartLineHeight(MAXIMUM_CHART_LINE_HEIGHT),
                getResources().getDisplayMetrics());

        mChartLineView.setLayoutParams(params);
    }

}
