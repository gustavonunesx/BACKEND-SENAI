package heranca.exerciciosHeranca.exercicio6.entity;

public class Circulo extends Figura2D{

    private double raio;

    public Circulo(String nome, String cor, double area, double raio) {
        super(nome, cor, area);
        this.raio = raio;
    }

    public double getRaio() {
        return raio;
    }

    public void setRaio(double raio) {
        this.raio = raio;
    }

    
    
}
