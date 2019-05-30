package br.com.alura.agenda.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import br.com.alura.agenda.R;
import br.com.alura.agenda.model.Aluno;

public class ListaAlunoAdapter extends BaseAdapter {
    private final List<Aluno> alunos = new ArrayList<>();
    private final Context contexto;

    public ListaAlunoAdapter(Context contexto) {
        this.contexto = contexto;
    }

    @Override
    public int getCount() {
        return alunos.size();
    }

    @Override
    public Aluno getItem(int posicao) {
        return alunos.get(posicao);
    }

    @Override
    public long getItemId(int posicao) {
        return alunos.get(posicao).getId();
    }

    @Override
    public View getView(int posicao, View convertView, ViewGroup pai) {
        View view = criarView(pai);
        Aluno aluno = getItem(posicao);
        vincular(view, aluno);

        return view;
    }

    private void vincular(View view, Aluno aluno) {
        TextView nome = view.findViewById(R.id.item_aluno_nome);
        TextView telefone = view.findViewById(R.id.item_aluno_telefone);
        nome.setText(aluno.getNome());
        telefone.setText(aluno.getTelefone());
    }

    private View criarView(ViewGroup pai) {
        return LayoutInflater.from(contexto).inflate(R.layout.item_aluno, pai, false);
    }

    public void atualizar(List<Aluno> alunos){
        this.alunos.clear();
        this.alunos.addAll(alunos);
        notifyDataSetChanged();
    }

    public void remove(Aluno aluno) {
        alunos.remove(aluno);
        notifyDataSetChanged();
    }
}
