package aula05.exercicios.ex3;

public class Documento implements Imprimir{
    
    String nome;

    public Documento(String nome) {
        this.nome = nome;
    }

    @Override
    public void imprimir() {
        System.out.println("Imprimindo o documento: " + nome);
    }

}
