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
import transporteperecivel.Entrega;

/**
 *
 * @author rafae
 */
public class BDEntrega {
    String url = "jdbc:postgresql://localhost:5432/transportePereciveis",usuario = "postgres",senha = "123456";
    public synchronized void  createTable() {
        Connection c = null;
        Statement stmt = null;
        try {
            Class.forName("org.postgresql.Driver");
            c = DriverManager.getConnection(url, usuario, senha);
            stmt = c.createStatement();
            
            String comando = "DROP TABLE IF EXISTS entrega cascade; CREATE TABLE entrega (\n" +
            "    fk_Automovel_ID serial,\n" +
            "    fk_cliente_ID serial\n" +
            ");";
            
            stmt.executeUpdate(comando);
            stmt.close();
            c.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());            
        }
    }
    
    public  void insertTable(Entrega entrega) {
    
    Connection c = null;
    Statement stmt = null;
    try {
        Class.forName("org.postgresql.Driver");
        c = DriverManager.getConnection(url, usuario, senha);
        stmt = c.createStatement();
       
        String comando = "INSERT INTO entrega(fk_automovel_id, fk_cliente_id)VALUES(" + entrega.getFk_Automovel_ID()+ "," + entrega.getFk_Cliente_ID()+ ");"; 
        
        stmt.executeUpdate(comando);
        stmt.close();
        //c.commit();
        c.close();
    } catch (Exception e) {
        System.err.println(e.getClass().getName() + ": " + e.getMessage());            
    }
    }
    
    public synchronized ArrayList selectTable() {
        ArrayList listEntrega = new ArrayList();        
        Connection c = null;
        Statement stmt = null;
        try {
            Class.forName("org.postgresql.Driver");
            c = DriverManager.getConnection(url, usuario, senha);
            stmt = c.createStatement();
            
            ResultSet rs = stmt.executeQuery("SELECT * FROM entrega ;");
            while (rs.next()) {
                Entrega entrega = new Entrega();          
                entrega.setFk_Automovel_ID(rs.getInt("fk_automovel_id"));
                entrega.setFk_Cliente_ID(rs.getInt("fk_cliente_id")); 
                listEntrega.add(entrega);
            }
            rs.close();
            stmt.close();
            c.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());            
        }
        return listEntrega;
    }

    public  void deleteTable(int IDCliente, int IDAutomovel) {
        Connection c = null;
        Statement stmt = null;
        try {
            Class.forName("org.postgresql.Driver");
            c = DriverManager.getConnection(url, usuario, senha);
            stmt = c.createStatement();
            
            String comando = "DELETE FROM entrega WHERE fk_cliente_id=" + IDCliente +"and fk_automovel_id="+IDAutomovel+";";
            
            stmt.executeUpdate(comando);            
            stmt.close();
            c.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + 
                    e.getMessage());            
        }
    }
    
        public  void updateTable(Entrega entrega) {
        Connection c = null;
        Statement stmt = null;
        try {
            Class.forName("org.postgresql.Driver");
            c = DriverManager.getConnection(url,usuario,senha);
            stmt = c.createStatement();
            
            String sql = "UPDATE entrega SET Fk_automovel_ID = " + entrega.getFk_Automovel_ID()+", Fk_cliente_ID =" +entrega.getFk_Cliente_ID()+ " where fk_Cliente_ID = " + entrega.getFk_Cliente_ID()+";";
            stmt.executeUpdate(sql);            
            stmt.close();
            c.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + 
                    e.getMessage());            
        }
    }
}
