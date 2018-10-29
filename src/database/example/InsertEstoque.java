/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database.example;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
/**
 *
 * @author 20161bsi0527
 */
public class InsertEstoque {
    
    
    public void inserirEstoque(int numeroBanda, String dataAbate){
        DBConnection.getInstance();
                Connection c = null;
        Statement stmt = null;
        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:veiculos.db");            
            System.out.println("Base de dados aberta");                        
            stmt = c.createStatement();
            String sql = "INSERT INTO ESTOQUE (NUMEROBANDA, DATAABATE) values "
                    + "("+ numeroBanda + ", " + "'"+dataAbate + "'" +")";
            stmt.executeUpdate(sql);
            stmt.close();
            c.commit();
            c.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());            
        }
        System.out.println("Records created successfully");
        
    }
    
    
    
}
