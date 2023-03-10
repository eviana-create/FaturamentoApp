package com.FaturamentoApp.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button mBotaoConfirmar;
    TextView mTexto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mBotaoConfirmar =findViewById(R.id.button);
        mTexto = findViewById(R.id.textView);

        mBotaoConfirmar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            mTexto.setText("Teste de botao!");
            }
        });
    }
}