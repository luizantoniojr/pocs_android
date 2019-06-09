package br.com.alura.agenda.ui;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ListView;

import br.com.alura.agenda.dao.AlunoDAO;
import br.com.alura.agenda.model.Aluno;
import br.com.alura.agenda.ui.adapter.ListaAlunoAdapter;

public class ListaAlunoView {

    private Context contexto;
    private ListaAlunoAdapter adapter;
    private AlunoDAO dao;

    public ListaAlunoView(Context context) {
        this.contexto = context;
        adapter = new ListaAlunoAdapter(context);
        dao = new AlunoDAO();
    }

    public void configuraAdapter(ListView listaDeAlunos) {
        listaDeAlunos.setAdapter(adapter);
    }

    public void atualizarAdapter() {
        adapter.atualizar(dao.todos());
    }


    public void exibirConfirmacaoRemocao(final MenuItem item) {
        new AlertDialog
                .Builder(contexto)
                .setTitle("Atenção")
                .setMessage("Tem certeza que deseja remover o aluno?")
                .setPositiveButton("Sim", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        removerAluno(item);
                    }
                })
                .setNegativeButton("Não", null)
                .show();
    }

    private void removerAluno(MenuItem item) {
        AdapterView.AdapterContextMenuInfo menuInfo = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        Aluno alunoEscolhido = adapter.getItem(menuInfo.position);
        removerAluno(alunoEscolhido);
    }

    private void removerAluno(Aluno aluno) {
        dao.remove(aluno.getId());
        adapter.remove(aluno);
    }
}
