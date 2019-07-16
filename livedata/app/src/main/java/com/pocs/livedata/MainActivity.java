package com.pocs.livedata;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import static com.pocs.livedata.R.layout;

public class MainActivity extends AppCompatActivity {

    private ContadorViewModel contadorViewModel;
    private TextView valorTextView;
    private Button botao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(layout.activity_main);

        contadorViewModel = ViewModelProviders.of(this).get(ContadorViewModel.class);

        valorTextView = findViewById(R.id.countTextView);

        botao = findViewById(R.id.countButton);
        botao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                incrementarValorNaViewModel();
            }
        });

        definirObservador();
    }

    private void incrementarValorNaViewModel() {
        Integer valorNaViewModel = contadorViewModel.getValor().getValue();
        int valor = valorNaViewModel != null ? valorNaViewModel : 0;

        valor++;

        contadorViewModel.getValor().setValue(valor);
    }

    private void definirObservador() {
        contadorViewModel.getValor().observe(this, new Observer<Integer>() {
            @Override
            public void onChanged(@Nullable final Integer valor) {
                valorTextView.setText(valor.toString());
            }
        });
    }
}
