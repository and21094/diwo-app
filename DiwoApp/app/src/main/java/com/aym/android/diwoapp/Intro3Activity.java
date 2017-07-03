package com.aym.android.diwoapp;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;


import com.aym.android.diwoapp.Model.WriteQuestion;

import java.util.LinkedList;

public class Intro3Activity extends AppCompatActivity implements View.OnClickListener {

    public TextView questionTitle;
    public LinkedList<WriteQuestion> questions= new LinkedList<>();
    public WriteQuestion Newquestion;
    public int actualQuestion = 0;
    public EditText answer;
    public TextInputLayout layout;
    public String nextAction = "¡Siguiente Pregunta!";


    public Button button1;
    public ProgressBar bar;

    public int right = 0;
    public int wrong = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro3);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        questionTitle = (TextView) findViewById(R.id.question3);
        answer = (EditText) findViewById(R.id.answer);
        layout = (TextInputLayout) findViewById(R.id.answerLayout);

        button1 = (Button) findViewById(R.id.review);
        button1.setOnClickListener(this);

        bar = (ProgressBar)findViewById(R.id.progressBar3);
        bar.setMax(11);
        bar.setProgress(8);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            right = extras.getInt("totalRight");
            wrong = extras.getInt("totalWrong");
        }

        createQuestions();

    }

    public void createQuestions(){

        WriteQuestion question1 = new WriteQuestion("Traduce \"egla laglӧwa\"", "una mujer");
        questions.add(question1);
        WriteQuestion question2 = new WriteQuestion("Traduce \"un hombre\"", "egla jayiwa");
        questions.add(question2);
        WriteQuestion question3 = new WriteQuestion("Traduce \"egla yaba\"", "un niño");
        questions.add(question3);

        questionTitle.setText(question1.getQuestion());
        Newquestion = question1;

    }

    public void disableButtons(){
        button1.setEnabled(false);
    }

    public void enableButtons(){
        button1.setEnabled(true);
    }

    @Override
    public void onClick(View v) {
        disableButtons();
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
        AlertDialog alertDialog;
        final Snackbar snackbar = Snackbar
                .make( v, "", Snackbar.LENGTH_INDEFINITE)
                .setAction(nextAction, new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        actualQuestion ++;
                        bar.setProgress(8+actualQuestion);
                        if (actualQuestion != 3) {
                            answer.setFocusableInTouchMode(false);
                            answer.setFocusable(false);
                            answer.setFocusableInTouchMode(true);
                            answer.setFocusable(true);
                            if (actualQuestion == 1 ) {
                                layout.setHint("Escribe en Cabécar");
                            } else {
                                layout.setHint("Escribe en Español");
                            }

                            Newquestion = questions.get(actualQuestion);
                            answer.setText("");
                            questionTitle.setText(Newquestion.getQuestion());

                            if (actualQuestion == 2 ) {
                                nextAction = "¡Ver Resultados!";
                            }
                            enableButtons();
                        } else {
                            Intent intent = new Intent(Intro3Activity.this, ResultsActivity.class);
                            intent.putExtra("totalRight", right);
                            intent.putExtra("totalWrong", wrong);
                            startActivity(intent);
                        }

                    }
                });
        snackbar.setActionTextColor(Color.WHITE);
        View snackBarView = snackbar.getView();
        snackBarView.setBackgroundColor(Color.rgb(228, 123, 0));


        if (v.getId() == R.id.review){
            if (answer.getText().toString().length() == 0) {
                answer.setError( "Escribe una respuesta" );
            } else {
                switch (actualQuestion) {

                    case 0:
                        if (Newquestion.getAnswer().equals(answer.getText().toString().toLowerCase().trim())){
                            right++;
                            alertDialogBuilder.setMessage("Felicidades acertaste \n\n egla laglӧwa = una mujer");
                            alertDialogBuilder.setPositiveButton("Continuar",
                                    new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface arg0, int arg1) {
                                            snackbar.show();
                                        }
                                    });

                            alertDialog = alertDialogBuilder.create();
                            alertDialog.show();
                        } else {
                            wrong++;
                            alertDialogBuilder.setMessage("Ups, te equivocaste \n\n egla laglӧwa = una mujer");
                            alertDialogBuilder.setPositiveButton("Continuar",
                                    new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface arg0, int arg1) {
                                            snackbar.show();
                                        }
                                    });

                            alertDialog = alertDialogBuilder.create();
                            alertDialog.show();
                        }
                        break;
                    case 1:
                        if (Newquestion.getAnswer().equals(answer.getText().toString().toLowerCase().trim())){
                            right++;
                            alertDialogBuilder.setMessage("Felicidades acertaste \n\n un hombre = egla jayiwa");
                            alertDialogBuilder.setPositiveButton("Continuar",
                                    new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface arg0, int arg1) {
                                            snackbar.show();
                                        }
                                    });

                            alertDialog = alertDialogBuilder.create();
                            alertDialog.show();
                        } else {
                            wrong++;
                            alertDialogBuilder.setMessage("Ups, te equivocaste \n\n un hombre = egla jayiwa");
                            alertDialogBuilder.setPositiveButton("Continuar",
                                    new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface arg0, int arg1) {
                                            snackbar.show();
                                        }
                                    });

                            alertDialog = alertDialogBuilder.create();
                            alertDialog.show();
                        }
                    break;
                    case 2:
                        if (Newquestion.getAnswer().equals(answer.getText().toString().toLowerCase().trim())
                                || "una niña".equals(answer.getText().toString().toLowerCase())){
                            right++;
                            alertDialogBuilder.setMessage("Felicidades acertaste \n\n egla yabά = un niño \n\n o \n\n egla yabά = una niña");
                            alertDialogBuilder.setPositiveButton("Continuar",
                                    new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface arg0, int arg1) {
                                            snackbar.show();
                                        }
                                    });

                            alertDialog = alertDialogBuilder.create();
                            alertDialog.show();
                        } else {
                            wrong++;
                            alertDialogBuilder.setMessage("Ups, te equivocaste \n\n egla yabά = un niño \n\n o \n\n egla yabά = una niña");
                            alertDialogBuilder.setPositiveButton("Continuar",
                                    new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface arg0, int arg1) {
                                            snackbar.show();
                                        }
                                    });

                            alertDialog = alertDialogBuilder.create();
                            alertDialog.show();
                        }
                        break;

                }
            }

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
                            Intent intent = new Intent(Intro3Activity.this, MainActivity.class);
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
