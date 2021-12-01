package com.example.memorygame;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class TelaVitoria extends AppCompatActivity {
    ConstraintLayout bgElement;
    Button btnReset;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_vitoria);
        bgElement = (ConstraintLayout) findViewById(R.id.container);
        String color = getIntent().getStringExtra("Bckgd");
        bgElement.setBackgroundColor(Integer.parseInt(color));
        btnReset = new Button(TelaVitoria.this);
        btnReset.findViewById(R.id.buttonVitoria);
    }

    public void reiniciarJogo(View view){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}