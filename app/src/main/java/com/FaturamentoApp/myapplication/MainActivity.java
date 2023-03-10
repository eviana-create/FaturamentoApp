package com.FaturamentoApp.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.NumberPicker;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    public static final String ARQUIVO_MEUS_DADOS = "Meu Arquivo";
    Button mBotaoConfirmar;
    TextView mTexto;
    NumberPicker mNumberPicker;

    private void adicionarValor(int ano, float valor) {
        SharedPreferences sharedPreferences = getSharedPreferences(
            ARQUIVO_MEUS_DADOS, Context.MODE_PRIVATE
        );
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mBotaoConfirmar =findViewById(R.id.button);
        mTexto = findViewById(R.id.textView);
        mNumberPicker = findViewById(R.id.numberPicker2);

        mNumberPicker.setMinValue(2000);
        mNumberPicker.setMaxValue(2022);

        mNumberPicker.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker picker, int oldVal, int newVal) {
                Toast.makeText(MainActivity.this, "Teste do Listener", Toast.LENGTH_SHORT).show();
            }
        });

        mBotaoConfirmar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            mTexto.setText("Teste de botao!");

            }
        });
    }
}