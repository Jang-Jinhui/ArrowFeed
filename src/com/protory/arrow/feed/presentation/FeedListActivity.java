package com.protory.arrow.feed.presentation;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.google.code.microlog4android.Logger;
import com.google.code.microlog4android.LoggerFactory;
import com.j256.ormlite.android.apptools.OrmLiteBaseListActivity;
import com.protory.arrow.feed.controller.FeedListAdapter;
import com.protory.arrow.feed.persistence.DatabaseHelper;
import com.protory.arrow.rss.R;

public class FeedListActivity extends OrmLiteBaseListActivity<DatabaseHelper> {
    private static final Logger LOG = LoggerFactory.getLogger(FeedListActivity.class);

    private FeedListAdapter mListAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initialize();
    }

    private void initialize() {
        mListAdapter = new FeedListAdapter(this, getHelper());
        setListAdapter(mListAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);

        getMenuInflater().inflate(R.menu.feed_list_option_menu, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
        case R.id.menu_new_feed:
            startActivity(new Intent(this, NewFeedActivity.class));
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        LOG.debug("requestCode: " + requestCode);
        LOG.debug("resultCode: " + resultCode);

        super.onActivityResult(requestCode, resultCode, data);
    }
}
