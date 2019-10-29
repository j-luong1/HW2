package com.example.hw2;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import android.widget.EditText;
import android.util.Log;
import android.content.Intent;

public class MainActivity extends AppCompatActivity {

    private static final String LOCAL_VALUE= "KEY_LOCAL";
    EditText mediText1;
    EditText mediText2;
    FloatingActionButton fab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.AppTheme_NoActionBar);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findAllViews();
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                submit1();
            }
        });

    }
/*
    @Override
    protected void onDestroy() {
       super.onDestroy();
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
    }
*/
    private void findAllViews() {
        mediText1 = (EditText) findViewById(R.id.editText);
        mediText2 = (EditText) findViewById(R.id.editText2);
        fab = (FloatingActionButton) findViewById(R.id.fab);
    }

    private void submit1() {
        try{
            Intent intent1 = new Intent(this, Secondary.class);
            intent1.putExtra("EXTRA_MESSAGE1",String.valueOf(mediText1.getText()));
            intent1.putExtra("EXTRA_MESSAGE2",String.valueOf(mediText2.getText()));
            startActivity(intent1);
        }catch (SecurityException error)
        {
            Log.e("MapleLeaf","Function Failed");
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            finish();
            System.exit(0);
        }

        return super.onOptionsItemSelected(item);
    }
}
