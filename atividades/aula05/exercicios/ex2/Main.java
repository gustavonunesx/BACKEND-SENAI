package aula05.exercicios.ex2;

public class Main {
    
    public static void main(String[] args) {        
        
        FormaGeometrica circ = new Circulo(5);
        FormaGeometrica ret = new Retangulo(4, 3);

        
        System.out.println("Área do círculo: " + String.format("%.2f", circ.calcularArea()));
        System.out.println("Área do retângulo: " + String.format("%.2f", ret.calcularArea()));
    
    }
}
