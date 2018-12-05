package transporteperecivel;

import conexao.BDFuncionario;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author 20171bsi0073
 */

public class AcessoLogin {
    private String cpfLogin;
    private String senhaLogin;
    
    /*public AcessoLogin(String cpf, String senha){
    cpfLogin  = cpf;
    senhaLogin = senha;
    }*/

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
     
    public String verificaLogin()
    {
        
        BDFuncionario funcionarioBD = new BDFuncionario();
        ArrayList <Funcionario> listFun = funcionarioBD.selectTable();
        System.out.println(listFun.size());
        int j = 0;
        for (int i=0; i<listFun.size(); i++)
        {
            if(this.cpfLogin.equals(listFun.get(i).getCpf()))
            {
                if(this.senhaLogin.equals(listFun.get(i).getSenha()))
                {
                    JOptionPane.showMessageDialog(null, "Acesso Autorizado\n Bem Vindo! " + listFun.get(i).getNome());
                    
                }
                else
                {
                    JOptionPane.showMessageDialog(null, "Acesso Negado!\nSenha Errada");
                    
                }
                j = 1;
                return listFun.get(i).getNome();
            }
        }
        if(j ==0)
        {
            JOptionPane.showMessageDialog(null, "Acesso Negado!\nLogin errado");
        }
    
        return null;
    }
    
    
}
