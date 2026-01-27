package aula05.exercicios.ex2;

public class Circulo extends FormaGeometrica{
    
    double raio;

    public Circulo(double r) {
        this.raio = r;
    }

    @Override
    public double calcularArea() {
        return Math.PI * raio * raio;
    }
}
