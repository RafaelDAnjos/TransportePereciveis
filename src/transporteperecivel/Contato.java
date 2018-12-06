/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package transporteperecivel;

import conexao.BDContato;
import conexao.BDFuncionario;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author nicolas
 */
public class Contato {

    private String telefone;
    private int id;
    private int fkfuncionario;

    public int getFkfuncionario() {
        return fkfuncionario;
    }

    public void setFkfuncionario(int fkfuncionario) {
        this.fkfuncionario = fkfuncionario;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
    
    public void AdicionarContato()
    {
        Contato contato = new Contato();
        List<Contato> listcon;
        
        contato.setTelefone(JOptionPane.showInputDialog("Digite o contato do funcionario"));
        
        BDContato instance = new BDContato();
        
        listcon = instance.selectTable();
        
         int cpfdup = 0;
        
        for(int i = 0; i < listcon.size(); i++)
        {
            if(contato.getTelefone().equals(listcon.get(i).getTelefone()))
            {
                JOptionPane.showMessageDialog(null, "Telefone informado pertence a outro funcionario", "Telefone duplicado", 0);
                cpfdup = 1;
                break;
            }
        }
        if(cpfdup == 0)
        {
            Funcionario funcionario = new Funcionario();
            funcionario.setCpf(JOptionPane.showInputDialog("Digite o CPF do funcionario"));
            JOptionPane.showMessageDialog(null,funcionario.getCpf());
            vinculaFuncionario(funcionario);
            instance.insertTable(contato);
        }
    }
    
    public void vinculaFuncionario(Funcionario novofuncionario){
        ArrayList<Funcionario> listaFuncionarios = new ArrayList();
        BDFuncionario instance = new BDFuncionario();
        listaFuncionarios = instance.selectTable();
        
        for(int i =0;i<listaFuncionarios.size();i++){
            Funcionario funcionario = new Funcionario();
            funcionario = listaFuncionarios.get(i);
            
            if(funcionario.getCpf().equals(novofuncionario.getCpf())){
                    System.out.println("ok");
                    setFkfuncionario(funcionario.getIdfuncionario());           
            }
        }
    }

}
