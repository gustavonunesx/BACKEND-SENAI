import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        
        Scanner tec = new Scanner(System.in);

        Desenvolvedor dev = new Desenvolvedor();
        System.out.println("Digite o salario do desenvolvedor");
        double salarioDev = tec.nextDouble();
        dev.setSalario(salarioDev);
        
        Gerente gerente = new Gerente();
        System.out.println("Digite o salario do Gerente");
        double salarioGerente = tec.nextDouble();
        gerente.setSalario(salarioGerente);

        dev.calcularBonus();
        gerente.calcularBonus();
        


        tec.close();
    }
}
