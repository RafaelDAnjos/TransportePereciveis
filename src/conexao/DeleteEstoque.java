/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

/**
 *
 * @author rafael
 */
public class DeleteEstoque {
        public void alterarEstoque(int numeroBanda, String dataAbate){
        DBConnection.getInstance();
                Connection c = null;
        Statement stmt = null;
        try {
            Class.forName("org.postgres.Driver");
            c = DriverManager.getConnection("jdbc:postgres:veiculos.db");            
            System.out.println("Base de dados aberta");                        
            stmt = c.createStatement();
            String sql = "alter table estoque alter column numeroBanda to" + numeroBanda;
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


