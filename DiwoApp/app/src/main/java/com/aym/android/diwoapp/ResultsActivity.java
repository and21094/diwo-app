package com.aym.android.diwoapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ResultsActivity extends AppCompatActivity implements View.OnClickListener {

    public int right = 0;
    public int wrong = 0;

    public TextView goodAnswers;
    public TextView badAnswers;

    public Button exit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        goodAnswers = (TextView) findViewById(R.id.goodAnswers);
        badAnswers = (TextView) findViewById(R.id.wrongAnswers);

        exit = (Button) findViewById(R.id.goToMenu);
        exit.setOnClickListener(this);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            right = extras.getInt("totalRight");
            wrong = extras.getInt("totalWrong");
        }

        goodAnswers.setText(goodAnswers.getText().toString()+" "+right);
        badAnswers.setText(badAnswers.getText().toString()+" "+wrong);


    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK && event.getRepeatCount() == 0) {

            Intent intent = new Intent(ResultsActivity.this, MainActivity.class);
            startActivity(intent);

            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.goToMenu) {
            Intent intent = new Intent(ResultsActivity.this, MainActivity.class);
            startActivity(intent);
        }
    }
}
