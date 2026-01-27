package polimorfismo.sobreEscrita.ex2;

public class Cachorro extends Animal{

    @Override
    public String fazerSom() {
        return super.fazerSom() + "auauau";
    }
    
    
}
