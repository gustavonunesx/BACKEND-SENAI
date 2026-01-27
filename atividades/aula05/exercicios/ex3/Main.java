package aula05.exercicios.ex3;

public class Main {
    
    public static void main(String[] args) {

        Documento doc = new Documento("Relatório de Vendas");
        Foto foto = new Foto("Paisagem do campo");
        Impressora impressora = new Impressora();

        impressora.imprimirArquivo(doc);
        impressora.imprimirArquivo(foto);

    }
}
