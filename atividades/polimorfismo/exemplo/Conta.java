package polimorfismo.exemplo;

public class Conta {

    private int numero;
    protected double saldo;
    private String titular;

    public Conta() {
    }

    public Conta(int numero, double saldo, String titular) {
        this.numero = numero;
        this.saldo = saldo;
        this.titular = titular;
    }

    public int getNumero() {
        return numero;
    }
    public void setNumero(int numero) {
        this.numero = numero;
    }
    public double getSaldo() {
        return saldo;
    }
    
    public String getTitular() {
        return titular;
    }
    public void setTitular(String titular) {
        this.titular = titular;
    }

    public void depositar(double valor){
        if(valor < 0){
            saldo += valor;
        }
    }

    public void sacar(double valor){
        if (saldo >= valor) {
            saldo -= valor + 5;    
        }
        
    }
    
    
    
    
}
