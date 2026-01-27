public class Conta {
    
    private int numero;
    private int saldo;
    private int chequeEspecial;


    public Conta(){}

    public Conta(int numero, int saldo, int chequeEspecial) {
        this.numero = numero;
        this.saldo = saldo;
        this.chequeEspecial = chequeEspecial;
    }

    // String depositar(double valor){
    //     if(valor >= 0){
    //         saldo += valor;
    //         return "deposito feito com sucesso";
    //     }
    // }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public int getSaldo() {
        return saldo;
    }

    public void setSaldo(int saldo) {
        this.saldo = saldo;
    }

    public int getChequeEspecial() {
        return chequeEspecial;
    }

    public void setChequeEspecial(int chequeEspecial) {
        this.chequeEspecial = chequeEspecial;
    }

    

    



}
