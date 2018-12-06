package transporteperecivel;

import conexao.BDFuncionario;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;


/**
 *
 * @author rafaelda
 */

public class Funcionario {
    private String nome;
    private String cpf;
    private String senha;
    private String cargaHoraria;
    private int idfuncionario;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getCargaHoraria() {
        return cargaHoraria;
    }

    public void setCargaHoraria(String cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }

    public int getIdfuncionario() {
        return idfuncionario;
    }

    public void setIdfuncionario(int id) {
        this.idfuncionario = id;
    }
    
    public void Cadastrafuncionario()
    {
        Funcionario funcionario = new Funcionario();
        List<Funcionario> listfun;
        
        //Preencher campos
        funcionario.setNome(JOptionPane.showInputDialog("Digite o nome do funcionario"));
        funcionario.setCpf(JOptionPane.showInputDialog("Digite o CPF do funcionario"));
        funcionario.setSenha(JOptionPane.showInputDialog("Digite a senha do funcionario"));
        funcionario.setCargaHoraria(JOptionPane.showInputDialog("Digite a carga horaria"));
        
        BDFuncionario instance = new BDFuncionario();
        
        listfun = instance.selectTable();
        
        int cpfdup = 0;
        
        for(int i = 0; i < listfun.size(); i++)
        {
            if(funcionario.getCpf().equals(listfun.get(i).getCpf()))
            {
                JOptionPane.showMessageDialog(null, "CPF informado pertence a outro funcionario", "CPF duplicado", 0);
                cpfdup = 1;
                break;
            }
        }
        if(cpfdup == 0)
        {
            instance.insertTable(funcionario);
        }
        
    }
    
    public void AlterarFuncionario()
    {
        Funcionario funcionario = new Funcionario();
        List<Funcionario> listfun;
        
        BDFuncionario instance = new BDFuncionario();
        
        listfun = instance.selectTable();
        
        int idFun = 0;
        
        String msg = "";
        
        funcionario.ListaFuncionario();
        
        funcionario.setCpf(JOptionPane.showInputDialog("Informe o CPF do funcionario"));
        
        for(int i = 0; i < listfun.size(); i++)
        {
            if(funcionario.getCpf().equals(listfun.get(i).getCpf()))
            {
                JOptionPane.showMessageDialog(null, "CPF encontrado");
                funcionario.setIdfuncionario(listfun.get(i).getIdfuncionario());
                funcionario.setNome(JOptionPane.showInputDialog(null, "Nome: " + listfun.get(i).getNome() + "\n Entre com o novo nome", "Alterar nome", 1));
                funcionario.setCpf(JOptionPane.showInputDialog(null, "CPF: " + listfun.get(i).getCpf() + "\n Entre com o novo CPF", "Alterar CPF", 1));
                funcionario.setSenha(JOptionPane.showInputDialog(null," Entre com o novo Senha ", "Alterar Senha", 1));
                funcionario.setCargaHoraria(JOptionPane.showInputDialog(null, "Carga Horaria: " + listfun.get(i).getCargaHoraria() + "\n Entre com a nova Carga Horaria", "Alterar Carga horaria", 1));
                idFun = 1;
                instance.updateTable(funcionario);
                break;
            }
        }
        
        if(idFun == 0)
        {
            JOptionPane.showMessageDialog(null, "Funcionario não encontrado", "Funcionario não encontrado", 0);
        }
        
        
    }
    
    public void DeleteFuncionario()
    {
        Funcionario funcionario = new Funcionario();
        List<Funcionario> listfun;
        
        BDFuncionario instance = new BDFuncionario();
        
        listfun = instance.selectTable();
        
        int idFun = 0;
        
        funcionario.ListaFuncionario();
        
        funcionario.setCpf(JOptionPane.showInputDialog("Informe o CPF do funcionario"));
        
        for(int i = 0; i < listfun.size(); i++)
        {
            if(funcionario.getCpf().equals(listfun.get(i).getCpf()))
            {
                JOptionPane.showMessageDialog(null, "Funcionario deletado com sucesso");
                idFun = 1;
                instance.deleteTable(listfun.get(i).getIdfuncionario());
                break;
            }
        }
        
        if(idFun == 0)
        {
            JOptionPane.showMessageDialog(null, "Funcionario não encontrado", "Funcionario não encontrado", 0);
        }
    }
    
    public void ListaFuncionario()
    {
        List<Funcionario> listfun;
        
        BDFuncionario instance = new BDFuncionario();
        
        listfun = instance.selectTable();
        String msg = "";
        
        for(int i = 0; i < listfun.size(); i++)
        {
            msg = msg + "Nome: " + listfun.get(i).getNome() + " CPF: " + listfun.get(i).getCpf() + " Carga Horaria: " + listfun.get(i).getCargaHoraria() + "\n";
        }
        
        JOptionPane.showMessageDialog(null, msg, "Funcionarios", 1);
    }
    
}
