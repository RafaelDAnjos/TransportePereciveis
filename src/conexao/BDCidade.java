package conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import transporteperecivel.Cidade;

/**
 *
 * @author Daniel
 */

public class BDCidade {

    public synchronized void  createTable() {
        Connection c = null;
        Statement stmt = null;
        try {
            Class.forName("org.postgresql.Driver");
            c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/transportePereciveis", "postgres", "");
            System.out.println("Banco de dados aberto com sucesso!!");
            stmt = c.createStatement();
            
            String comando = "CREATE TABLE cidade (nome VARCHAR[30], id INT);";
            
            stmt.executeUpdate(comando);
            stmt.close();
            c.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());            
        }
        System.out.println("Tabela criada com sucesso!!");
    }

    public  void insertTable(Cidade cidade) {
    
    Connection c = null;
    Statement stmt = null;
    try {
        Class.forName("org.postgresql.Driver");
        c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/testeJava", "postgres", "serra");
        System.out.println("Banco de dados aberto com sucesso!!");
        stmt = c.createStatement();
       
        String comando = "INSERT INTO cliente (nome, id)VALUES('" + cidade.getNome() + "'," + cidade.getId() + ");"; 
        
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
            
            String comando = "DELETE FROM cidade WHERE nome='" + nome +"';";
            
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
        ArrayList listCidades = new ArrayList();        
        Connection c = null;
        Statement stmt = null;
        try {
            Class.forName("org.postgresql.Driver");
            c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/testeJava", "postgres", "serra");
            //c.setAutoCommit(false);
            System.out.println("Banco de dados aberto com sucesso!!");
            stmt = c.createStatement();
            
            ResultSet rs = stmt.executeQuery("SELECT * FROM cidade ;");
            while (rs.next()) {
                Cidade cidade = new Cidade();
                cidade.setNome(rs.getString("nome"));
                cidade.setId(rs.getInt("id"));              
                listCidades.add(cidade);
            }
            rs.close();
            stmt.close();
            c.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());            
        }
        System.out.println("Operação realizada com sucesso!!");
        return listCidades;
    }
    
}