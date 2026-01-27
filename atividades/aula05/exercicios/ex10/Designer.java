package aula05.exercicios.ex10;

public class Designer extends MembroEquipe {

    public Designer(String nome) {
        super(nome);
    }

    @Override
    public void trabalhar() {
        System.out.println(nome + " está criando o design!");
    }
}
