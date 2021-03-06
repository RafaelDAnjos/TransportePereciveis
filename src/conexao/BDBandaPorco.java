package conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import transporteperecivel.BandaPorco;

/**
 *
 * @author Daniel
 */

public class BDBandaPorco {

    public synchronized void  createTable() {
        Connection c = null;
        Statement stmt = null;
        try {
            Class.forName("org.postgresql.Driver");
            c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/transportePereciveis", "postgres", "123456");
            stmt = c.createStatement();
            
            String sql = "DROP TABLE IF EXISTS bandaporco cascade; CREATE TABLE bandaporco ("
                    + "dataAbate DATE,"
                    + "quantidade INT,"
                    + "id SERIAL PRIMARY KEY"
                    + ");";
            
            stmt.executeUpdate(sql);
            stmt.close();
            c.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());            
        }
    }

    public  void insertTable(BandaPorco banda) {
    
    Connection c = null;
    Statement stmt = null;
    try {
        Class.forName("org.postgresql.Driver");
        c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/transportePereciveis", "postgres", "123456");
        stmt = c.createStatement();
       
        String sql = "INSERT INTO bandaporco (dataAbate, quantidade) "
                + "VALUES('"+ banda.getDataDeAbate() + "', " + banda.getQuantidade() + ");"; 
        
        stmt.executeUpdate(sql);
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
            c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/transportePereciveis", "postgres", "123456");
            stmt = c.createStatement();
            
            String sql = "DELETE FROM bandaporco WHERE id=" + id +";";
            
            stmt.executeUpdate(sql);            
            stmt.close();
            c.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + 
                    e.getMessage());            
        }
    }
    
        public  void updateTable(BandaPorco banda, int id) {
        Connection c = null;
        Statement stmt = null;
        try {
            Class.forName("org.postgresql.Driver");
            c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/transportePereciveis", "postgres", "123456");
            stmt = c.createStatement();
            
            String sql = "UPDATE bandaporco SET dataabate = '" 
                    + banda.getDataDeAbate() + "', quantidade= " + banda.getQuantidade()
                    + " WHERE id =" + id + ";";
            
            stmt.executeUpdate(sql);            
            stmt.close();
            c.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + 
                    e.getMessage());            
        }
    }

    public synchronized ArrayList selectTable() {
        ArrayList listBandas = new ArrayList();        
        Connection c = null;
        Statement stmt = null;
        try {
            Class.forName("org.postgresql.Driver");
            c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/transportePereciveis", "postgres", "123456");
            stmt = c.createStatement();
            
            ResultSet rs = stmt.executeQuery("SELECT * FROM bandaporco ;");
            while (rs.next()) {
                BandaPorco bandaporco = new BandaPorco(rs.getString("dataabate"), rs.getInt("quantidade"));
                bandaporco.setId(rs.getInt("id"));              
                listBandas.add(bandaporco);
            }
            rs.close();
            stmt.close();
            c.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());            
        }
        return listBandas;
    }
    
    
}