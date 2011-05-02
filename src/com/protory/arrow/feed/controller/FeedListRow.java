package com.protory.arrow.feed.controller;

import android.content.Context;
import android.os.Handler;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.protory.arrow.feed.R;
import com.protory.arrow.feed.domain.Feed;
import com.protory.arrow.feed.utils.DateUtils;

public class FeedListRow extends RelativeLayout {
    private ImageView mReadIndicator;
    private ImageView mImage;
    private TextView mTitle;
    private TextView mDescription;
    private TextView mPubDate;

    private Handler mHandler = new Handler();

    public FeedListRow(Context context) {
        super(context);
    }

    public FeedListRow(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public FeedListRow(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();

        mReadIndicator = (ImageView) findViewById(R.id.read_indicator);
        mImage = (ImageView) findViewById(R.id.image);
        mTitle = (TextView) findViewById(R.id.title);
        mDescription = (TextView) findViewById(R.id.description);
        mPubDate = (TextView) findViewById(R.id.pub_date);
    }

    public void bind(Feed item) {
        mReadIndicator.setVisibility(VISIBLE);
        mTitle.setText(item.getTitle());
        mDescription.setText(item.getDescription());
        mPubDate.setText(DateUtils.format(item.getPubDate(), "MM/dd/yyyy"));
        // process image
        mHandler.post(new Runnable() {
            @Override
            public void run() {
                mImage.setImageResource(R.drawable.icon);
            }
        });
    }
}
