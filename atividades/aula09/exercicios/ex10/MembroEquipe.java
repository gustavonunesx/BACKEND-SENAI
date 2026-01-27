public abstract class MembroEquipe {

    private String nome;

    public MembroEquipe() {
    }

    public MembroEquipe(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public abstract void trabalhar();

    
}
