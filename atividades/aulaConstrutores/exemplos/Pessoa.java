package aulaConstrutores.exemplos;
public class Pessoa {
    
    int idade;
    String nome;
    boolean casado;

    public Pessoa(){}

    public Pessoa(int idade, String nome, boolean casado){
        this.idade = idade;
        this.nome = nome;
        this.casado = casado;
    }

    public Pessoa(int idade, String nome){
        this.idade = idade;
        this.nome = nome;
        
    }


}
