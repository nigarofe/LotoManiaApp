package com.ifmg.lotomania;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Collection;
import java.util.Collections;
import java.util.Random;
import java.util.Vector;

public class MainActivity extends AppCompatActivity {

    private EditText inicioTxt;
    private EditText fimTxt;
    private EditText quantidadeTxt;
    private Button sortearBtn;
    private EditText valoresTxt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inicioTxt = (EditText) findViewById(R.id.inicioTxt);
        fimTxt = (EditText) findViewById(R.id.fimTxt);
        quantidadeTxt = (EditText) findViewById(R.id.quantidadeTxt);
        sortearBtn = (Button) findViewById(R.id.sortearBtn);
        valoresTxt = (EditText) findViewById(R.id.valoresTxt);

        cadastrarEventos();
    }

    private void cadastrarEventos() {
        sortearBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!inicioTxt.getText().toString().isEmpty() && !fimTxt.getText().toString().isEmpty() &&
                        !quantidadeTxt.getText().toString().isEmpty()) {

                    int inicio = Integer.parseInt(inicioTxt.getText().toString());
                    int fim = Integer.parseInt(fimTxt.getText().toString());
                    int quantidade = Integer.parseInt(quantidadeTxt.getText().toString());

                    Vector<Integer> valores = new Vector<>();
                    Random gerador = new Random();

                    while (valores.size() < quantidade) {
                        int n = gerador.nextInt(fim - inicio + 1) + inicio;

                        if (!valores.contains(n)) {
                            valores.add(n);
                        }
                    }

                    Collections.sort(valores);

                    String output = "";
                    for (int i = 0; i < valores.size(); i++) {
                        if(valores.get(i) < 10){
                            output += "0";
                        }
                        output += valores.get(i) + "  ";
                    }
                    valoresTxt.setText(output);
                } else{
                    Toast.makeText(MainActivity.this, "Preencha todos os campos!", Toast.LENGTH_LONG);
                }
            }
        });
    }
}
















