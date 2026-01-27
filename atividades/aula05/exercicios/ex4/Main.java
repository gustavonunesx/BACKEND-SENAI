package aula05.exercicios.ex4;

public class Main {
    public static void main(String[] args) {
        
        Boleto boleto = new Boleto("12345678901234567890");
        CartaoCredito cartao = new CartaoCredito("1111-2222-3333-4444");
        SistemaPagamento sistema = new SistemaPagamento();

        sistema.processarPagamento(boleto);
        sistema.processarPagamento(cartao);
    

    }

}
