package heranca.exerciciosHeranca.exercicio6.entity;

public class Figura2D extends FiguraGeometrica{

    private double area; 

    
    public Figura2D(){}

    public Figura2D(String nome, String cor, double area) {
        super(nome, cor);
        this.area = area;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

  

    
    
    
}
