package com.protory.arrow.feed.presentation;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.protory.arrow.feed.R;

public class NewFeedActivity extends Activity {
    private EditText mUrlEdit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.new_feed_activity);

        initResourceRefs();
    }

    private void initResourceRefs() {
        mUrlEdit = (EditText) findViewById(R.id.edit_uri);

        ((Button) findViewById(R.id.button_cancel)).setOnClickListener(new CancelListener());
        ((Button) findViewById(R.id.button_ok)).setOnClickListener(new OkListener());
    }

    class OkListener implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent();
            intent.putExtra("uri", mUrlEdit.getText().toString());
            setResult(RESULT_OK, intent);
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
