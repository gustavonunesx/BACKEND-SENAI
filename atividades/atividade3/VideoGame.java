package atividade3;

public class VideoGame {

    private String titulo;
    private String plataforma;
    private String genero;
    private String classificacao;
    private String ano;
    private String modoDeJogo;
    private boolean crossPlay;



    public VideoGame(String titulo, String plataforma, String genero, String classificacao, String ano,
            String modoDeJogo, boolean crossPlay) {
        this.titulo = titulo;
        this.plataforma = plataforma;
        this.genero = genero;
        this.classificacao = classificacao;
        this.ano = ano;
        this.modoDeJogo = modoDeJogo;
        this.crossPlay = crossPlay;
    }



    public String getTitulo() {
        return titulo;
    }



    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }



    public String getPlataforma() {
        return plataforma;
    }



    public void setPlataforma(String plataforma) {
        this.plataforma = plataforma;
    }



    public String getGenero() {
        return genero;
    }



    public void setGenero(String genero) {
        this.genero = genero;
    }



    public String getClassificacao() {
        return classificacao;
    }



    public void setClassificacao(String classificacao) {
        this.classificacao = classificacao;
    }



    public String getAno() {
        return ano;
    }



    public void setAno(String ano) {
        this.ano = ano;
    }



    public String getModoDeJogo() {
        return modoDeJogo;
    }



    public void setModoDeJogo(String modoDeJogo) {
        this.modoDeJogo = modoDeJogo;
    }



    public boolean isCrossPlay() {
        return crossPlay;
    }



    public void setCrossPlay(boolean crossPlay) {
        this.crossPlay = crossPlay;
    }


    

    


}