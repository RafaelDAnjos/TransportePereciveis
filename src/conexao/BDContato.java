package conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import transporteperecivel.Contato;

/**
 *
 * @author Daniel
 */

public class BDContato {

    public synchronized void  createTable() {
        Connection c = null;
        Statement stmt = null;
        try {
            Class.forName("org.postgresql.Driver");
            c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/transportePereciveis", "postgres", "123456");
            System.out.println("Banco de dados aberto com sucesso!!");
            stmt = c.createStatement();
            
            String sql = "DROP TABLE IF EXISTS contato CASCADE; CREATE TABLE contato ("
                    + "telefone VARCHAR(12),"
                    + "id SERIAL PRIMARY KEY, fkfuncionario SERIAL"
                    + ");";
            
            stmt.executeUpdate(sql);
            stmt.close();
            c.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());            
        }
        System.out.println("Tabela criada com sucesso!!");
    }

    public  void insertTable(Contato telefone) {
    
    Connection c = null;
    Statement stmt = null;
    try {
        Class.forName("org.postgresql.Driver");
        c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/transportePereciveis", "postgres", "123456");
        System.out.println("Banco de dados aberto com sucesso!!");
        stmt = c.createStatement();
       
        String sql = "INSERT INTO contato (telefone, fkfuncionario) "
                + "VALUES('" + telefone.getTelefone() + "', " + telefone.getFkfuncionario() + ");"; 
        
        stmt.executeUpdate(sql);
        stmt.close();
        //c.commit();
        c.close();
    } catch (Exception e) {
        System.err.println(e.getClass().getName() + ": " + e.getMessage());            
    }
    System.out.println("Dado inserido com sucesso!!");
    }

    public  void deleteTable(int id) {
        Connection c = null;
        Statement stmt = null;
        try {
            Class.forName("org.postgresql.Driver");
            c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/transportePereciveis", "postgres", "123456");
            System.out.println("Banco de dados aberto com sucesso!!");
            stmt = c.createStatement();
            
            String sql = "DELETE FROM contato WHERE id=" + id +";";
            
            stmt.executeUpdate(sql);            
            stmt.close();
            c.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + 
                    e.getMessage());            
        }
        System.out.println("Dado deletado com sucesso!!");
    }
    
        public  void updateTable(Contato contato, int id) {
        Connection c = null;
        Statement stmt = null;
        try {
            Class.forName("org.postgresql.Driver");
            c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/transportePereciveis", "postgres", "123456");
            System.out.println("Banco de dados aberto com sucesso!!");
            stmt = c.createStatement();
            
            String sql = "UPDATE contato SET telefone = '" + contato.getTelefone() + "', fkfuncionario = " + contato.getFkfuncionario() + "WHERE id =" + id + ";";
                    
            
            stmt.executeUpdate(sql);            
            stmt.close();
            c.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + 
                    e.getMessage());            
        }
        System.out.println("Dado atualizado com sucesso!!");
    }

    public synchronized ArrayList selectTable() {
        ArrayList listContatos = new ArrayList();        
        Connection c = null;
        Statement stmt = null;
        try {
            Class.forName("org.postgresql.Driver");
            c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/transportePereciveis", "postgres", "123456");
            System.out.println("Banco de dados aberto com sucesso!!");
            stmt = c.createStatement();
            
            ResultSet rs = stmt.executeQuery("SELECT * FROM contato ;");
            while (rs.next()) {
                Contato contato = new Contato(rs.getString("telefone"));
                contato.setFkfuncionario(rs.getInt("fkfuncionario"));
                contato.setId(rs.getInt("id"));              
                listContatos.add(contato);
            }
            rs.close();
            stmt.close();
            c.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());            
        }
        System.out.println("Dados selecionados com sucesso!!");
        return listContatos;
    }
    
    
}