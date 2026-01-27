package aula05.exercicios.ex1;

public class Desenvolvedor extends Funcionario{
    
    public Desenvolvedor(String nome, double salario) {
        super(nome, salario);
    }

    // Implementação do cálculo de bônus para o Desenvolvedor
    @Override
    public double calcularBonus() {
        return salario * 0.10;  // Bônus de 10%
    }
}
