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
import transporteperecivel.Recebe;
/**
 *
 * @author rafae
 */
public class BDRecebe {
    String url = "jdbc:postgresql://localhost:5432/transportePereciveis",usuario = "postgres",senha = "123456";
    public synchronized void  createTable() {
        Connection c = null;
        Statement stmt = null;
        try {
            Class.forName("org.postgresql.Driver");
            c = DriverManager.getConnection(url, usuario, senha);
            stmt = c.createStatement();
            
            String comando = "DROP TABLE IF EXISTS recebe cascade; CREATE TABLE recebe (\n" +
            "    fk_HorarioRecebimento_ID int,\n" +
            "    fk_Cliente_ID int\n" +
            ");";
            
            stmt.executeUpdate(comando);
            stmt.close();
            c.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());            
        }
    }
    
    public  void insertTable(Recebe recebe) {
    
    Connection c = null;
    Statement stmt = null;
    try {
        Class.forName("org.postgresql.Driver");
        c = DriverManager.getConnection(url, usuario, senha);
        stmt = c.createStatement();
       
        String comando = "INSERT INTO recebe(fk_cliente_id, fk_HorarioRecebimento_id)VALUES(" + recebe.getFk_Cliente_ID()+ "," + recebe.getFk_HorarioRecebimento_ID()+ ");"; 
        
        stmt.executeUpdate(comando);
        stmt.close();
        //c.commit();
        c.close();
    } catch (Exception e) {
        System.err.println(e.getClass().getName() + ": " + e.getMessage());            
    }
    }
    
    public synchronized ArrayList selectTable() {
        ArrayList listRecebe = new ArrayList();        
        Connection c = null;
        Statement stmt = null;
        try {
            Class.forName("org.postgresql.Driver");
            c = DriverManager.getConnection(url, usuario, senha);
            stmt = c.createStatement();
            
            ResultSet rs = stmt.executeQuery("SELECT * FROM recebe ;");
            while (rs.next()) {
                Recebe recebe = new Recebe();          
                recebe.setFk_Cliente_ID(rs.getInt("fk_cliente_id"));
                recebe.setFk_HorarioRecebimento_ID(rs.getInt("fk_horariorecebimento_id")); 
                listRecebe.add(recebe);
            }
            rs.close();
            stmt.close();
            c.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());            
        }
        return listRecebe;
    }
    
    
    public  void deleteTable(int IDCliente, int IDHorarioRecebimento) {
        Connection c = null;
        Statement stmt = null;
        try {
            Class.forName("org.postgresql.Driver");
            c = DriverManager.getConnection(url, usuario, senha);
            stmt = c.createStatement();
            
            String comando = "DELETE FROM recebe WHERE fk_cliente_id=" + IDCliente +" and fk_horariorecebimento_id ="+ IDHorarioRecebimento+";";
            
            stmt.executeUpdate(comando);            
            stmt.close();
            c.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + 
                    e.getMessage());            
        }
    }
    
    
    public  void updateTable(Recebe recebe) {
        Connection c = null;
        Statement stmt = null;
        try {
            Class.forName("org.postgresql.Driver");
            c = DriverManager.getConnection(url,usuario,senha);
            stmt = c.createStatement();
            
            String sql = "UPDATE recebe SET Fk_cliente_ID = " + recebe.getFk_Cliente_ID()+", Fk_HorarioRecebimento_ID =" +recebe.getFk_HorarioRecebimento_ID()+ " where fk_Cliente_ID = " + recebe.getFk_Cliente_ID()+";";
            System.out.println(sql);
            stmt.executeUpdate(sql);            
            stmt.close();
            c.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + 
                    e.getMessage());            
        }
    }
}
