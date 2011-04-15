package com.protory.arrow.rss;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import com.protory.arrow.rss.ui.FeedListActivity;

public class MainActivity extends Activity {
    static {
        try {
            Class.forName("com.protory.arrow.rss.persistence.DatabaseHelper");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

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