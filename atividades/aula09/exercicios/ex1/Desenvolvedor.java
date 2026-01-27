public class Desenvolvedor extends Funcionario{

    public Desenvolvedor(){}

    public Desenvolvedor(String nome, double salario) {
        super(nome, salario);
    }

    @Override
    public void calcularBonus() {
        double bonus = getSalario() * 0.45;
        System.out.println("Gerente terá " + bonus + "$" + " dólares de bonus");
        
    }

    
    


    
}
