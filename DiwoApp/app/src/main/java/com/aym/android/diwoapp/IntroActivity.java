package com.aym.android.diwoapp;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
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
    public ProgressBar bar;

    public Button button1;
    public Button button2;
    public Button button3;
    public Button button4;

    public int right= 0;
    public int wrong = 0;
    public int actualQuestion = 0;
    ImageQuestion Newquestion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        questionTitle = (TextView) findViewById(R.id.question);
        bar = (ProgressBar)findViewById(R.id.progressBar);
        bar.setMax(11);


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

        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
        AlertDialog alertDialog;

        alertDialogBuilder.setMessage("¡Bienvenido!"+
                " \n\n En esta lección aprenderas: \n hombre \n mujer \n niño \n niña \n\n"+
                "¿Empezamos?");
        alertDialogBuilder.setPositiveButton("Continuar",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface arg0, int arg1) {

                    }
                });
        alertDialog = alertDialogBuilder.create();
        alertDialog.show();

    }

    public void createQuestions(){
        ImageQuestion question1 = new ImageQuestion();
        ImageQuestion question2 = new ImageQuestion();
        ImageQuestion question3 = new ImageQuestion();
        ImageQuestion question4 = new ImageQuestion();

        question1.setTitle("¿Cuál es una \"Mujer\"?");
        question1.setOption1(new ImageOption(R.drawable.house, "Jú", false));
        question1.setOption2(new ImageOption(R.drawable.dog, "Chíchi", false));
        question1.setOption3(new ImageOption(R.drawable.girl, "Yabά", false));
        question1.setOption4(new ImageOption(R.drawable.woman, "Laglӧwa", true));

        questionsOne.add(question1);

        question2.setTitle("¿Cuál es un \"Niño\"?");
        question2.setOption1(new ImageOption(R.drawable.cat, "Michi", false));
        question2.setOption2(new ImageOption(R.drawable.man, "Jayiwa", false));
        question2.setOption3(new ImageOption(R.drawable.boy, "Yabά", true));
        question2.setOption4(new ImageOption(R.drawable.woman, "Laglӧwa", false));

        questionsOne.add(question2);

        question3.setTitle("¿Cuál es un \"Hombre\"?");
        question3.setOption1(new ImageOption(R.drawable.man, "Jayiwa", true));
        question3.setOption2(new ImageOption(R.drawable.tree, "Kάl", false));
        question3.setOption3(new ImageOption(R.drawable.banana, "chámó", false));
        question3.setOption4(new ImageOption(R.drawable.girl, "Yabά", true));

        questionsOne.add(question3);

        question4.setTitle("¿Cuál es una \"Niña\"?");
        question4.setOption1(new ImageOption(R.drawable.cloud, "Mӧ", false));
        question4.setOption2(new ImageOption(R.drawable.dog, "Chíchi", false));
        question4.setOption3(new ImageOption(R.drawable.woman, "Laglӧwa", false));
        question4.setOption4(new ImageOption(R.drawable.girl, "Yabά", true));

        questionsOne.add(question4);

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

    public void disableButtons(){
        button1.setEnabled(false);
        button2.setEnabled(false);
        button3.setEnabled(false);
        button4.setEnabled(false);
    }

    public void enableButtons(){
        button1.setEnabled(true);
        button2.setEnabled(true);
        button3.setEnabled(true);
        button4.setEnabled(true);
    }

    @Override
    public void onClick(View v) {
        disableButtons();
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
        AlertDialog alertDialog;
        final Snackbar snackbar = Snackbar
                .make( v, "", Snackbar.LENGTH_INDEFINITE)
                .setAction("¡Siguiente Pregunta!", new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        actualQuestion ++;
                        bar.setProgress(actualQuestion);

                        if (actualQuestion != 4) {
                            Newquestion = questionsOne.get(actualQuestion);

                            questionTitle.setText(Newquestion.getTitle());

                            imageOption1.setImageResource(Newquestion .getOption1().getImage());
                            imageOption2.setImageResource(Newquestion.getOption2().getImage());
                            imageOption3.setImageResource(Newquestion.getOption3().getImage());
                            imageOption4.setImageResource(Newquestion.getOption4().getImage());

                            button1.setText(Newquestion.getOption1().getName());
                            button2.setText(Newquestion.getOption2().getName());
                            button3.setText(Newquestion.getOption3().getName());
                            button4.setText(Newquestion.getOption4().getName());

                            enableButtons();
                        } else {
                            enableButtons();
                            Intent intent = new Intent(IntroActivity.this, Intro2Activity.class);
                            intent.putExtra("totalRight", right);
                            intent.putExtra("totalWrong", wrong);
                            startActivity(intent);
                        }

                    }
                });
        snackbar.setActionTextColor(Color.WHITE);
        View snackBarView = snackbar.getView();
        snackBarView.setBackgroundColor(Color.rgb(228, 123, 0));

        switch (v.getId()){
            case R.id.option1:
                switch (actualQuestion) {
                    case 0:
                        wrong++;
                        alertDialogBuilder.setMessage("Ups, te equivocaste \n\n Mujer = Laglӧwa");
                        alertDialogBuilder.setPositiveButton("Continuar",
                                new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface arg0, int arg1) {
                                        snackbar.show();
                                    }
                                });

                        alertDialog = alertDialogBuilder.create();
                        alertDialog.show();
                        break;
                    case 2:
                        right++;
                        alertDialogBuilder.setMessage("Felicidades acertaste \n\n Hombre = Jayiwa");
                        alertDialogBuilder.setPositiveButton("Continuar",
                                new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface arg0, int arg1) {
                                        snackbar.show();
                                    }
                                });

                        alertDialog = alertDialogBuilder.create();
                        alertDialog.show();
                        break;
                    case 1:
                        wrong++;
                        alertDialogBuilder.setMessage("Ups, te equivocaste \n\n Niño = Yabά");
                        alertDialogBuilder.setPositiveButton("Continuar",
                                new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface arg0, int arg1) {
                                        snackbar.show();
                                    }
                                });

                        alertDialog = alertDialogBuilder.create();
                        alertDialog.show();
                        break;
                    case 3:
                        wrong++;
                        alertDialogBuilder.setMessage("Ups, te equivocaste \n\n Niña = Yabά");
                        alertDialogBuilder.setPositiveButton("Continuar",
                                new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface arg0, int arg1) {
                                        snackbar.show();
                                    }
                                });

                        alertDialog = alertDialogBuilder.create();
                        alertDialog.show();
                        break;

                }
                break;
            case R.id.option2:
                switch (actualQuestion) {
                    case 0:
                        wrong++;
                        alertDialogBuilder.setMessage("Ups, te equivocaste \n\n Mujer = Laglӧwa");
                        alertDialogBuilder.setPositiveButton("Continuar",
                                new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface arg0, int arg1) {
                                        snackbar.show();
                                    }
                                });

                        alertDialog = alertDialogBuilder.create();
                        alertDialog.show();
                        break;
                    case 2:
                        wrong++;
                        alertDialogBuilder.setMessage("Ups, te equivocaste \n\n Hombre = Jayiwa");
                        alertDialogBuilder.setPositiveButton("Continuar",
                                new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface arg0, int arg1) {
                                        snackbar.show();
                                    }
                                });

                        alertDialog = alertDialogBuilder.create();
                        alertDialog.show();
                        break;
                    case 1:
                        wrong++;
                        alertDialogBuilder.setMessage("Ups, te equivocaste \n\n Niño = Yabά");
                        alertDialogBuilder.setPositiveButton("Continuar",
                                new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface arg0, int arg1) {
                                        snackbar.show();
                                    }
                                });

                        alertDialog = alertDialogBuilder.create();
                        alertDialog.show();
                        break;
                    case 3:
                        wrong++;
                        alertDialogBuilder.setMessage("Ups, te equivocaste \n\n Niña = Yabά");
                        alertDialogBuilder.setPositiveButton("Continuar",
                                new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface arg0, int arg1) {
                                        snackbar.show();
                                    }
                                });

                        alertDialog = alertDialogBuilder.create();
                        alertDialog.show();
                        break;

                }
                break;
            case R.id.option3:
                switch (actualQuestion) {
                    case 0:
                        wrong++;
                        alertDialogBuilder.setMessage("Ups, te equivocaste \n\n Mujer = Laglӧwa");
                        alertDialogBuilder.setPositiveButton("Continuar",
                                new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface arg0, int arg1) {
                                        snackbar.show();
                                    }
                                });

                        alertDialog = alertDialogBuilder.create();
                        alertDialog.show();
                        break;
                    case 2:
                        wrong++;
                        alertDialogBuilder.setMessage("Ups, te equivocaste \n\n Hombre = Jayiwa");
                        alertDialogBuilder.setPositiveButton("Continuar",
                                new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface arg0, int arg1) {
                                        snackbar.show();
                                    }
                                });

                        alertDialog = alertDialogBuilder.create();
                        alertDialog.show();
                        break;
                    case 1:
                        right++;
                        alertDialogBuilder.setMessage("Felicidades acertaste \n\n Niño = Yabά");
                        alertDialogBuilder.setPositiveButton("Continuar",
                                new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface arg0, int arg1) {
                                        snackbar.show();
                                    }
                                });

                        alertDialog = alertDialogBuilder.create();
                        alertDialog.show();
                        break;
                    case 3:
                        wrong++;
                        alertDialogBuilder.setMessage("Ups, te equivocaste \n\n Niña = Yabά");
                        alertDialogBuilder.setPositiveButton("Continuar",
                                new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface arg0, int arg1) {
                                        snackbar.show();
                                    }
                                });

                        alertDialog = alertDialogBuilder.create();
                        alertDialog.show();
                        break;

                }
                break;
            case R.id.option4:
                switch (actualQuestion) {
                    case 0:
                        right++;
                        alertDialogBuilder.setMessage("Felicidades acertaste \n\n Mujer = Laglӧwa");
                        alertDialogBuilder.setPositiveButton("Continuar",
                                new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface arg0, int arg1) {
                                        snackbar.show();
                                    }
                                });

                        alertDialog = alertDialogBuilder.create();
                        alertDialog.show();
                        break;
                    case 2:
                        wrong++;
                        alertDialogBuilder.setMessage("Ups, te equivocaste \n\n Hombre = Jayiwa");
                        alertDialogBuilder.setPositiveButton("Continuar",
                                new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface arg0, int arg1) {
                                        snackbar.show();
                                    }
                                });

                        alertDialog = alertDialogBuilder.create();
                        alertDialog.show();
                        break;
                    case 1:
                        wrong++;
                        alertDialogBuilder.setMessage("Ups, te equivocaste \n\n Niño = Yabά");
                        alertDialogBuilder.setPositiveButton("Continuar",
                                new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface arg0, int arg1) {
                                        snackbar.show();
                                    }
                                });

                        alertDialog = alertDialogBuilder.create();
                        alertDialog.show();
                        break;
                    case 3:
                        wrong++;
                        alertDialogBuilder.setMessage("Felicidades acertaste \n\n Niña = Yabά");
                        alertDialogBuilder.setPositiveButton("Continuar",
                                new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface arg0, int arg1) {
                                        snackbar.show();
                                    }
                                });

                        alertDialog = alertDialogBuilder.create();
                        alertDialog.show();
                        break;

                }
                break;
        }
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK && event.getRepeatCount() == 0) {
        // Esto es lo que hace mi botón al pulsar ir a atrás
            AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
            AlertDialog alertDialog;

            alertDialogBuilder.setMessage("¿De verdad quieres salir? \n ¡Perderas todo tu progreso!");
            alertDialogBuilder.setPositiveButton("Salir",
                    new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface arg0, int arg1) {
                            Intent intent = new Intent(IntroActivity.this, MainActivity.class);
                            startActivity(intent);
                        }
                    });

            alertDialogBuilder.setNegativeButton("Continuar",
                    new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface arg0, int arg1) {
                        }
                    });

            alertDialog = alertDialogBuilder.create();
            alertDialog.show();

            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

}
