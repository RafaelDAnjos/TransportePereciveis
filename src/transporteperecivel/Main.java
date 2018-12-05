package transporteperecivel;

import conexao.BDBairro;
import conexao.BDEndereco;
import conexao.BDConnection;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class Main {

    public static void main(String[] args) {
        
        Funcionario funcionario = new Funcionario();
        
        AcessoLogin acesso = new AcessoLogin();
        
        while(true)
        {
            acesso.setCpfLogin(JOptionPane.showInputDialog("Entre com o CPF"));
            acesso.setSenhaLogin(JOptionPane.showInputDialog("Entre com a senha"));
            funcionario.setNome(acesso.verificaLogin());
            if(!(funcionario.getNome() == null))
            {
                funcionario.setCpf(acesso.getCpfLogin());
                funcionario.setSenha(acesso.getSenhaLogin());
                break;
            }
        }
        
        while (true)
            {
             int i = Integer.parseInt(JOptionPane.showInputDialog("Digite 1 para pesquisar Produto\n"
                     + "digite 2 para registrar Pedido\n"
                     + "digite 3 para Clientes\n"
                     + "digite 4 para Calendario de entrega\n"
                     + "digite 5 para Alterar Estoque\n"
                     + "digite 6 para sair\n"));
            }
    }
}