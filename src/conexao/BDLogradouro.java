package conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import transporteperecivel.Logradouro;

/**
 *
 * @author Daniel
 */

public class BDLogradouro {
    String url = "jdbc:postgresql://localhost:5432/transportePereciveis",usuario =  "postgres",senha =  "123456";

    public synchronized void  createTable() {
        Connection c = null;
        Statement stmt = null;
        try {
            Class.forName("org.postgresql.Driver");
            c = DriverManager.getConnection(url,usuario,senha);
            stmt = c.createStatement();
            
            String comando = "Drop table if exists logradouro cascade ; CREATE TABLE logradouro (id serial, descricao VARCHAR(40));";
            
            stmt.executeUpdate(comando);
            stmt.close();
            c.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());            
        }
    }

    public  void insertTable(Logradouro logradouro) {
    
    Connection c = null;
    Statement stmt = null;
    try {
        Class.forName("org.postgresql.Driver");
        c = DriverManager.getConnection(url,usuario,senha);
        stmt = c.createStatement();
       
        String comando = "INSERT INTO logradouro ( descricao)VALUES( '"+ logradouro.getDescricao() + "');"; 
        
        stmt.executeUpdate(comando);
        stmt.close();
        //c.commit();
        c.close();
    } catch (Exception e) {
        System.err.println(e.getClass().getName() + ": " + e.getMessage());            
    }
    }

    public  void deleteTable(int id) {
        Connection c = null;
        Statement stmt = null;
        try {
            Class.forName("org.postgresql.Driver");
            c = DriverManager.getConnection(url,usuario,senha);
            stmt = c.createStatement();
            
            String comando = "DELETE FROM logradouro WHERE id = " + id +";";
            
            stmt.executeUpdate(comando);            
            stmt.close();
            c.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + 
                    e.getMessage());            
        }
    }

    public synchronized ArrayList selectTable() {
        ArrayList listLogradouros = new ArrayList();        
        Connection c = null;
        Statement stmt = null;
        try {
            Class.forName("org.postgresql.Driver");
            c = DriverManager.getConnection(url,usuario,senha);
            c.setAutoCommit(false);
            stmt = c.createStatement();
            
            ResultSet rs = stmt.executeQuery("SELECT * FROM logradouro ;");
            while (rs.next()) {
                Logradouro logradouro = new Logradouro();
                logradouro.setId(rs.getInt("id")); 
                logradouro.setDescricao(rs.getString("descricao"));
                listLogradouros.add(logradouro);
            }
            rs.close();
            stmt.close();
            c.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());            
        }
        return listLogradouros;
    }
    
}
