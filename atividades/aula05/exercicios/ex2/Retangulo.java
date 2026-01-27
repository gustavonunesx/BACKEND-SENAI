package aula05.exercicios.ex2;

public class Retangulo extends FormaGeometrica {
    
    double larg, alt;

    public Retangulo(double l, double a) {
        this.larg = l;
        this.alt = a;
    }

    @Override
    public double calcularArea() {
        return larg * alt;
    }

}
