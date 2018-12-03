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
import transporteperecivel.Da_baixa;

/**
 *
 * @author rafae
 */
public class BDDa_baixa {
    String url = "jdbc:postgresql://localhost:5432/transportePereciveis",usuario = "postgres",senha = "123456";
    public synchronized void  createTable() {
        Connection c = null;
        Statement stmt = null;
        try {
            Class.forName("org.postgresql.Driver");
            c = DriverManager.getConnection(url, usuario, senha);
            System.out.println("Banco de dados aberto com sucesso!!");
            stmt = c.createStatement();
            
            String comando = "DROP TABLE IF EXISTS Da_baixa cascade; CREATE TABLE Da_baixa (\n" +
            "    fk_BandaPorco_ID serial,\n" +
            "    fk__Pedido_ID serial\n" +
            ");";
            
            stmt.executeUpdate(comando);
            stmt.close();
            c.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());            
        }
        System.out.println("Tabela criada com sucesso!!");
    }
    
    public  void insertTable(Da_baixa da_baixa) {
    
    Connection c = null;
    Statement stmt = null;
    try {
        Class.forName("org.postgresql.Driver");
        c = DriverManager.getConnection(url, usuario, senha);
        System.out.println("Banco de dados aberto com sucesso!!");
        stmt = c.createStatement();
       
        String comando = "INSERT INTO da_baixa(fk_bandaporco_id, fk__pedido_id)VALUES(" + da_baixa.getFk_BandaPorco_ID()+ "," + da_baixa.getFk__Pedido_ID()+ ");"; 
        
        stmt.executeUpdate(comando);
        stmt.close();
        //c.commit();
        c.close();
    } catch (Exception e) {
        System.err.println(e.getClass().getName() + ": " + e.getMessage());            
    }
    System.out.println("Operação realizada com sucesso!!");
    }
    
    public synchronized ArrayList selectTable() {
        ArrayList listCompoe = new ArrayList();        
        Connection c = null;
        Statement stmt = null;
        try {
            Class.forName("org.postgresql.Driver");
            c = DriverManager.getConnection(url, usuario, senha);
            System.out.println("Banco de dados aberto com sucesso!!");
            stmt = c.createStatement();
            
            ResultSet rs = stmt.executeQuery("SELECT * FROM da_baixa ;");
            while (rs.next()) {
                Da_baixa da_baixa = new Da_baixa();          
                da_baixa.setFk_BandaPorco_ID(rs.getInt("fk_bandaporco_id"));
                da_baixa.setFk__Pedido_ID(rs.getInt("fk__pedido_id")); 
                listCompoe.add(da_baixa);
            }
            rs.close();
            stmt.close();
            c.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());            
        }
        System.out.println("Operação realizada com sucesso!!");
        return listCompoe;
    }
    
    public  void deleteTable(int IDDa_baixa, int IDBandaporco) {
        Connection c = null;
        Statement stmt = null;
        try {
            Class.forName("org.postgresql.Driver");
            c = DriverManager.getConnection(url, usuario, senha);
            System.out.println("Banco de dados aberto com sucesso!!");
            stmt = c.createStatement();
            
            String comando = "DELETE FROM da_baixa WHERE fk__pedido_id=" + IDDa_baixa +"and fk_bandaporco_id ="+IDBandaporco+";";
            
            stmt.executeUpdate(comando);            
            stmt.close();
            c.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + 
                    e.getMessage());            
        }
        System.out.println("Operação realizada com sucesso!!");
    }
    
    public  void updateTable(Da_baixa da_baixa) {
        Connection c = null;
        Statement stmt = null;
        try {
            Class.forName("org.postgresql.Driver");
            c = DriverManager.getConnection(url,usuario,senha);
            System.out.println("Banco de dados aberto com sucesso!!");
            stmt = c.createStatement();
            
            String sql = "UPDATE da_baixa SET Fk_Bandaporco_ID = " + da_baixa.getFk_BandaPorco_ID()+", Fk__pedido_ID =" +da_baixa.getFk__Pedido_ID()+ " where fk__Pedido_ID = " + da_baixa.getFk__Pedido_ID()+";";
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
