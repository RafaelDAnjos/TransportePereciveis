package conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import transporteperecivel.Funcionario;

/**
 *
 * @author Daniel
 */

public class BDFuncionario {
    String url = "jdbc:postgresql://localhost:5432/transportePereciveis",usuario = "postgres",senha = "123456";
    public synchronized void  createTable() {
        Connection c = null;
        Statement stmt = null;
        try {
            Class.forName("org.postgresql.Driver");
            c = DriverManager.getConnection(url, usuario, senha);
            System.out.println("Banco de dados aberto com sucesso!!");
            stmt = c.createStatement();
            
            String comando = "DROP TABLE IF EXISTS funcionario cascade; CREATE TABLE funcionario (nome VARCHAR(30), cpf VARCHAR(12), senha VARCHAR(20), cargaHoraria VARCHAR(10), idfuncionario Serial);";
            
            stmt.executeUpdate(comando);
            stmt.close();
            c.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());            
        }
        System.out.println("Tabela criada com sucesso!!");
    }

    public  void insertTable(Funcionario funcionario) {
    
    Connection c = null;
    Statement stmt = null;
    try {
        Class.forName("org.postgresql.Driver");
        c = DriverManager.getConnection(url, usuario, senha);
        System.out.println("Banco de dados aberto com sucesso!!");
        stmt = c.createStatement();
       
        String comando = "INSERT INTO funcionario (nome, cpf, senha, cargaHoraria)VALUES('"
                + funcionario.getNome() + "','" + funcionario.getCpf() + "','" + funcionario.getSenha() + "','"  + funcionario.getCargaHoraria() + "');"; 
        stmt.executeUpdate(comando);
        stmt.close();
        //c.commit();
        c.close();
    } catch (Exception e) {
        System.err.println(e.getClass().getName() + ": " + e.getMessage());            
    }
    System.out.println("Operação realizada com sucesso!!");
    }

    public  void deleteTable(int id) {
        Connection c = null;
        Statement stmt = null;
        String comando = null;
        System.out.print(c);
        try {
            Class.forName("org.postgresql.Driver");
            c = DriverManager.getConnection(url, usuario, senha);
            System.out.println("Banco de dados aberto com sucesso!!");
            stmt = c.createStatement();
             
            comando = "delete from funcionario where idfuncionario = " +id+";";
            
            stmt.executeUpdate(comando);   
            stmt.close();
            c.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + 
                    e.getMessage());            
        }
        System.out.println("Operação realizada com sucesso!!");
    }

    public synchronized ArrayList selectTable() {
        ArrayList listFuncionarios = new ArrayList();        
        Connection c = null;
        Statement stmt = null;
        try {
            Class.forName("org.postgresql.Driver");
            c = DriverManager.getConnection(url, usuario, senha);
            //c.setAutoCommit(false);
            System.out.println("Banco de dados aberto com sucesso!!");
            stmt = c.createStatement();
            
            ResultSet rs = stmt.executeQuery("SELECT * FROM funcionario ;");
            while (rs.next()) {
                Funcionario funcionario = new Funcionario();
                funcionario.setNome(rs.getString("nome"));
                funcionario.setCpf(rs.getString("cpf"));
                funcionario.setSenha(rs.getString("senha"));
                funcionario.setCargaHoraria(rs.getString("cargaHoraria"));
                funcionario.setIdfuncionario(rs.getInt("idfuncionario")); 
                listFuncionarios.add(funcionario);
            }
            rs.close();
            stmt.close();
            c.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());            
        }
        System.out.println("Operação realizada com sucesso!!");
        return listFuncionarios;
    }
    
        public synchronized ArrayList selectTableWhere(String cpf) {
        ArrayList listFuncionarios = new ArrayList();        
        Connection c = null;
        Statement stmt = null;
        try {
            Class.forName("org.postgresql.Driver");
            c = DriverManager.getConnection(url, usuario, senha);
            //c.setAutoCommit(false);
            System.out.println("Banco de dados aberto com sucesso!!");
            stmt = c.createStatement();
            
            ResultSet rs = stmt.executeQuery("SELECT * FROM funcionario where cpf = "+cpf+ ";");
            while (rs.next()) {
                Funcionario funcionario = new Funcionario();
                funcionario.setNome(rs.getString("nome"));
                funcionario.setCpf(rs.getString("cpf"));
                funcionario.setSenha(rs.getString("senha"));
                funcionario.setCargaHoraria(rs.getString("cargaHoraria"));
                funcionario.setIdfuncionario(rs.getInt("id")); 
                listFuncionarios.add(funcionario);
            }
            rs.close();
            stmt.close();
            c.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());            
        }
        System.out.println("Operação realizada com sucesso!!");
        
        return listFuncionarios;
    }
        
    public  void updateTable(Funcionario funcionario) {
        Connection c = null;
        Statement stmt = null;
        try {
            Class.forName("org.postgresql.Driver");
            c = DriverManager.getConnection(url,usuario,senha);
            System.out.println("Banco de dados aberto com sucesso!!");
            stmt = c.createStatement();
            
            String sql = "UPDATE funcionario SET nome = '" + funcionario.getNome() + "', cargahoraria ='"+ 
                    funcionario.getCargaHoraria() +"', cpf ="+ funcionario.getCpf() + 
                    ", senha ="+ funcionario.getSenha() +" where idfuncionario = " +funcionario.getIdfuncionario()+";";
            System.out.println(sql);
            stmt.executeUpdate(sql);            
            stmt.close();
            c.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + 
                    e.getMessage());            
        }
        System.out.println("Dado alterado com sucesso!!");
    }
}