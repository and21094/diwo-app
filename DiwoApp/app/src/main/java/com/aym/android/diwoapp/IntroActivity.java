package com.aym.android.diwoapp;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.aym.android.diwoapp.Model.ImageOption;
import com.aym.android.diwoapp.Model.ImageQuestion;

import java.util.LinkedList;

public class IntroActivity extends AppCompatActivity implements View.OnClickListener {

    public LinkedList<ImageQuestion> questionsOne = new LinkedList<>();
    public TextView questionTitle;
    public ImageView imageOption1;
    public ImageView imageOption2;
    public ImageView imageOption3;
    public ImageView imageOption4;

    public Button button1;
    public Button button2;
    public Button button3;
    public Button button4;

    public int actualQuestion = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        questionTitle = (TextView) findViewById(R.id.question);

        imageOption1 = (ImageView) findViewById(R.id.imageOption1);
        imageOption2 = (ImageView) findViewById(R.id.imageOption2);
        imageOption3 = (ImageView) findViewById(R.id.imageOption3);
        imageOption4 = (ImageView) findViewById(R.id.imageOption4);

        button1 = (Button) findViewById(R.id.option1);
        button1.setOnClickListener(this);
        button2 = (Button) findViewById(R.id.option2);
        button2.setOnClickListener(this);
        button3 = (Button) findViewById(R.id.option3);
        button3.setOnClickListener(this);
        button4 = (Button) findViewById(R.id.option4);
        button4.setOnClickListener(this);

        createQuestions();

    }

    public void createQuestions(){
        ImageQuestion question1 = new ImageQuestion();
        ImageQuestion question2 = new ImageQuestion();
        ImageQuestion question3 = new ImageQuestion();
        ImageQuestion question4 = new ImageQuestion();

        question1.setTitle("¿Cuál es una \"Mujer\"?");
        question1.setOption1(new ImageOption(R.drawable.house, "Jú", false));
        question1.setOption2(new ImageOption(R.drawable.dog, "Míchi", false));
        question1.setOption3(new ImageOption(R.drawable.girl, "Yabά", false));
        question1.setOption4(new ImageOption(R.drawable.woman, "Laglӧwa", true));

        questionsOne.add(question1);

//        question2.setTitle("¿Cuál es un \"Niño\"?");
//        question2.setOption1(new ImageOption(R.drawable.cat, "Michi", false));
//        question2.setOption2(new ImageOption(R.drawable.man, "Jayiwa", false));
//        question2.setOption3(new ImageOption(R.drawable.boy, "Yabά", true));
//        question2.setOption4(new ImageOption(R.drawable.woman, "Laglӧwa", false));
//
//        questionsOne.add(question2);

//        question3.setTitle("¿Cuál es un \"Hombre\"?");
//        question3.setOption1(new ImageOption(R.drawable.man, "Jayiwa", true));
//        question3.setOption2(new ImageOption(R.drawable.tree, "Kάl", false));
//        question3.setOption3(new ImageOption(R.drawable.banana, "chámó", false));
//        question3.setOption4(new ImageOption(R.drawable.girl, "Yabά", true));
//
//        questionsOne.add(question3);
//
//        question4.setTitle("¿Cuál es un \"Niña\"?");
//        question4.setOption2(new ImageOption(R.drawable.cloud, "Mӧ", false));
//        question4.setOption1(new ImageOption(R.drawable.man, "Jayiwa", false));
//        question2.setOption4(new ImageOption(R.drawable.woman, "Laglӧwa", false));
//        question4.setOption4(new ImageOption(R.drawable.girl, "Yabά", true));
//
//        questionsOne.add(question4);

        questionTitle.setText(question1.getTitle());

        imageOption1.setImageResource(question1.getOption1().getImage());
        imageOption2.setImageResource(question1.getOption2().getImage());
        imageOption3.setImageResource(question1.getOption3().getImage());
        imageOption4.setImageResource(question1.getOption4().getImage());

        button1.setText(question1.getOption1().getName());
        button2.setText(question1.getOption2().getName());
        button3.setText(question1.getOption3().getName());
        button4.setText(question1.getOption4().getName());
    }


    @Override
    public void onClick(View v) {
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
        switch (v.getId()){
            case R.id.option1:
                switch (actualQuestion) {
                    case 1:
                        alertDialogBuilder.setMessage("Ups, te equivocaste \n\n Mujer = Laglӧwa");
                        alertDialogBuilder.setPositiveButton("Continuar",
                                new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface arg0, int arg1) {
                                        Toast.makeText(IntroActivity.this,"Click continuar",Toast.LENGTH_LONG).show();
                                    }
                                });

                        AlertDialog alertDialog = alertDialogBuilder.create();
                        alertDialog.show();
                        break;
                    case 2:
                        break;
                    case 3:
                        break;
                    case 4:
                        break;

                }
                break;
            case R.id.option2:
                switch (actualQuestion) {
                    case 1:
                        alertDialogBuilder.setMessage("Ups, te equivocaste \n\n Mujer = Laglӧwa");
                        alertDialogBuilder.setPositiveButton("Continuar",
                                new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface arg0, int arg1) {
                                        Toast.makeText(IntroActivity.this,"Click continuar",Toast.LENGTH_LONG).show();
                                    }
                                });

                        AlertDialog alertDialog = alertDialogBuilder.create();
                        alertDialog.show();
                        break;
                    case 2:
                        break;
                    case 3:
                        break;
                    case 4:
                        break;

                }
                break;
            case R.id.option3:
                switch (actualQuestion) {
                    case 1:
                        alertDialogBuilder.setMessage("Ups, te equivocaste \n\n Mujer = Laglӧwa");
                        alertDialogBuilder.setPositiveButton("Continuar",
                                new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface arg0, int arg1) {
                                        Toast.makeText(IntroActivity.this,"Click continuar",Toast.LENGTH_LONG).show();
                                    }
                                });

                        AlertDialog alertDialog = alertDialogBuilder.create();
                        alertDialog.show();
                        break;
                    case 2:
                        break;
                    case 3:
                        break;
                    case 4:
                        break;

                }
                break;
            case R.id.option4:
                switch (actualQuestion) {
                    case 1:
                        alertDialogBuilder.setMessage("Felicidades acertaste \n\n Mujer = Laglӧwa");
                        alertDialogBuilder.setPositiveButton("Continuar",
                                new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface arg0, int arg1) {
                                        Toast.makeText(IntroActivity.this,"Click continuar",Toast.LENGTH_LONG).show();
                                    }
                                });

                        AlertDialog alertDialog = alertDialogBuilder.create();
                        alertDialog.show();
                        break;
                    case 2:
                        break;
                    case 3:
                        break;
                    case 4:
                        break;

                }
                break;
        }
    }
}
