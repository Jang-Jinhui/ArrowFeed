package com.protory.arrow.rss.ui;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.protory.arrow.rss.R;

public class NewFeedActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.new_feed_activity);

        ((Button) findViewById(R.id.cancel)).setOnClickListener(new CancelListener());
    }

    class CancelListener implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            finish();
        }
    }
}
