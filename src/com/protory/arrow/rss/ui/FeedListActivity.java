package com.protory.arrow.rss.ui;

import android.app.ListActivity;
import android.os.Bundle;
import android.view.Menu;

import com.protory.arrow.rss.R;

public class FeedListActivity extends ListActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);

        getMenuInflater().inflate(R.menu.feed_list_option_menu, menu);

        return true;
    }
}
