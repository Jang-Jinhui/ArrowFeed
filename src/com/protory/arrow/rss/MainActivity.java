package com.protory.arrow.rss;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import com.protory.arrow.rss.ui.FeedListActivity;

public class MainActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        startHome();
    }

    private void startHome() {
        startActivity(new Intent(this, FeedListActivity.class));
        finish();
    }
}