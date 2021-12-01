package com.example.memorygame;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private Button btn1, btn2, btn3, btn4, btn5, btn6;
    private String indice;
    private List<String> lista;
    private List<Button> listaBtn;
    private int indiceLista;
    private ProgressBar pg;
    ConstraintLayout bgElement;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        indiceLista = 0;
        lista = Arrays.asList("one","two","three","four","five","six");
        instanciaBtn();
        listaBtn = new ArrayList<>();
        declaraIDBtn();
        Collections.shuffle(lista);
        indice = lista.get(0);
        bgElement = (ConstraintLayout) findViewById(R.id.container);
        pg = new ProgressBar(MainActivity.this);
        pg = findViewById(R.id.progressBar);
    }

    private void instanciaBtn() {
        btn1 = new Button(MainActivity.this);
        btn2 = new Button(MainActivity.this);
        btn3 = new Button(MainActivity.this);
        btn4 = new Button(MainActivity.this);
        btn5 = new Button(MainActivity.this);
        btn6 = new Button(MainActivity.this);
    }

    private void declaraIDBtn() {
        listaBtn.add(findViewById(R.id.one));
        listaBtn.add(findViewById(R.id.two));
        listaBtn.add(findViewById(R.id.three));
        listaBtn.add(findViewById(R.id.four));
        listaBtn.add(findViewById(R.id.five));
        listaBtn.add(findViewById(R.id.six));
    }


    public void clickOne(View view) {
        if(btn1.getResources().getResourceEntryName(view.getId()).equals(indice)) {
            bgElement.setBackgroundColor(btn1.getResources().getColor(R.color.teal_200));
            indiceLista+=1;
            pg.incrementProgressBy(1);
            if(!verificaVitoria(btn1.getResources().getColor(R.color.teal_200)))
                indice = lista.get(indiceLista);
            view.setVisibility(View.GONE);
        }
        else {
            resetButtons(view);
        }
    }

    public void clickTwo(View view) {
        if(btn2.getResources().getResourceEntryName(view.getId()).equals(indice)) {
            bgElement.setBackgroundColor(btn2.getResources().getColor(R.color.orange));
            indiceLista+=1;
            pg.incrementProgressBy(1);
            if(!verificaVitoria(btn2.getResources().getColor(R.color.orange)))
                indice = lista.get(indiceLista);

            view.setVisibility(View.GONE);

        }
        else {
            resetButtons(view);
        }
    }

    private boolean verificaVitoria(int color) {
        if(indiceLista == 6){
            pg.setProgress(6);
            Intent intent = new Intent(this, TelaVitoria.class);
            intent.putExtra("Bckgd", String.format("%s",color));
            startActivity(intent);
            return true;
        }
        return false;
    }

    public void clickThree(View view) {
        if(btn3.getResources().getResourceEntryName(view.getId()).equals(indice)) {
            bgElement.setBackgroundColor(btn3.getResources().getColor(R.color.design_default_color_error));
            indiceLista+=1;
            pg.incrementProgressBy(1);
            if(!verificaVitoria(btn3.getResources().getColor(R.color.design_default_color_error)))
                indice = lista.get(indiceLista);
            view.setVisibility(View.GONE);
        }
        else {
            resetButtons(view);
        }
    }
    public void clickFour(View view) {
        if(btn4.getResources().getResourceEntryName(view.getId()).equals(indice)) {
            bgElement.setBackgroundColor(btn4.getResources().getColor(R.color.blackp));
            indiceLista+=1;
            pg.incrementProgressBy(1);
            if(!verificaVitoria(btn4.getResources().getColor(R.color.blackp)))
                indice = lista.get(indiceLista);
            view.setVisibility(View.GONE);
        }
        else {
            resetButtons(view);
        }
    }
    public void clickFive(View view) {
            if(btn5.getResources().getResourceEntryName(view.getId()).equals(indice)) {
                bgElement.setBackgroundColor(btn5.getResources().getColor(R.color.amarelo));
                indiceLista+=1;
                pg.incrementProgressBy(1);
                if(!verificaVitoria(btn5.getResources().getColor(R.color.amarelo)))
                    indice = lista.get(indiceLista);
                view.setVisibility(View.GONE);
            }
            else {
                resetButtons(view);
            }
    }
    public void clickSix(View view) {
        if(btn6.getResources().getResourceEntryName(view.getId()).equals(indice)) {
            bgElement.setBackgroundColor(btn6.getResources().getColor(R.color.purple_200));
            indiceLista+=1;
            pg.incrementProgressBy(1);
            if(!verificaVitoria(btn6.getResources().getColor(R.color.purple_200)))
                indice = lista.get(indiceLista);
            view.setVisibility(View.GONE);
        }
        else {
            resetButtons(view);
        }

    }

    public void resetButtons(View view) {
        for (Button btn: listaBtn) {
            if(btn.getVisibility() != View.VISIBLE){
                btn.setVisibility(View.VISIBLE);
            }
        }
        bgElement.setBackgroundColor(getResources().getColor(R.color.white));
        indiceLista = 0;
        indice = lista.get(indiceLista);
        pg.setProgress(0);
    }

    public void reiniciarJogo(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}