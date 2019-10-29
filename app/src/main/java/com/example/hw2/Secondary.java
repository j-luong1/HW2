package com.example.hw2;

import android.app.ActionBar;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;


public class Secondary extends AppCompatActivity {

    private TextView mTextMessage;
    private TextView mTextMessage2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.AppTheme_NoActionBar);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_secondary);

        Toolbar mToolbar = findViewById(R.id.toolbar3);
            mToolbar.setNavigationIcon(R.drawable.ic_arrow_back_white_24dp);
            mToolbar.setTitle(getString(R.string.receiver));

        mTextMessage = (TextView) findViewById(R.id.message1);
        mTextMessage2 = (TextView) findViewById(R.id.message2);

        processData();

        Button button = findViewById(R.id.button3);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onReturnPressed();
            }
        });

        mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onReturnPressed();
            }
        });
    }

    public void processData() {
        Bundle extras = getIntent().getExtras();
        if (extras == null) { return; }
        String value1 = extras.getString("EXTRA_MESSAGE1");
        String value2 = extras.getString("EXTRA_MESSAGE2");
        if (value1 != null) {
            TextView mTextMessage = (TextView) findViewById(R.id.message1);
            mTextMessage.setText(value1);
        }
        if (value2 != null) {
            TextView mTextMessage2 = (TextView) findViewById(R.id.message2);
            mTextMessage2.setText(value2);
        }
    }

    public void onReturnPressed() {
        finish();
    }
}
