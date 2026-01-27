package entity;

public class PagamentoPix extends Pagamento{
    
    public String contaBancaria;

    public PagamentoPix(){}


    public PagamentoPix(double valor, String contaBancaria) {
        super(valor);
        this.contaBancaria = contaBancaria;
    }


    public String getContaBancaria() {
        return contaBancaria;
    }

    public void setContaBancaria(String contaBancaria) {
        this.contaBancaria = contaBancaria;
    }

    
    @Override
    public void processarPagamento(){
        System.out.println("Pagamento efetuado via Pinx");
    }
}
