package aula09.exercicios.ex2;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        
        Scanner tec = new Scanner(System.in);

        Circulo circulo = new Circulo();
        System.out.println("Digite o raio da circuferencia...");
        double raio = tec.nextDouble();
        circulo.setRaio(raio);
        System.out.println();
        circulo.calcularArea();
        
        Retangulo retangulo = new Retangulo();
        System.out.println("Digite a BASE do retangulo...");
        double base = tec.nextDouble();
        retangulo.setBase(base);
        
        System.out.println("Digite a ALTURA do retangulo...");
        double altura = tec.nextDouble();
        retangulo.setAltura(altura);
        retangulo.calcularArea();
        
        

    }
}
