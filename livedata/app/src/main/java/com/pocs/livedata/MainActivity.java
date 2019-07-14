package com.pocs.livedata;

import android.os.Bundle;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import static com.pocs.livedata.R.layout;
import static com.pocs.livedata.R.string;

public class MainActivity extends AppCompatActivity {

    private PessoaViewModel pessoa;
    private EditText nomeEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(layout.activity_main);
        setTitle(string.cadastro_de_pessoa);

        nomeEditText = findViewById(R.id.nomeEditText);


        //Definindo relação entre a ViewModel e o UI Controller.
        pessoa = ViewModelProviders.of(this).get(PessoaViewModel.class);


        // Criando o observer que atualizará a UI
        final Observer<String> nomeObserver= new Observer<String>() {
            @Override
            public void onChanged(@Nullable final String nome) {
                nomeEditText.setText(nome);
            }
        };

        //observa o LiveData, passando esta activity como o LifecycleOwner e o observer.
        pessoa.getNome().observe(this, nomeObserver);
    }
}
