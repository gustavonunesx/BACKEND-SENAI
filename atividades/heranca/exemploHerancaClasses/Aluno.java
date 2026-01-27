package heranca.exemploHerancaClasses;

public class Aluno extends Pessoa{

    private String identificacao;
    private int anoLetivo;
    private int nmrDiciplinas;
    public String getIdentificacao() {
        return identificacao;
    }

    public void setIdentificacao(String identificacao) {
        this.identificacao = identificacao;
    }

    public int getAnoLetivo() {
        return anoLetivo;
    }

    public void setAnoLetivo(int anoLetivo) {
        this.anoLetivo = anoLetivo;
    }

    public int getNmrDiciplinas() {
        return nmrDiciplinas;
    }

    public void setNmrDiciplinas(int nmrDiciplinas) {
        this.nmrDiciplinas = nmrDiciplinas;
    }

    

    
    
}
