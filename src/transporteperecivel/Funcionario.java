package transporteperecivel;

import conexao.BDFuncionario;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
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
    
    public void relatorioEntrega() {
        ArrayList<Pedido> pedidos = new ArrayList();
        ArrayList<Cliente> clientes = new ArrayList();
        Connection c = null;
        Statement stmt = null;
        try {
            Class.forName("org.postgresql.Driver");
            c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/transportePereciveis", "postgres", "123456");
            //c.setAutoCommit(false);
            stmt = c.createStatement();
            
            ResultSet rs = stmt.executeQuery(" select cliente.id,nomeficticio,dataentrega,numerobandas from cliente inner join _pedido on(cliente.id = _pedido.id);");
            while (rs.next()) {
                Pedido pedido = new Pedido();
                Cliente cliente = new Cliente();
                
                cliente.setId(rs.getInt("id"));
                cliente.setNomeFicticio(rs.getString("nomeficticio"));
                
                pedido.setDataDeEntrega(rs.getString("dataentrega"));
                pedido.setNumeroBandas(rs.getInt("numerobandas"));
                
                clientes.add(cliente);
                pedidos.add(pedido);
            }
            rs.close();
            stmt.close();
            c.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }
        for (int i = 0; i < clientes.size(); i++) {
            System.out.println("ID: " + clientes.get(i).getId() + " Nome: " + clientes.get(i).getNomeFicticio() + " Data Entrega: " + pedidos.get(i).getDataDeEntrega() + " Número Bandas: " + pedidos.get(i).getNumeroBandas());
        }
        
    }
    
    public void relatorioTipoVeiculo(String modelo) {
        List<Automovel> automoveis = new ArrayList();
        Connection c = null;
        Statement stmt = null;
        try {
            Class.forName("org.postgresql.Driver");
            c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/transportePereciveis", "postgres", "123456");
            //c.setAutoCommit(false);
            stmt = c.createStatement();
            
            ResultSet rs = stmt.executeQuery("select * from automovel where modelo = '" + modelo + "';");
            while (rs.next()) {
                Automovel automovel = new Automovel();
                automovel.setPlaca(rs.getString("placa"));
                automovel.setIsrefrigerado(rs.getBoolean("isrefrigerado"));
                automovel.setCarga_maxima(rs.getFloat("carga_maxima"));
                automovel.setModelo(rs.getString("modelo"));
                automovel.setFk_cidade_id(rs.getInt("fk_cidade_id"));
                automovel.setFk_funcionario_idfuncionario(rs.getInt("fk_funcionario_idFuncionario"));
                automovel.setId(rs.getInt("id"));
                
                automoveis.add(automovel);
                
            }
            rs.close();
            stmt.close();
            c.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }
        for (int i = 0; i < automoveis.size(); i++) {
            System.out.println("Placa: " + automoveis.get(i).getPlaca()
                    + " Refrigerado: " + automoveis.get(i).getIsrefrigerado()
                    + " Carga Máxima: " + automoveis.get(i).getCarga_maxima()
                    + " Modelo: " + automoveis.get(i).getModelo()
                    + " ID: " + automoveis.get(i).getId()
                    + " FK_Funcionário: " + automoveis.get(i).getFk_funcionario_idfuncionario()
                    + " FK_Cidade: " + automoveis.get(i).getFk_cidade_id());
        }
    }
    
    public void relatorioBandaPorco(int maiorQue){
        List<BandaPorco> bandas = new ArrayList();
        Connection c = null;
        Statement stmt = null;
        try {
            Class.forName("org.postgresql.Driver");
            c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/transportePereciveis", "postgres", "123456");
            //c.setAutoCommit(false);
            stmt = c.createStatement();
            
            ResultSet rs = stmt.executeQuery("select * from bandaporco where quantidade >" + maiorQue + ";");
            while (rs.next()) {
                BandaPorco banda = new BandaPorco();
                
                banda.setDataDeAbate(rs.getString("dataabate"));
                banda.setId(rs.getInt("id"));
                banda.setQuantidade(rs.getInt("quantidade"));
                
                bandas.add(banda);
            }
            rs.close();
            stmt.close();
            c.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }
        for (int i = 0; i < bandas.size(); i++) {
            System.out.println("Data de abate: " + bandas.get(i).getDataDeAbate() + " Quantidade: " + bandas.get(i).getQuantidade() + " ID: " + bandas.get(i).getId());
        }
    }
    
}
