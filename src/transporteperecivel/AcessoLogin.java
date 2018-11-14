package transporteperecivel;

/**
 *
 * @author 20171bsi0073
 */

public class AcessoLogin {
    private String cpfLogin;
    private String senhaLogin;
    
    public AcessoLogin(String cpf, String senha){
    cpfLogin  = cpf;
    senhaLogin = senha;
    }

    public String getCpfLogin() {
        return cpfLogin;
    }

    public void setCpfLogin(String cpfLogin) {
        this.cpfLogin = cpfLogin;
    }

    public String getSenhaLogin() {
        return senhaLogin;
    }

    public void setSenhaLogin(String senhaLogin) {
        this.senhaLogin = senhaLogin;
    }
     
    
}
