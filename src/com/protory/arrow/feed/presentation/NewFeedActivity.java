package com.protory.arrow.feed.presentation;

import android.app.Activity;
import android.content.Intent;
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

    class OkListener implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            setResult(RESULT_OK, new Intent());
            finish();
        }
    }

    class CancelListener implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            finish();
        }
    }
}
