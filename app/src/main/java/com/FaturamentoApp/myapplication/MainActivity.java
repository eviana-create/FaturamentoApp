package com.FaturamentoApp.myapplication;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.NumberPicker;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    public static final String ARQUIVO_MEUS_DADOS = "Meu Arquivo";

    private Button mBotaoConfirmar;
    private TextView mTexto;
    private NumberPicker mNumberPicker;
    private EditText mEditText;
    private RadioGroup radioGroup;
    private Button mButton;
    private Button mButtonTitulo;
    private TextView mTextView;

    private NumberPicker.OnValueChangeListener valoAlteradolistener = new NumberPicker.OnValueChangeListener() {
        @Override
        public void onValueChange(NumberPicker numberPicker, int valorAntigo, int valorAtual) {
            //Ao selecionar um ano diferente no NumberPicker, exibeo saldo para o usuário
            exibirSaldo(valorAtual);

        }
    };

    private void adicionarValor(int ano, float valor) {
        SharedPreferences sharedPreferences =
                getSharedPreferences(ARQUIVO_MEUS_DADOS, Context.MODE_PRIVATE);
        float valorAtual = sharedPreferences.getFloat(String.valueOf(ano),0);
        float novoValor = valorAtual + valor;
    sharedPreferences.edit().putFloat(String.valueOf(ano), novoValor).apply();

    }

        private void excluirValor(int ano, float valor) {
        SharedPreferences sharedPreferences =
                getSharedPreferences(ARQUIVO_MEUS_DADOS, Context.MODE_PRIVATE);
        float valorAtual = sharedPreferences.getFloat(String.
                valueOf(ano), 0);
        float novoValor = valorAtual - valor;
        if (novoValor < 0) {
            novoValor = 0;
        }
        sharedPreferences.edit().putFloat(String.valueOf(ano), novoValor).apply();
    }

        private void exibirSaldo(int ano) {
        SharedPreferences sharedPreferences =getSharedPreferences(ARQUIVO_MEUS_DADOS, Context.MODE_PRIVATE);
        float saldo = sharedPreferences.getFloat(String.valueOf(ano), 0);
        mTextView.setText(String.format("R$ %f", saldo));
        }

    @Override
    protected void onResume() {
        super.onResume();

        SharedPreferences sharedPreferences = getSharedPreferences(ARQUIVO_MEUS_DADOS, Context.MODE_PRIVATE);
        String nomeFantasia = sharedPreferences.getString("nomeFantasia", null);
            if (nomeFantasia!=null) {
                setTitle(nomeFantasia);
            }
            int ano = mNumberPicker.getValue();
            exibirSaldo(ano);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mBotaoConfirmar =findViewById(R.id.button);
        mTexto = findViewById(R.id.textViewSaldo);
        mNumberPicker = findViewById(R.id.numberPicker2);
        mEditText = findViewById(R.id.editTextTextPersonName);
        mTextView = findViewById(R.id.textView2);
        mButtonTitulo = findViewById(R.id.button2);

        mNumberPicker.setMinValue(2000);
        mNumberPicker.setMaxValue(2030);

        // registra o Listener para alteração de valores no NumberPicker
        mNumberPicker.setOnValueChangedListener(valoAlteradolistener);

        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            if (!mEditText.getText().toString().isEmpty()) {
            //Recupera o valordigitado e converte para float
                float valor = Float.parseFloat(mEditText.getText().toString());
            //Recupera o ano selecionado
                int ano = mNumberPicker.getValue();

            //Verifica qual RadioButton está selecionado
            //Recuperamos o ID do RadioButton que está selecionado e comparamos com o ID dos RadioButtons
                switch (radioGroup.getCheckedRadioButtonId()) {
                    case R.id.radioButton:
                        adicionarValor(ano, valor);
                        break;
                    case R.id.radioButton2:
                        excluirValor(ano, valor);
                        break;
                }
                exibirSaldo(ano);
            }
            }
        });

        mBotaoConfirmar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        mButtonTitulo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(String.valueOf(getBaseContext();
                personalizarActivity.class);
                startActivity(intent);
            }
        });



    }
}