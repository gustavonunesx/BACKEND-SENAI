package aula05.exercicios.ex4;

public class CartaoCredito implements Pagavel  {
    
    String numeroCartao;

    public CartaoCredito(String numeroCartao) {
        this.numeroCartao = numeroCartao;
    }

    @Override
    public void pagar() {
        System.out.println("Pagamento do cartão de crédito realizado com o número: " + numeroCartao);
    }


}
