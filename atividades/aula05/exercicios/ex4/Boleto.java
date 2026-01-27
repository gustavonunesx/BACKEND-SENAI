package aula05.exercicios.ex4;

public class Boleto implements Pagavel{
    
    String codigoBarras;

    public Boleto(String codigoBarras) {
        this.codigoBarras = codigoBarras;
    }

    @Override
    public void pagar() {
        System.out.println("Pagamento do boleto realizado com o código de barras: " + codigoBarras);
    }

}
