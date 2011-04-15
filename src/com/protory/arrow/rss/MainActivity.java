package com.protory.arrow.rss;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import com.protory.arrow.rss.ui.FeedListActivity;

public class MainActivity extends Activity {
    int[] ic = new int[]{android.R.drawable.ic_menu_add, android.R.drawable.ic_menu_save};


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