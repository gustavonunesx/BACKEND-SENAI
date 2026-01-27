package aula09.exercicios.ex2;

public abstract class FormaGeometrica {
    
    private double base;
    private double altura;
    private double raio;

    public FormaGeometrica() {
    }

    public FormaGeometrica(double base, double altura, double raio) {
        this.base = base;
        this.altura = altura;
        this.raio = raio;
    }

    public double getBase() {
        return base;
    }

    public void setBase(double base) {
        this.base = base;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    public double getRaio() {
        return raio;
    }

    public void setRaio(double raio) {
        this.raio = raio;
    }

    public abstract void calcularArea();
    
    
}
