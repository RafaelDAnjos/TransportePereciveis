/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
    public static String url = "jdbc:postgresql://localhost:5432/testeJava";
    public static String usuario = "postgres";
    public static String senha = "serra" ;
    public synchronized void  createTable() {
        Connection c = null;
        Statement stmt = null;
        try {
            Class.forName("org.postgresql.Driver");
            c = DriverManager.getConnection(url,usuario,senha);
            System.out.println("Banco de dados aberto com sucesso!!");
            stmt = c.createStatement();
            
            String comando = "CREATE TABLE cliente (nomeEmpresa varchar(80), endereco varchar(500), horarioEntrega varchar(40));";
            
            stmt.executeUpdate(comando);
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
        c = DriverManager.getConnection(url,usuario,senha);
        c.setAutoCommit(false);
        System.out.println("Banco de dados aberto com sucesso!!");
        stmt = c.createStatement();
        
        String comando = "INSERT INTO cliente (nomeEmpresa, enderecoEmpresa, horarioEntrega)VALUES('"
                + cliente.getNomeEmpresa() + "','" + cliente.getEndereco() + "','" +cliente.getHorarioEntrega() +"');";   
        
        stmt.executeUpdate(comando);
        stmt.close();
        //c.commit();
        c.close();
    } catch (Exception e) {
        System.err.println(e.getClass().getName() + ": " + e.getMessage());            
    }
    System.out.println("Operação realizada com sucesso!!");
    }

    public  void deleteTable(String nomeEmpresa) {
        Connection c = null;
        Statement stmt = null;
        try {
            Class.forName("org.postgresql.Driver");
            c = DriverManager.getConnection(url,usuario,senha);
            c.setAutoCommit(false);
            System.out.println("Banco de dados aberto com sucesso!!");
            stmt = c.createStatement();
            
            String comando = "DELETE FROM cliente WHERE nomeEmpresa='" + nomeEmpresa +"';";
            
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
        ArrayList listClientes = new ArrayList();        
        Connection c = null;
        Statement stmt = null;
        try {
            Class.forName("org.postgresql.Driver");
            c = DriverManager.getConnection(url,usuario,senha);
            c.setAutoCommit(false);
            System.out.println("Banco de dados aberto com sucesso!!");
            stmt = c.createStatement();
            
            ResultSet rs = stmt.executeQuery("SELECT * FROM cliente ;");
            while (rs.next()) {
                Cliente cliente = new Cliente();
                cliente.setNomeEmpresa(rs.getString("nomeEmpresa"));
                
                //cliente.setEndereco(rs.getString("endereco"));
                
                cliente.setHorarioEntrega(rs.getString("horarioEntrega"));            
                listClientes.add(cliente);
            }
            rs.close();
            stmt.close();
            c.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());            
        }
        System.out.println("Operação realizada com sucesso!!");
        return listClientes;
    }
    
}
