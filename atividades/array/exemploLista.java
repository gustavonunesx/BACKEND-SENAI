package array;

import java.util.ArrayList;

public class exemploLista {

    public static void main(String[] args) {
        
        ArrayList<String> nomes = new ArrayList<>();

        nomes.add("Gustavo");
        nomes.add("Ferreira");
        nomes.add("Nunes");
        System.out.println(nomes);

        System.out.println(nomes.get(2));


        if(nomes.remove("Nune"))
            System.out.println("Item removido!");
        else
            System.out.println("Nao Encontrado!");

        //varre os itens da lista 1 a 1
        for(String n : nomes)
            System.out.println(n);
        
        



    }
    
    



}
