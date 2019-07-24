package com.pocs.viagens.ui.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.pocs.viagens.R;
import com.pocs.viagens.ui.adapter.ListaPacotesAdapter;

import java.util.List;

import br.com.alura.aluraviagens.dao.PacoteDAO;
import br.com.alura.aluraviagens.model.Pacote;

public class ListaPacotesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_pacotes);
        setTitle(getString(R.string.pacotes));

        PacoteDAO pacoteDAO = new PacoteDAO();
        List<Pacote> pacotes = pacoteDAO.lista();

        ListView listaDePacotes = findViewById(R.id.lista_pacotes_listview);
        listaDePacotes.setAdapter(new ListaPacotesAdapter(pacotes, this));
    }
}
