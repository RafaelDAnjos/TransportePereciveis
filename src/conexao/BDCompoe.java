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
import transporteperecivel.Compoe;

/**
 *
 * @author Andreas
 */
public class BDCompoe {
    String url = "jdbc:postgresql://localhost:5432/transportePereciveis",usuario = "postgres",senha = "123456";
    public synchronized void  createTable() {
        Connection c = null;
        Statement stmt = null;
        try {
            Class.forName("org.postgresql.Driver");
            c = DriverManager.getConnection(url, usuario, senha);
            stmt = c.createStatement();
            
            String comando = "DROP TABLE IF EXISTS compoe cascade; CREATE TABLE Compoe (\n" +
            "    fk_Endereco_ID serial,\n" +
            "    fk_Bairro_ID serial\n" +
            ");";
            
            stmt.executeUpdate(comando);
            stmt.close();
            c.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());            
        }
    }

    public  void insertTable(Compoe compoe) {
    
    Connection c = null;
    Statement stmt = null;
    try {
        Class.forName("org.postgresql.Driver");
        c = DriverManager.getConnection(url, usuario, senha);
        stmt = c.createStatement();
       
        String comando = "INSERT INTO compoe(fk_bairro_id, fk_endereco_id)VALUES(" + compoe.getFk_Bairro_ID()+ "," + compoe.getFk_Endereco_ID()+ ");"; 
        
        stmt.executeUpdate(comando);
        stmt.close();
        //c.commit();
        c.close();
    } catch (Exception e) {
        System.err.println(e.getClass().getName() + ": " + e.getMessage());            
    }
    }
    
    public synchronized ArrayList selectTable() {
        ArrayList listCompoe = new ArrayList();        
        Connection c = null;
        Statement stmt = null;
        try {
            Class.forName("org.postgresql.Driver");
            c = DriverManager.getConnection(url, usuario, senha);
            stmt = c.createStatement();
            
            ResultSet rs = stmt.executeQuery("SELECT * FROM Compoe ;");
            while (rs.next()) {
                Compoe compoe = new Compoe();          
                compoe.setFk_Bairro_ID(rs.getInt("fk_bairro_id"));
                compoe.setFk_Endereco_ID(rs.getInt("fk_endereco_id")); 
                listCompoe.add(compoe);
            }
            rs.close();
            stmt.close();
            c.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());            
        }
        return listCompoe;
    }
    
    public  void deleteTable(int idEndereco,int idBairro) {
        Connection c = null;
        Statement stmt = null;
        try {
            Class.forName("org.postgresql.Driver");
            c = DriverManager.getConnection(url, usuario, senha);
            stmt = c.createStatement();
            
            String comando = "DELETE FROM compoe WHERE fk_endereco_id=" + idEndereco +" and fk_bairro_id =" + idBairro +";";
            
            stmt.executeUpdate(comando);            
            stmt.close();
            c.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + 
                    e.getMessage());            
        }
    }
    
    public  void updateTable(Compoe compoe) {
        Connection c = null;
        Statement stmt = null;
        try {
            Class.forName("org.postgresql.Driver");
            c = DriverManager.getConnection(url,usuario,senha);
            stmt = c.createStatement();
            
            String sql = "UPDATE compoe SET Fk_Bairro_ID = " + compoe.getFk_Bairro_ID()+", Fk_Endereco_ID =" +compoe.getFk_Endereco_ID()+ " where fk_Endereco_ID = " + compoe.getFk_Endereco_ID()+";";

            stmt.executeUpdate(sql);            
            stmt.close();
            c.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + 
                    e.getMessage());            
        }
    }
    


}
