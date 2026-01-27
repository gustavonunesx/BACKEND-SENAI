package aula05.exercicios.ex10;

public class Tarefa {
    
    private String desc;
    private Prioridade prioridade;

    public Tarefa(String descricao, Prioridade prioridade) {
        this.desc = descricao;
        this.prioridade = prioridade;
    }

    public void exibirTarefa() {
        System.out.println("Tarefa: " + desc + " | Prioridade: " + prioridade.name() + " (" + prioridade.getValor() + ")");
    }

}
