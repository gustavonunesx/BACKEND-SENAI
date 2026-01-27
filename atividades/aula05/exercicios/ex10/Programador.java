package aula05.exercicios.ex10;

public class Programador extends MembroEquipe{
    
    public Programador(String nome) {
        super(nome);
    }

    @Override
    public void trabalhar() {
        System.out.println(nome + " está programando!");
    }
}
