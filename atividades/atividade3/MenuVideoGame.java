package atividade3;

import java.util.Scanner;

public class MenuVideoGame {
    public static void main(String[] args) {
        
        Scanner tec = new Scanner(System.in);

        VideoGame videoGame = new VideoGame("Raibow Six", "Multiplataforma", "FPS", "+16","2015","Estratégia",true );

        VideoGame videoGame1 = new VideoGame("Call of Duty: Modern Warfare", "Multiplataforma", "FPS", "+18", "2019", "Multiplayer", true);

        VideoGame videoGame2 = new VideoGame("The Legend of Zelda: Breath of the Wild", "Nintendo Switch", "Aventura", "Livre", "2017", "Singleplayer", false);

        VideoGame videoGame3 = new VideoGame("Fortnite", "Multiplataforma", "Battle Royale", "+12", "2017", "Multiplayer", true);

        VideoGame videoGame4 = new VideoGame("God of War Ragnarok", "PlayStation", "Ação", "+18", "2022", "Singleplayer", false);

        
        boolean voltar = true;

        while (voltar) {
            System.out.println("-------MENU DE JOGOS:---------");
            System.out.println();
            System.out.println("Digite um numero para visualizar os detalhes:");

            System.out.println("\n1- Raibow Six");
            System.out.println("2- Call of Duty: Modern Warfare");
            System.out.println("3- The Legend of Zelda");
            System.out.println("4- Fortnite");
            System.out.println("5- God of War Ragnarok");
            
            int opcao = tec.nextInt();
            System.out.println();
            

            switch (opcao) {
                case 1:

                    System.out.println("Jogo: " + videoGame.getTitulo() +
                                    "\nPlataforma: " + videoGame.getPlataforma() +
                                    "\nGênero: " + videoGame.getGenero() + 
                                    "\nClassificação: " + videoGame.getClassificacao() +
                                    "\nAno de Lançamento: " + videoGame.getAno() +
                                    "\nModo de Jogo: " + videoGame.getModoDeJogo()+
                                    "\nTem Crossplay: " + videoGame.isCrossPlay()+
                                    "\n\nDeseja visualizar outro jogo? (S/N?)");

                    String resposta = tec.next();

                    if (!resposta.equalsIgnoreCase("S")) {
                        voltar = false;
                    }
                    break;


                case 2:

                    System.out.println("Jogo: " + videoGame1.getTitulo() +
                                    "\nPlataforma: " + videoGame1.getPlataforma() +
                                    "\nGênero: " + videoGame1.getGenero() + 
                                    "\nClassificação: " + videoGame1.getClassificacao() +
                                    "\nAno de Lançamento: " + videoGame1.getAno() +
                                    "\nModo de Jogo: " + videoGame1.getModoDeJogo()+
                                    "\nTem Crossplay: " + videoGame1.isCrossPlay()+
                                    "\n\nDeseja visualizar outro jogo? (S/N?)");

                    resposta = tec.next();

                    if (!resposta.equalsIgnoreCase("S")) {
                        voltar = false;
                    }
                    break;


                case 3:

                    System.out.println("Jogo: " + videoGame2.getTitulo() +
                                    "\nPlataforma: " + videoGame2.getPlataforma() +
                                    "\nGênero: " + videoGame2.getGenero() + 
                                    "\nClassificação: " + videoGame2.getClassificacao() +
                                    "\nAno de Lançamento: " + videoGame2.getAno() +
                                    "\nModo de Jogo: " + videoGame2.getModoDeJogo()+
                                    "\nTem Crossplay: " + videoGame2.isCrossPlay()+
                                    "\n\nDeseja visualizar outro jogo? (S/N?)");

                        resposta = tec.next();
                        if (!resposta.equalsIgnoreCase("S")) {
                        voltar = false;
                    }
                    break;


                case 4:

                    System.out.println("Jogo: " + videoGame3.getTitulo() +
                                    "\nPlataforma: " + videoGame3.getPlataforma() +
                                    "\nGênero: " + videoGame3.getGenero() + 
                                    "\nClassificação: " + videoGame3.getClassificacao() +
                                    "\nAno de Lançamento: " + videoGame3.getAno() +
                                    "\nModo de Jogo: " + videoGame3.getModoDeJogo()+
                                    "\nTem Crossplay: " + videoGame3.isCrossPlay()+
                                    "\n\nDeseja visualizar outro jogo? (S/N?)");

                        resposta = tec.next();
                        if (!resposta.equalsIgnoreCase("S")) {
                        voltar = false;
                    }
                    break;


                case 5:

                    System.out.println("Jogo: " + videoGame4.getTitulo() +
                                    "\nPlataforma: " + videoGame4.getPlataforma() +
                                    "\nGênero: " + videoGame4.getGenero() + 
                                    "\nClassificação: " + videoGame4.getClassificacao() +
                                    "\nAno de Lançamento: " + videoGame4.getAno() +
                                    "\nModo de Jogo: " + videoGame4.getModoDeJogo()+
                                    "\nTem Crossplay: " + videoGame4.isCrossPlay()+
                                    "\n\nDeseja visualizar outro jogo? (S/N?)");

                        resposta = tec.next();
                        if (!resposta.equalsIgnoreCase("S")) {
                        voltar = false;
                    }
                    break;
            
                default:
                    System.out.println("Selecione um número válido");
                    break;
            }
        }
        
      tec.close();
    }

}
