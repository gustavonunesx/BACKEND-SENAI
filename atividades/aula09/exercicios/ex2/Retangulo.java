package aula09.exercicios.ex2;

public class Retangulo extends FormaGeometrica{

    public Retangulo(){}

    @Override
    public void calcularArea() {
       double area = getBase() * getAltura() / 2;
       System.out.println("Base do retangulo é: " + area);
        
    }
    
    
}
