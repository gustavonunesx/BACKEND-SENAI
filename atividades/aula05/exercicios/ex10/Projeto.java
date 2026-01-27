package aula05.exercicios.ex10;

import java.util.ArrayList;
import java.util.List;

public class Projeto {
    
    private String nome;
    private List<MembroEquipe> membros;
    private List<Tarefa> tarefas;

    public Projeto(String nome) {
        this.nome = nome;
        this.membros = new ArrayList<>();
        this.tarefas = new ArrayList<>();
    }

    public void adicionarMembro(MembroEquipe membro) {
        membros.add(membro);
    }

    public void adicionarTarefa(Tarefa tarefa) {
        tarefas.add(tarefa);
    }

 
    public void exibirProjeto() {
        System.out.println("Projeto: " + nome);

     
        for (MembroEquipe membro : membros) {
            membro.trabalhar();
        }

        System.out.println("Tarefas do Projeto:");
        for (Tarefa tarefa : tarefas) {
            tarefa.exibirTarefa();
        }
    }

}
