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

    public synchronized void  createTable() {
        Connection c = null;
        Statement stmt = null;
        try {
            Class.forName("org.postgresql.Driver");
            c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/transportePereciveis", "postgres", "");
            System.out.println("Banco de dados aberto com sucesso!!");
            stmt = c.createStatement();
            
            String comando = "CREATE TABLE bairro (nome VARCHAR(30), id INT);";
            
            stmt.executeUpdate(comando);
            stmt.close();
            c.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());            
        }
        System.out.println("Tabela criada com sucesso!!");
    }

    public  void insertTable(Bairro bairro) {
    
    Connection c = null;
    Statement stmt = null;
    try {
        Class.forName("org.postgresql.Driver");
        c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/testeJava", "postgres", "serra");
        System.out.println("Banco de dados aberto com sucesso!!");
        stmt = c.createStatement();
       
        String comando = "INSERT INTO bairro (nome, id)VALUES('" + bairro.getNome() + "'," + bairro.getId() + ");"; 
        
        stmt.executeUpdate(comando);
        stmt.close();
        //c.commit();
        c.close();
    } catch (Exception e) {
        System.err.println(e.getClass().getName() + ": " + e.getMessage());            
    }
    System.out.println("Operação realizada com sucesso!!");
    }

    public  void deleteTable(String nome) {
        Connection c = null;
        Statement stmt = null;
        try {
            Class.forName("org.postgresql.Driver");
            c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/transportePereciveis", "postgres", "");
            System.out.println("Banco de dados aberto com sucesso!!");
            stmt = c.createStatement();
            
            String comando = "DELETE FROM bairro WHERE nome='" + nome +"';";
            
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
        ArrayList listBairros = new ArrayList();        
        Connection c = null;
        Statement stmt = null;
        try {
            Class.forName("org.postgresql.Driver");
            c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/testeJava", "postgres", "serra");
            System.out.println("Banco de dados aberto com sucesso!!");
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
        System.out.println("Operação realizada com sucesso!!");
        return listBairros;
    }
    
}