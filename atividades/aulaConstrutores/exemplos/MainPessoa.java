package aulaConstrutores.exemplos;
public class MainPessoa {
    public static void main(String[] args) {
        
        Pessoa gustavo = new Pessoa(21,"Gustavo",true );
        Pessoa p1 = new Pessoa();
        Pessoa p2 = new Pessoa();

        System.out.println("Idade " + gustavo.idade);
        System.out.println("Nome " + gustavo.nome);
        System.out.println("Casado " + gustavo.casado);

        System.out.println("Idade " + p1.idade);
        System.out.println("Nome " + p1.nome);
        System.out.println("Casado " + p1.casado);

        System.out.println("Idade " + p2.idade);
        System.out.println("Nome " + p2.nome);
        System.out.println("Casado " + p2.casado);

    }
}
