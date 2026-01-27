package aula05.exercicios.ex9;

public class Computador {
    
    private Processador proc;
    private Memoria memoria;

   
    public Computador(String modeloProcessador, int capacidadeMemoria) {
        this.proc = new Processador(modeloProcessador);
        this.memoria = new Memoria(capacidadeMemoria);
    }

    // Método para exibir as informações do computador
    public void exibirDetalhes() {
        System.out.println("Computador com processador: " + proc.getModelo());
        System.out.println("Memória RAM: " + memoria.getCapacidade() + " GB");
    }

}
