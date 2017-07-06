package com.aym.android.diwoapp;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.aym.android.diwoapp.Model.SelectQuestion;

import java.util.LinkedList;

public class Intro2Activity extends AppCompatActivity implements View.OnClickListener {

    public LinkedList<SelectQuestion> questions= new LinkedList<>();
    public TextView questionTitle;
    public int actualQuestion = 0;
    public SelectQuestion Newquestion;
    public ProgressBar bar;
    public ImageView banner;

    public int right = 0;
    public int wrong = 0;

    public Button button1;
    public Button button2;
    public Button button3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro2);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        bar = (ProgressBar)findViewById(R.id.progressBar2);
        bar.setMax(11);
        bar.setProgress(4);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            right = extras.getInt("totalRight");
            wrong = extras.getInt("totalWrong");
        }

        questionTitle = (TextView) findViewById(R.id.question2);

        button1 = (Button) findViewById(R.id.option1q2);
        button1.setOnClickListener(this);
        button2 = (Button) findViewById(R.id.option2q2);
        button2.setOnClickListener(this);
        button3 = (Button) findViewById(R.id.option3q2);
        button3.setOnClickListener(this);

        banner = (ImageView) findViewById(R.id.banner1);

        createQuestions();

//        Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                .setAction("Action", null).show();
    }

    public void createQuestions() {
        SelectQuestion question1 = new SelectQuestion("¿Cómo se dice \"Hombre\"?", "Jayiwa", "Chíchi", "Laglӧwa");
        questions.add(question1);

        SelectQuestion question2 = new SelectQuestion("¿Cómo se dice \"Niño\"?", "Kάl", "Yabά", "Michi");
        questions.add(question2);

        SelectQuestion question3 = new SelectQuestion("¿\"Laglӧwa\" significa?", "Hombre", "Niña", "Mujer");
        questions.add(question3);

        SelectQuestion question4 = new SelectQuestion("¿\"Yaba\" significa?", "Mujer", "Niña", "Hombre");
        questions.add(question4);

        questionTitle.setText(question1.getTitle());
        button1.setText(question1.getOption1());
        button2.setText(question1.getOption2());
        button3.setText(question1.getOption3());
    }

    public void disableButtons(){
        button1.setEnabled(false);
        button2.setEnabled(false);
        button3.setEnabled(false);
    }

    public void enableButtons(){
        button1.setEnabled(true);
        button2.setEnabled(true);
        button3.setEnabled(true);
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
                        bar.setProgress(4+actualQuestion);

                        if (actualQuestion == 1) {
                            banner.setImageResource(R.drawable.banner2);
                        }

                        if (actualQuestion == 2) {
                            banner.setImageResource(R.drawable.banner3);
                        }

                        if (actualQuestion == 3) {
                            banner.setImageResource(R.drawable.banner4);
                        }

                        if (actualQuestion != 4) {
                            Newquestion = questions.get(actualQuestion);

                            questionTitle.setText(Newquestion.getTitle());

                            button1.setText(Newquestion.getOption1());
                            button2.setText(Newquestion.getOption2());
                            button3.setText(Newquestion.getOption3());

                            enableButtons();
                        } else {
                            Intent intent = new Intent(Intro2Activity.this, Intro3Activity.class);
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
            case R.id.option1q2:
                switch (actualQuestion) {
                    case 0:
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
                    case 2:
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
            case R.id.option2q2:
                switch (actualQuestion) {
                    case 0:
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
                    case 2:
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
                    case 3:
                        right++;
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
            case R.id.option3q2:
                switch (actualQuestion) {
                    case 0:
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
                    case 2:
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
                            Intent intent = new Intent(Intro2Activity.this, MainActivity.class);
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
