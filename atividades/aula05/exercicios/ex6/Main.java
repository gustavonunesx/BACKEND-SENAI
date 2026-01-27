package aula05.exercicios.ex6;

public class Main {
    public static void main(String[] args) {
        
        NivelPrioridade baixa = NivelPrioridade.BAIXA;
        NivelPrioridade media = NivelPrioridade.MEDIA;
        NivelPrioridade alta = NivelPrioridade.ALTA;
        NivelPrioridade urgente = NivelPrioridade.URGENTE;

        System.out.println("Prioridade " + baixa + ": " + baixa.getNivel());
        System.out.println("Prioridade " + media + ": " + media.getNivel());
        System.out.println("Prioridade " + alta + ": " + alta.getNivel());
        System.out.println("Prioridade " + urgente + ": " + urgente.getNivel());
    }

}
