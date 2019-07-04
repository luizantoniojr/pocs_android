package com.pocs.viewmodel;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;

public class MainActivity extends AppCompatActivity {

    private ContadorViewModel contadorViewModel;
    private TextView valorTextView;
    private Button botao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        contadorViewModel = ViewModelProviders.of(this).get(ContadorViewModel.class);

        valorTextView = findViewById(R.id.countTextView);
        valorTextView.setText(Integer.toString(contadorViewModel.getValor()));

        botao = findViewById(R.id.countButton);
        botao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int valor = contadorViewModel.getValor() + 1;
                contadorViewModel.setValor(valor);
                valorTextView.setText(Integer.toString(valor));
            }
        });
    }
}
