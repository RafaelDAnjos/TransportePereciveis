/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package transporteperecivel;
import janelas.Login;
import java.util.ArrayList;
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
    
    public boolean verificaAcesso(){
        Persistencia persistencia = new Persistencia();
        Funcionario novofuncionario = new Funcionario();
        
        //Funcionarios para teste
        novofuncionario.nome = "Daniel";
        novofuncionario.cpf = "123";
        novofuncionario.senha = "123";
        persistencia.salvarFunc(novofuncionario);
        
        novofuncionario.nome = "Nicolas";
        novofuncionario.cpf = "456";
        novofuncionario.senha = "456";
        persistencia.salvarFunc(novofuncionario);
        
        novofuncionario.nome = "Rafael";
        novofuncionario.cpf = "789";
        novofuncionario.senha = "789";
        persistencia.salvarFunc(novofuncionario);
        
     
        
        return false;
    }
    
}
