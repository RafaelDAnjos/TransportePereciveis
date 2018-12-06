package conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import transporteperecivel.Bairro;

/**
 *
 * @author Daniel
 */

public class BDBairro {
    String url = "jdbc:postgresql://localhost:5432/transportePereciveis",usuario = "postgres",senha = "123456";
    public synchronized void  createTable() {
        Connection c = null;
        Statement stmt = null;
        try {
            Class.forName("org.postgresql.Driver");
            c = DriverManager.getConnection(url, usuario, senha);
            stmt = c.createStatement();
            
            String comando = "DROP TABLE IF EXISTS bairro cascade; CREATE TABLE bairro (nome VARCHAR(30), id INT);";
            
            stmt.executeUpdate(comando);
            stmt.close();
            c.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());            
        }
    }

    public  void insertTable(Bairro bairro) {
    
    Connection c = null;
    Statement stmt = null;
    try {
        Class.forName("org.postgresql.Driver");
        c = DriverManager.getConnection(url, usuario, senha);
        stmt = c.createStatement();
       
        String comando = "INSERT INTO bairro (nome, id)VALUES('" + bairro.getNome() + "'," + bairro.getId() + ");"; 
        
        stmt.executeUpdate(comando);
        stmt.close();
        //c.commit();
        c.close();
    } catch (Exception e) {
        System.err.println(e.getClass().getName() + ": " + e.getMessage());            
    }
    }

    public  void deleteTable(String nome) {
        Connection c = null;
        Statement stmt = null;
        try {
            Class.forName("org.postgresql.Driver");
            c = DriverManager.getConnection(url, usuario, senha);
            stmt = c.createStatement();
            
            String comando = "DELETE FROM bairro WHERE nome='" + nome +"';";
            
            stmt.executeUpdate(comando);            
            stmt.close();
            c.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + 
                    e.getMessage());            
        }
    }

    public synchronized ArrayList selectTable() {
        ArrayList listBairros = new ArrayList();        
        Connection c = null;
        Statement stmt = null;
        try {
            Class.forName("org.postgresql.Driver");
            c = DriverManager.getConnection(url, usuario, senha);
            stmt = c.createStatement();
            
            ResultSet rs = stmt.executeQuery("SELECT * FROM bairro ;");
            while (rs.next()) {
                Bairro bairro = new Bairro();          
                bairro.setNome(rs.getString("nome"));
                bairro.setId(rs.getInt("id")); 
                listBairros.add(bairro);
            }
            rs.close();
            stmt.close();
            c.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());            
        }
        return listBairros;
    }
    
    public  void updateTable(Bairro bairro) {
        Connection c = null;
        Statement stmt = null;
        try {
            Class.forName("org.postgresql.Driver");
            c = DriverManager.getConnection(url,usuario,senha);
            stmt = c.createStatement();
            
            String sql = "UPDATE bairro SET nome = '" + bairro.getNome() + "' where id = " +bairro.getId() +";";
            
            stmt.executeUpdate(sql);            
            stmt.close();
            c.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + 
                    e.getMessage());            
        }
    }
    
}