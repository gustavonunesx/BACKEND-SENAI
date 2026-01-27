package entity;

public abstract class Pagamento {
    
    protected double valor;

    public Pagamento() {
    }

    public Pagamento(double valor) {
        this.valor = valor;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public abstract void processarPagamento(); 

    public void imprimirRecibo(){
        System.out.println("Valor do pagamento: " + getValor());
    }
}
