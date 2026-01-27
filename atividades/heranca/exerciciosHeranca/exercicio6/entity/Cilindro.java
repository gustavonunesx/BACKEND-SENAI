package heranca.exerciciosHeranca.exercicio6.entity;

public class Cilindro extends Figura3D {

    private String tamanho;



    
    public Cilindro(String tamanho) {
        this.tamanho = tamanho;
    
    }

    public String getTamanho() {
        return tamanho;
    }

    public void setTamanho(String tamanho) {
        this.tamanho = tamanho;
    }

    @Override
    public String getCor() {
        
        return super.getCor();
    }

    @Override
    public String getNome() {
        
        return super.getNome();
    }

    @Override
    public void setCor(String cor) {
        
        super.setCor(cor);
    }

    @Override
    public void setNome(String nome) {
        
        super.setNome(nome);
    }

    
     
}
