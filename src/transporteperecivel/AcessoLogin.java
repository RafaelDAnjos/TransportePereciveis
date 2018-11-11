/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package transporteperecivel;

/**
 *
 * @author 20171bsi0073
 */
public class AcessoLogin {
    String cpfLogin;
    String senhaLogin;
    
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
