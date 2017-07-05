package com.aym.android.diwoapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    public Button intro;
    private Button btnSaludos, btnEncuentros, btnOcupaciones, btnRutinas, btnEmociones;
    private FloatingActionButton btnBattle;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        intro = (Button) findViewById(R.id.btnIntro);
        btnSaludos = (Button)findViewById(R.id.btnSaludos);
        btnEncuentros = (Button)findViewById(R.id.btnEncuentros);
        btnOcupaciones = (Button)findViewById(R.id.btnOcupaciones);
        btnRutinas = (Button)findViewById(R.id.btnRutinas);
        btnEmociones = (Button)findViewById(R.id.btnEmociones);
        btnBattle = (FloatingActionButton)findViewById(R.id.btnBattle);
        intro.setOnClickListener(this);
        btnSaludos.setOnClickListener(this);
        btnEncuentros.setOnClickListener(this);
        btnOcupaciones.setOnClickListener(this);
        btnRutinas.setOnClickListener(this);
        btnEmociones.setOnClickListener(this);
        btnBattle.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btnIntro:
                Intent intent = new Intent(MainActivity.this, IntroActivity.class);
                startActivity(intent);
                break;
            default:
                Toast.makeText(this,"Esta función no está disponible en el prototipo",Toast.LENGTH_LONG).show();
                break;
        }
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK && event.getRepeatCount() == 0) {
            moveTaskToBack(true);
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }
}
