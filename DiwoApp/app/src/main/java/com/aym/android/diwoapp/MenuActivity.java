package com.aym.android.diwoapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MenuActivity extends AppCompatActivity implements View.OnClickListener{

    private Button btnCabecar, btnBribri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        btnCabecar = (Button)findViewById(R.id.btnCabecar);
        btnBribri = (Button)findViewById(R.id.btnBribri);
        btnCabecar.setOnClickListener(this);
        btnBribri.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btnCabecar:
                Intent intent = new Intent(MenuActivity.this, MainActivity.class);
                startActivity(intent);
                break;
            default:
                Toast.makeText(this,"Esta función no está disponible en el prototipo",Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
