public class Gerente extends Funcionario {

    public Gerente() {
    }

    public Gerente(String nome, double salario) {
        super(nome, salario);
    }

    @Override
    public void calcularBonus() {
        double bonus = getSalario() * 0.3;
        System.out.println("Bonus aplicado de " + bonus + "$ dólares");
    }



    
    
    
}
