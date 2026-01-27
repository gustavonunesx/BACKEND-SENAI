package polimorfismo.sobreEscrita.ex2;

public class Gato extends Animal{

    @Override
    public String fazerSom() {
        return super.fazerSom() + "miaumiau";
    }

    
    
}
