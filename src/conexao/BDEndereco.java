package conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import transporteperecivel.Endereco;

/**
 *
 * @author Daniel
 */

public class BDEndereco {
    String url = "jdbc:postgresql://localhost:5432/transportePereciveis",usuario = "postgres",senha = "123456";
    public synchronized void  createTable() {
        Connection c = null;
        Statement stmt = null;
        try {
            Class.forName("org.postgresql.Driver");
            c = DriverManager.getConnection(url,usuario,senha);
            System.out.println("Banco de dados aberto com sucesso!!");
            stmt = c.createStatement();
            
            String comando = "DROP TABLE IF EXISTS Endereco cascade; CREATE TABLE endereco (    nome varchar(30),\n" +
                             "    ID serial PRIMARY KEY,\n" +
                             "    numero int,\n" +
                             "    complemento varchar(100),\n" +
                             "    fk_Cliente_ID serial,\n" +
                             "    fk_Logradouro_ID serial);";
            
            stmt.executeUpdate(comando);
            stmt.close();
            c.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());            
        }
        System.out.println("Tabela criada com sucesso!!");
    }
    
    
    /*public  void updateTableComplemento(String complemento) {
        Connection c = null;
        Statement stmt = null;
        try {
            Class.forName("org.postgresql.Driver");
            c = DriverManager.getConnection(url,usuario,senha);
            System.out.println("Banco de dados aberto com sucesso!!");
            stmt = c.createStatement();
            
            String sql = "UPDATE cliente SET nomeficticio = '" + complemento + ";";
            
            stmt.executeUpdate(sql);            
            stmt.close();
            c.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + 
                    e.getMessage());            
        }
        System.out.println("Dado alterado com sucesso!!");
    }*/
    
    
    
    public  void updateTable(Endereco endereco) {
        Connection c = null;
        Statement stmt = null;
        try {
            Class.forName("org.postgresql.Driver");
            c = DriverManager.getConnection(url,usuario,senha);
            System.out.println("Banco de dados aberto com sucesso!!");
            stmt = c.createStatement();
            
            String sql = "UPDATE endereco SET nome = '" + endereco.getNome() + "',complemento ='" + endereco.getComplemento()+
                    "',fk_cliente_id = " + endereco.getFk_cliente_id() +",fk_logradouro_id = "+ endereco.getFk_logradouro_id() +
                    ",numero = "+ endereco.getNumero()+"where id=" +endereco.getId() +";";

            stmt.executeUpdate(sql);            
            stmt.close();
            c.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + 
                    e.getMessage());            
        }
        System.out.println("Dado alterado com sucesso!!");
    }
    
    
    
    public  void insertTable(Endereco endereco) {
    
        Connection c = null;
        Statement stmt = null;
        try {
            Class.forName("org.postgresql.Driver");
            c = DriverManager.getConnection(url , usuario, senha);
            System.out.println("Banco de dados aberto com sucesso!!");
            stmt = c.createStatement();
       
        String comando = "INSERT INTO endereco (fk_logradouro_id, fk_cliente_id, complemento, nome, numero)VALUES("
                + endereco.getFk_logradouro_id() + "," + endereco.getFk_cliente_id() + ",'" + endereco.getComplemento() + "','" + endereco.getNome()+"'," + endereco.getNumero()+");"; 
        
        stmt.executeUpdate(comando);
        stmt.close();
        //c.commit();
        c.close();
    } catch (Exception e) {
        System.err.println(e.getClass().getName() + ": " + e.getMessage());            
    }
    System.out.println("Operação realizada com sucesso!!");
    }

    public  void deleteTable(int id) {
        Connection c = null;
        Statement stmt = null;
        try {
            Class.forName("org.postgresql.Driver");
            c = DriverManager.getConnection(url, usuario, senha);
            System.out.println("Banco de dados aberto com sucesso!!");
            stmt = c.createStatement();
            
            String comando = "DELETE FROM endereco WHERE id=" + id +";";
            
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
        ArrayList listEnderecos = new ArrayList();        
        Connection c = null;
        Statement stmt = null;
        try {
            Class.forName("org.postgresql.Driver");
            c = DriverManager.getConnection(url,usuario,senha);
            //c.setAutoCommit(false);
            System.out.println("Banco de dados aberto com sucesso!!");
            stmt = c.createStatement();
            
            ResultSet rs = stmt.executeQuery("SELECT * FROM endereco ;");
            while (rs.next()) {
                Endereco endereco = new Endereco();
                endereco.setFk_logradouro_id(rs.getInt("fk_logradouro_id"));
                endereco.setFk_cliente_id(rs.getInt("fk_cliente_id"));              
                endereco.setComplemento(rs.getString("complemento"));
                endereco.setNome(rs.getString("nome"));
                endereco.setId(rs.getInt("id"));
                endereco.setNumero(rs.getInt("numero"));
                listEnderecos.add(endereco);
            }
            rs.close();
            stmt.close();
            c.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());            
        }
        System.out.println("Operação realizada com sucesso!!");
        return listEnderecos;
    }
    
}