package com.protory.arrow.rss.controller;

import java.util.List;

import android.content.Context;
import android.widget.ArrayAdapter;

import com.protory.arrow.rss.domain.Feed;

public class FeedListAdapter extends ArrayAdapter<Feed> {

    public FeedListAdapter(Context context, List<Feed> items) {
        super(context, android.R.layout.simple_list_item_1, items);
    }
}
