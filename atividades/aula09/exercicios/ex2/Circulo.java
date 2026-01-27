package aula09.exercicios.ex2;

public class Circulo extends FormaGeometrica{

    public Circulo(){}

    public Circulo(double base, double altura, double raio){
        super(base, altura, raio);
    }


    @Override
    public void calcularArea() {
        double area = Math.PI * Math.pow(getRaio(), 2);
        System.out.printf("Area do circulo: %.2f\n", area);
    }

    
    
}
