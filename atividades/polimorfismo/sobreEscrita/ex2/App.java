package polimorfismo.sobreEscrita.ex2;

public class App {
    public static void main(String[] args) {
        
        Animal animal = new Animal();
        Cachorro dog = new Cachorro();

        animal.fazerSom();
        dog.fazerSom();
    }
}
