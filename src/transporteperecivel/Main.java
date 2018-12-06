package transporteperecivel;

import conexao.BDPedido;
import conexao.BDCliente;
import conexao.BDFuncionario;

import conexao.BDConnection;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class Main {

    public static void main(String[] args) {
        
        
        
        
        
        
        /*
        //Teste cadastraPedido
        
        BDConnection conexao = new BDConnection();
        
        BDCliente clienteBD = new BDCliente();
        List<Cliente> clientes = clienteBD.selectTable();
        
        BDFuncionario funcionarioBD = new BDFuncionario();
        List<Funcionario> funcionarios = funcionarioBD.selectTable();
        
        Pedido pedido = new Pedido();
        
        pedido.cadastraPedido(funcionarios.get(0), clientes.get(0));
        */
        

        /*
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
        */
    }
}