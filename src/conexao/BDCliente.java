package conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import transporteperecivel.Cliente;

/**
 *
 * @author Daniel
 */

public class BDCliente {

    public synchronized void  createTable() {
        Connection c = null;
        Statement stmt = null;
        try {
            Class.forName("org.postgresql.Driver");
            c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/transportePereciveis", "postgres", "123456");
            System.out.println("Banco de dados aberto com sucesso!!");
            stmt = c.createStatement();
            
            String sql = "DROP TABLE IF EXISTS cliente cascade; CREATE TABLE cliente ("
                    + "nomeFicticio VARCHAR(50),"
                    + "id SERIAL,"
                    + "cnpj VARCHAR(12)"
                    + ");";
            
            stmt.executeUpdate(sql);
            stmt.close();
            c.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());            
        }
        System.out.println("Tabela criada com sucesso!!");
    }

    public  void insertTable(Cliente cliente) {
    
    Connection c = null;
    Statement stmt = null;
    try {
        Class.forName("org.postgresql.Driver");
        c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/transportePereciveis", "postgres", "123456");
        System.out.println("Banco de dados aberto com sucesso!!");
        stmt = c.createStatement();
       
        String sql = "INSERT INTO cliente (nomeFicticio, cnpj) "
                + "VALUES('"+ cliente.getNomeFicticio() + "','"+ cliente.getCnpj() + "');"; 
        
        stmt.executeUpdate(sql);
        stmt.close();
        //c.commit();
        c.close();
    } catch (Exception e) {
        System.err.println(e.getClass().getName() + ": " + e.getMessage());            
    }
    System.out.println("Dado inserido com sucesso!!");
    }

    public  void deleteTable(int id) {
        Connection c = null;
        Statement stmt = null;
        try {
            Class.forName("org.postgresql.Driver");
            c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/transportePereciveis", "postgres", "123456");
            System.out.println("Banco de dados aberto com sucesso!!");
            stmt = c.createStatement();
            
            String sql = "DELETE FROM cliente WHERE id=" + id +";";
            
            stmt.executeUpdate(sql);            
            stmt.close();
            c.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + 
                    e.getMessage());            
        }
        System.out.println("Dado deletado com sucesso!!");
    }
    
        public  void updateTable(String nomeFicticio, String cnpj, int id) {
        Connection c = null;
        Statement stmt = null;
        try {
            Class.forName("org.postgresql.Driver");
            c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/transportePereciveis", "postgres", "123456");
            System.out.println("Banco de dados aberto com sucesso!!");
            stmt = c.createStatement();
            
            String sql = "UPDATE cliente SET nomeficticio = '" + nomeFicticio + "',"
                    + "cnpj = '" + cnpj + "' WHERE id =" + id + ";";
            
            stmt.executeUpdate(sql);            
            stmt.close();
            c.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + 
                    e.getMessage());            
        }
        System.out.println("Dado deletado com sucesso!!");
    }

    public synchronized ArrayList selectTable() {
        ArrayList listClientes = new ArrayList();        
        Connection c = null;
        Statement stmt = null;
        try {
            Class.forName("org.postgresql.Driver");
            c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/transportePereciveis", "postgres", "123456");
            System.out.println("Banco de dados aberto com sucesso!!");
            stmt = c.createStatement();
            
            ResultSet rs = stmt.executeQuery("SELECT * FROM cliente ;");
            while (rs.next()) {
                Cliente cliente = new Cliente(rs.getString("nomeFicticio"), rs.getString("cnpj"));
                cliente.setId(rs.getInt("id"));              
                listClientes.add(cliente);
            }
            rs.close();
            stmt.close();
            c.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());            
        }
        System.out.println("Dados selecionados com sucesso!!");
        return listClientes;
    }
    
    
}