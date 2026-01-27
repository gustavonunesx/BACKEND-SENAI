package aula05.exercicios.ex3;

public class Foto implements Imprimir{
    
    String descricao;

    public Foto(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public void imprimir() {
        System.out.println("Imprimindo a foto: " + descricao);
    }

}
