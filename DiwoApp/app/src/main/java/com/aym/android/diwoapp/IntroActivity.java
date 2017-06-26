package com.aym.android.diwoapp;

import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.aym.android.diwoapp.Model.ImageQuestion;

import java.util.LinkedList;

public class IntroActivity extends AppCompatActivity {

    public LinkedList<ImageQuestion> questionsOne = new LinkedList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        createQuestions();

//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
    }

    public void createQuestions(){
        String title = "¿Cuál de estas es \"mujer\"?";

    }

}
