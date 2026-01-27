package aula05.exercicios.ex10;

public enum Prioridade {
    
    BAIXA(1),
    MEDIA(2),
    ALTA(3),
    URGENTE(4);

    private final int valor;

    Prioridade(int valor) {
        this.valor = valor;
    }

    public int getValor() {
        return valor;
    }
}
