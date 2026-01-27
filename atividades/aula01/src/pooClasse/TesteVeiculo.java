package aula01.poo.src.pooClasse;

public class TesteVeiculo {
    
    public static void main(String[] args) {

        //passando construtores na classe veiculo voce pode instaciar ja com atributos
        Veiculo minivan = new Veiculo("Amarelo", 2, 40, 50);
        Veiculo lambo = new Veiculo();
        
        double litros;
        int dist = 300;
        // minivan.passageiros = 7;
        // minivan.capCombustivel = 40;
        // minivan.kpl = 15;
        // minivan.cor = "Amarela";

        lambo.passageiros = 2;
        lambo.capCombustivel = 50;
        lambo.kpl = 20;
        lambo.cor = "Vermelho";

        litros = minivan.combNecessario(dist);
        System.out.println("Para percorrer a distancia " + dist+"km" 
        +  " são necessarios "+ litros +" litros.");
    }
}
