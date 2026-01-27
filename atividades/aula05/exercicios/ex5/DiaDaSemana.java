package aula05.exercicios.ex5;

public enum DiaDaSemana {

    SEGUNDA("Segunda-feira: Começo da semana"),
    TERCA("Terça-feira"),
    QUARTA("Quarta-feira"),
    QUINTA("Quinta-feira"),
    SEXTA("Sexta-feira"),
    SABADO("Sábado: Fim de semana!"),
    DOMINGO("Domingo");

    private DiaDaSemana(String mensagem) {
        this.mensagem = mensagem;
    }

    private String mensagem;

    public void imprimirMensagem() {
        System.out.println(mensagem);
    }

}
