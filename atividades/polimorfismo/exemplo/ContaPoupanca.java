package polimorfismo.exemplo;

public class ContaPoupanca extends Conta{

    private double taxaDeJuros;

    public ContaPoupanca() {
    }

    public ContaPoupanca(int numero, double saldo, String titular, double taxaDeJuros) {
        super(numero, saldo, titular);
        this.taxaDeJuros = taxaDeJuros;
    }

    public void atualziarSaldo(){
        saldo += saldo * taxaDeJuros;
    }

    @Override
    public void sacar(double valor) {
        if (saldo >= valor) {
            saldo -= valor;    
        }
    }

    
    

    


    

    
    
}
