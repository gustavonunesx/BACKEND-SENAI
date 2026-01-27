package aula05.exercicios.ex1;

public abstract class Funcionario {
    
    String nome;
    double salario;

   
    public Funcionario(String nome, double salario) {
        this.nome = nome;
        this.salario = salario;
    }

    
    public abstract double calcularBonus();

}
