import java.util.Scanner;

public class MainConta {
    public static void main(String[] args) {
        

        Conta conta1 = new Conta(3306, 4000, 30000);

        Scanner tec = new Scanner(System.in);

        System.out.println("Selecione uma opção:");
        System.out.println("1- Deposito");
        System.out.println("2- Consultar saldo");
        System.out.println("3- Sacar");
        System.out.println("4- Consultar uso cheque especial");
        int nmrSelecionado = tec.nextInt();

        switch( nmrSelecionado) {
            case 1:
                System.out.println("Insira o numero da conta: ");
                int numeroConta = tec.nextInt();

                if (numeroConta == conta1.getNumero()) {
                    System.out.println("Insira a quantidade a depositar:");
                    int qtdDeposito = tec.nextInt();

                    int saldoAtual = conta1.getSaldo() + qtdDeposito;
                    System.out.println("Depositado com sucesso!\nSaldo atual: " + saldoAtual);
                }else{
                    System.out.println("Numero conta errado! Tchau!");
                }
                break;

            case 2:
                System.out.println();






        
            default:
                break;
        }





        tec.close();


    }
}
