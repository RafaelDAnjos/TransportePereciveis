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
import transporteperecivel.Adiciona;
/**
 *
 * @author rafae
 */
public class BDAdiciona {
    String url = "jdbc:postgresql://localhost:5432/transportePereciveis",usuario = "postgres",senha = "123456";
    public synchronized void  createTable() {
        Connection c = null;
        Statement stmt = null;
        try {
            Class.forName("org.postgresql.Driver");
            c = DriverManager.getConnection(url, usuario, senha);
            System.out.println("Banco de dados aberto com sucesso!!");
            stmt = c.createStatement();
            
            String comando = "DROP TABLE IF EXISTS adiciona cascade; CREATE TABLE adiciona (\n" +
            "    fk_Funcionario_IDfuncionario serial,\n" +
            "    fk_BandaPorco_ID serial\n" +
            ");";
            
            stmt.executeUpdate(comando);
            stmt.close();
            c.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());            
        }
        System.out.println("Tabela criada com sucesso!!");
    }


public  void insertTable(Adiciona adiciona) {
    
    Connection c = null;
    Statement stmt = null;
    try {
        Class.forName("org.postgresql.Driver");
        c = DriverManager.getConnection(url, usuario, senha);
        System.out.println("Banco de dados aberto com sucesso!!");
        stmt = c.createStatement();
       
        String comando = "INSERT INTO adiciona(fk_BandaPorco_id, Fk_Funcionario_IDfuncionario)VALUES(" + adiciona.getFk_BandaPorco_ID()+ "," + adiciona.getFk_Funcionario_IDfuncionario()+ ");"; 
        
        stmt.executeUpdate(comando);
        stmt.close();
        //c.commit();
        c.close();
    } catch (Exception e) {
        System.err.println(e.getClass().getName() + ": " + e.getMessage());            
    }
    System.out.println("Operação realizada com sucesso!!");
    }

public synchronized ArrayList selectTable() {
        ArrayList listAdiciona = new ArrayList();        
        Connection c = null;
        Statement stmt = null;
        try {
            Class.forName("org.postgresql.Driver");
            c = DriverManager.getConnection(url, usuario, senha);
            System.out.println("Banco de dados aberto com sucesso!!");
            stmt = c.createStatement();
            
            ResultSet rs = stmt.executeQuery("SELECT * FROM Adiciona ;");
            while (rs.next()) {
                Adiciona adiciona = new Adiciona();          
                adiciona.setFk_BandaPorco_ID(rs.getInt("fk_bandaporco_id"));
                adiciona.setFk_Funcionario_IDfuncionario(rs.getInt("fk_funcionario_idFuncionario")); 
                listAdiciona.add(adiciona);
            }
            rs.close();
            stmt.close();
            c.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());            
        }
        System.out.println("Operação realizada com sucesso!!");
        return listAdiciona;
    }

    public  void deleteTable(int idBandaPorco, int idFuncionario) {
        Connection c = null;
        Statement stmt = null;
        try {
            Class.forName("org.postgresql.Driver");
            c = DriverManager.getConnection(url, usuario, senha);
            System.out.println("Banco de dados aberto com sucesso!!");
            stmt = c.createStatement();
            
            String comando = "DELETE FROM adiciona WHERE fk_bandaporco_id=" + idBandaPorco +"and fk_funcionario_idFuncionario ="+ idFuncionario+";";
            
            stmt.executeUpdate(comando);            
            stmt.close();
            c.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + 
                    e.getMessage());            
        }
        System.out.println("Operação realizada com sucesso!!");
    }
    
    public  void updateTable(Adiciona adiciona) {
        Connection c = null;
        Statement stmt = null;
        try {
            Class.forName("org.postgresql.Driver");
            c = DriverManager.getConnection(url,usuario,senha);
            System.out.println("Banco de dados aberto com sucesso!!");
            stmt = c.createStatement();
            
            String sql = "UPDATE adiciona SET Fk_funcionario_IDfuncionario = " + adiciona.getFk_Funcionario_IDfuncionario()+", Fk_bandaporco_ID =" +adiciona.getFk_BandaPorco_ID()+ " where fk_BandaPorco_ID = " + adiciona.getFk_BandaPorco_ID()+";";
            System.out.println(sql);
            stmt.executeUpdate(sql);            
            stmt.close();
            c.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + 
                    e.getMessage());            
        }
        System.out.println("Dado alterado com sucesso!!");
    }

}