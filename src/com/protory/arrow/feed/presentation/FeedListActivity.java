package com.protory.arrow.feed.presentation;

import java.util.Date;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.code.microlog4android.Logger;
import com.google.code.microlog4android.LoggerFactory;
import com.j256.ormlite.android.apptools.OrmLiteBaseListActivity;
import com.protory.arrow.feed.R;
import com.protory.arrow.feed.controller.FeedListAdapter;
import com.protory.arrow.feed.domain.Feed;
import com.protory.arrow.feed.parser.DefaultFeedParserListener;
import com.protory.arrow.feed.parser.FeedParser;
import com.protory.arrow.feed.parser.FeedParserFactory;
import com.protory.arrow.feed.persistence.DatabaseHelper;

public class FeedListActivity extends OrmLiteBaseListActivity<DatabaseHelper> {
    public static final int REQUEST_CODE_NEW_FEED = 11;

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
            startActivityForResult(new Intent(this, NewFeedActivity.class), REQUEST_CODE_NEW_FEED);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode != RESULT_OK) {
            if (LOG.isDebugEnabled()) {
                LOG.debug("resultCode: " + resultCode);
            }
            return;
        }

        switch (requestCode) {
        case REQUEST_CODE_NEW_FEED:
            String uri = data.getStringExtra("uri");
            if (LOG.isDebugEnabled()) {
                LOG.debug("data url: " + uri);
            }

            try {
                FeedParser parser = FeedParserFactory.newFeedParserFactory().newFeedParser();
                FeedParserListenerImpl listener = new FeedParserListenerImpl();
                parser.parse(listener, uri);

                mListAdapter.add(listener.feed);
            } catch (Exception e) {
                Toast.makeText(this, "Not add feed", Toast.LENGTH_SHORT);
                throw new RuntimeException(e);
            }
            break;

        default:
            break;
        }

        super.onActivityResult(requestCode, resultCode, data);
    }

    class FeedParserListenerImpl extends DefaultFeedParserListener {
        Feed feed;
        @Override
        public void onChannel(String title, String link, String description, Date pubDate) {
            feed = new Feed();
            feed.setTitle(title);
            feed.setLink(link);
            feed.setDescription(description);
            feed.setPubDate(pubDate);
        }
    }
}
