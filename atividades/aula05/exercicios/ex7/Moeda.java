package aula05.exercicios.ex7;

public enum Moeda {

    REAL(1.0),
    DOLAR(5.50),
    EURO(6.00);

    private double taxaCambio;

    Moeda(double taxaCambio) {
        this.taxaCambio = taxaCambio;
    }

    public double getTaxaCambio() {
        return taxaCambio;
    }

    public double converterParaReais(double valor) {
        return valor * taxaCambio;
    }
}
