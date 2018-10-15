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
        novofuncionario.cpf = "001";
        novofuncionario.senha = "123";
        persistencia.salvarFunc(novofuncionario);
        Funcionario novofuncionario2 = new Funcionario();
        novofuncionario2.nome = "Nicolas";
        novofuncionario2.cpf = "002";
        novofuncionario2.senha = "456";
        persistencia.salvarFunc(novofuncionario2);
        Funcionario novofuncionario3 = new Funcionario();
        novofuncionario3.nome = "Rafael";
        novofuncionario3.cpf = "003";
        novofuncionario3.senha = "789";
        persistencia.salvarFunc(novofuncionario3);
        
        Funcionario funcionario;
        for(int i = 0;i<3;i++){
          funcionario =  persistencia.listaFuncionarios.get(i);
            System.out.println(funcionario.nome);
          if(funcionario.cpf.equals(cpfLogin) == true){
              if(funcionario.senha.equals(senhaLogin)== true){
                  
                  return true;
         
              }
              
          }
     
        
        
    }
    
            return false;
}
}