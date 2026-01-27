package aula05.exercicios.ex1;

public class Main {
    
    public static void main(String[] args) {
    
    Funcionario gerente = new Gerente("Carlos", 5000);
    Funcionario dev = new Desenvolvedor("Ana", 3000);

    
    System.out.println("Bônus do " + gerente.nome + " (Gerente): R$" + String.format("%.2f", gerente.calcularBonus()));
    System.out.println("Bônus da " + dev.nome + " (Dev): R$" + String.format("%.2f", dev.calcularBonus()));
}
}
