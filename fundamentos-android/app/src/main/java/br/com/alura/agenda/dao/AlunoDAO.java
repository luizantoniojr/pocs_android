package br.com.alura.agenda.dao;

import java.util.ArrayList;
import java.util.List;

import br.com.alura.agenda.model.Aluno;

public class AlunoDAO {

    private final static List<Aluno> alunos = new ArrayList<>();
    private static int contadorDeIds = 1;

    public void salva(Aluno aluno) {
        aluno.setId(contadorDeIds);
        alunos.add(aluno);
        incrementaId();
    }

    private void incrementaId() {
        contadorDeIds++;
    }

    public void edita(Aluno aluno) {
        Aluno alunoEditado = buscarAlunoPeloId(aluno.getId());
        int posicao = alunos.indexOf(alunoEditado);
        alunos.set(posicao, aluno);
    }

    public List<Aluno> todos() {
        return new ArrayList<>(alunos);
    }

    public void remove(int idAluno) {
        Aluno alunoRemovido = buscarAlunoPeloId(idAluno);
        alunos.remove(alunoRemovido);
    }

    private Aluno buscarAlunoPeloId(int idAluno) {
        for (Aluno item : alunos)
            if (item.getId() == idAluno)
                return item;
        return null;
    }
}
