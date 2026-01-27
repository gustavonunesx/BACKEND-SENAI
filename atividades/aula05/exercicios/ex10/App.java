package aula05.exercicios.ex10;

public class App {
    public static void main(String[] args) {
        
        Projeto projeto = new Projeto("Desenvolvimento do Site");
        Programador dev1 = new Programador("João");
        Programador dev2 = new Programador("Maria");
        Designer designer1 = new Designer("Ana");

        projeto.adicionarMembro(dev1);
        projeto.adicionarMembro(dev2);
        projeto.adicionarMembro(designer1);

      
        Tarefa t1 = new Tarefa("Desenvolver a homepage", Prioridade.ALTA);
        Tarefa t2 = new Tarefa("Criar o layout do site", Prioridade.MEDIA);
        Tarefa t3 = new Tarefa("Testar funcionalidades", Prioridade.URGENTE);

        projeto.adicionarTarefa(t1);
        projeto.adicionarTarefa(t2);
        projeto.adicionarTarefa(t3);

        projeto.exibirProjeto();

    }
    
}
