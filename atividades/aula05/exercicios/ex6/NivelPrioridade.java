package aula05.exercicios.ex6;

public enum NivelPrioridade  {
    
    BAIXA(1),
    MEDIA(2),
    ALTA(3),
    URGENTE(4);

    private int nivel;

    NivelPrioridade(int nivel) {
        this.nivel = nivel;
    }

    public int getNivel() {
        return nivel;
    }
}
