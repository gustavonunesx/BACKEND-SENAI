public class Programador extends MembroEquipe{

    public Programador() {
    }

    public Programador(String nome) {
        super(nome);
    }
    
    @Override
    public void trabalhar(){
        System.out.println("Fazer Backend");
    }
    
}
