package aula01.poo.src.atividade2;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class TesteCelular {

    public static void main(String[] args) throws ParseException {

        Celular cel = new Celular();
        Scanner tec = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date dataLancamento = sdf.parse("2019-12-02");

        System.out.println(cel.mostrarModelo("M32"));
        System.out.println("Custando " + cel.verPreco(999.90));
        System.out.println("Lançado em : " + cel.mostrarDataLancamento(dataLancamento));

        System.out.println("Pagamento a vista? (Y/N)");
        String resposta = tec.nextLine();

        if (resposta.equals("Y")){
            System.out.println("Desconto aplicado!\n" + "Total: " + cel.descontoAVista() + "R$");
        }else {
            System.out.println("Preço em 12x: " + cel.precoCartao());
        }


        tec.close();

    }
}
