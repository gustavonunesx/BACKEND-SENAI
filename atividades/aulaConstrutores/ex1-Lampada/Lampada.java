public class Lampada {
    
    private boolean status;
    private int tensao;
    private String tipo;

    public Lampada(){}

    

    public Lampada(boolean status, int tensao, String tipo) {
        this.status = status;
        this.tensao = tensao;
        this.tipo = tipo;
    }



    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public int getTensao() {
        return tensao;
    }

    public void setTensao(int tensao) {
        this.tensao = tensao;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

  
    



}
