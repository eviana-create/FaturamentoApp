package com.FaturamentoApp.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class personalizarActivity extends AppCompatActivity {

    private EditText mEditTextNomeFantasia;
    private Button mButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personalizar);

        mEditTextNomeFantasia = findViewById(R.id.editTextTextPersonName2);
        mButton = findViewById(R.id.button3);

        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nomeFantasia = mEditTextNomeFantasia.getText().toString();
                    if (!nomeFantasia.isEmpty()) {
                        getSharedPreferences(MainActivity.ARQUIVO_MEUS_DADOS, Context.MODE_PRIVATE)
                                .edit().putString("nomeFantasia", nomeFantasia).apply();
                    }
            }
        });

    }
}