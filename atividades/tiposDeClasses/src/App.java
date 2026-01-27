import entity.PagamentoCartao;
import entity.PagamentoPix;

public class App {
    public static void main(String[] args) throws Exception {
     
        PagamentoCartao pagamentoCartao = new PagamentoCartao(1255.22, "3423412416");
        PagamentoPix pagamentoPix = new PagamentoPix(332.76, "43523-6622");

        pagamentoCartao.processarPagamento();
        pagamentoPix.processarPagamento();
        pagamentoCartao.imprimirRecibo();
        pagamentoPix.imprimirRecibo();
        
    }
}
