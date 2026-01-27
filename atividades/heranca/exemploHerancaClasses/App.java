package heranca.exemploHerancaClasses;

public class App {

    public static void main(String[] args) {
        
        Professor prof = new Professor();
        Pessoa pessoa = new Pessoa();
        Aluno aluno = new Aluno();

        pessoa.setNome("Gustavo");
        prof.setNome("Andre");
        aluno.setNome("Vagabo");

        System.out.println(pessoa.getNome());
        System.out.println(prof.getNome());
        System.out.println(aluno.getNome());
        
    }
    
}
