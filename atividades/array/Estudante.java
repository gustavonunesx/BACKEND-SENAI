package array;

import java.util.ArrayList;

public class Estudante {

    String nome;
    ArrayList<Integer> notas;

    public Estudante() {
    }

    public Estudante(String nome, ArrayList<Integer> notas) {
        this.nome = nome;
        this.notas = notas;
    }

    public String getNome() {
        return nome;
    }

    public void adicionarNota(int nota){
        notas.add(nota);
    }

    public double calcularMedia(){

        if (notas.isEmpty())    
             return 0.0;
             
        double soma = 0.0;
        for(double n : notas){
            soma += n;
        }
        return soma / notas.size();
    }

    
    

    

    


    
}
