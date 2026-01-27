import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Exemplo {
    
    public static void main(String[] args) {
        
        Scanner tec = new Scanner(System.in);

        // System.out.println("Digite o valor");
        // double valor = tec.nextDouble();

        // String valorForamtado = String.format("%.2f", valor);
        // System.out.println(valorForamtado); 

        //-------------------------------
        //----------EXEMPLO REGEX--------
        //-------------------------------
        // Pattern pattern = Pattern.compile("[A-Z]{3}-[0-9]{4}");
        
        // System.out.println("Digite o codigo...");
        // String codigo = tec.nextLine();

        // Matcher matcher = pattern.matcher(codigo);

        // if (matcher.find()) {
        //     System.out.println("Formato do Codigo correto");
        // }else{
        //     System.out.println("Formato do Codigo errado");
        // }


        //-------------------------------
        //----------EXEMPLO CPF--------
        //-------------------------------
        Pattern pattern = Pattern.compile("[0-9]{3}.[0-9]{3}.[0-9]{3}-[0-9]{2}");

        System.out.println("Digite o CPF:");
        String cpf = tec.nextLine();
        
        Matcher matcher = pattern.matcher(cpf);
        
        if (matcher.find()) {
            System.out.println("CPF válido");
        }else{
            System.out.println("Invalido");
        }

        

        tec.close();

    }
}
