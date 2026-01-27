package polimorfismo.exemplo;

public class ContaEmpresa extends Conta{
    
    private double limiteDeEmprestimo;


    public ContaEmpresa(){}

    public ContaEmpresa(int numero, double saldo, String titular, double limiteDeEmprestimo) {
        super(numero, saldo, titular);
        this.limiteDeEmprestimo = limiteDeEmprestimo;
    }

    public double getLimiteDeEmprestimo() {
        return limiteDeEmprestimo;
    }

    public void setLimiteDeEmprestimo(double limiteDeEmprestimo) {
        this.limiteDeEmprestimo = limiteDeEmprestimo;
    }
    
    public void emprestar(double valor){
        if(valor <= limiteDeEmprestimo){
            depositar(valor);
        }
    }

    @Override
    public void sacar(double valor) {
        super.sacar(valor - 2);

    }

    
}
