package aula05.exercicios.ex8;

public class Carro {
    
    private String modelo;
    private Motor motor; 

    public Carro(String modelo, int potenciaMotor) {
        this.modelo = modelo;
        this.motor = new Motor(potenciaMotor); 
    }

    public void exibirPotenciaMotor() {
        System.out.println("O carro " + modelo + " tem um motor com " + motor.getPotencia() + " cavalos de potência.");
    }

}
