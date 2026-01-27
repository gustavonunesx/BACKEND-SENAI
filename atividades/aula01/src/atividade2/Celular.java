package aula01.poo.src.atividade2;

import java.util.Date;

public class Celular {

    String modelo;
    double preco;
    double precoParcelado;
    Date dataLancamento;
    double desconto;

    public double descontoAVista(){
        desconto = preco * 0.05;
        return preco - desconto;
    }

    public Date mostrarDataLancamento(Date dataLancamento){
        return dataLancamento;
    }

    public String mostrarModelo(String modelo){
        return "O modelo é " + modelo;
    }

    public double verPreco(double preco){
        this.preco = preco;
        return this.preco;
    }

    public double precoCartao(){
        return preco / 12;
    }


}
