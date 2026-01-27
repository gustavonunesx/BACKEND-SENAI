package aula05.exercicios.ex7;

public class Main {
    public static void main(String[] args) {
        double valorEmDolar = 100.0;
        double valorEmEuro = 50.0;
        double valorEmReal = 200.0;

        System.out.println(valorEmDolar + " dólares = R$" + String.format("%.2f", Moeda.DOLAR.converterParaReais(valorEmDolar)));
        System.out.println(valorEmEuro + " euros = R$" + String.format("%.2f", Moeda.EURO.converterParaReais(valorEmEuro)));
        System.out.println(valorEmReal + " reais = R$" + String.format("%.2f", Moeda.REAL.converterParaReais(valorEmReal)));

    }

}
