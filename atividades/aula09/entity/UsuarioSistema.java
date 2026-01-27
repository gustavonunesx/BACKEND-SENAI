public class UsuarioSistema implements Autentica, Autoriza{

    @Override
    public boolean verificarPermissao(String acao) {
       if(acao.equals("Entrar")){
        System.out.println("Logado com sucesso");
        return true;
       }else{
        return false;
       }
    }

    @Override
    public boolean autenticar(String usuario, String senha) {
        
        if(usuario.equals("admin") && (senha.equals("123"))){
            return true;
        }else{
            return false;
        }
    }


    
}
