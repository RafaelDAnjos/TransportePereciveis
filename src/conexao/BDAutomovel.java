package conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import transporteperecivel.Automovel;

/**
 *
 * @author Daniel
 */

public class BDAutomovel {
    String url = "jdbc:postgresql://localhost:5432/transportePereciveis",usuario= "postgres",senha = "123456";
    public synchronized void  createTable() {
        Connection c = null;
        Statement stmt = null;
        try {
            Class.forName("org.postgresql.Driver");
            c = DriverManager.getConnection(url,usuario,senha);
            System.out.println("Banco de dados aberto com sucesso!!");
            stmt = c.createStatement();
            
            String comando = "Drop table if exists automovel cascade; CREATE TABLE automovel (isrefrigerado BOOLEAN, carga_maxima FLOAT, modelo varchar(80), placa VARCHAR(10), fk_funcionario_idFuncionario INT, fk_cidade_id INT, id serial);";
            
            stmt.executeUpdate(comando);
            stmt.close();
            c.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());            
        }
        System.out.println("Tabela criada com sucesso!!");
    }

    public  void insertTable(Automovel automovel) {
    
    Connection c = null;
    Statement stmt = null;
    try {
        Class.forName("org.postgresql.Driver");
        c = DriverManager.getConnection(url,usuario,senha);
        System.out.println("Banco de dados aberto com sucesso!!");
        stmt = c.createStatement();
       
        String comando = "INSERT INTO automovel (isrefrigerado , carga_maxima , modelo,placa, fk_funcionario_idfuncionario,fk_cidade_id)"
                + "VALUES(" + automovel.getIsrefrigerado() + "," + automovel.getCarga_maxima() + ",'" + automovel.getModelo() + "','"
                + automovel.getPlaca() + "'," + automovel.getFk_funcionario_idfuncionario()+","+ automovel.getFk_cidade_id() + ");";
     
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
            c = DriverManager.getConnection(url,usuario,senha);
            System.out.println("Banco de dados aberto com sucesso!!");
            stmt = c.createStatement();
            
            String comando = "DELETE FROM automovel WHERE id = " + id +";";
            
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
        
        ArrayList listAutomoveis = new ArrayList();        
        Connection c = null;
        Statement stmt = null;
        try {
            Class.forName("org.postgresql.Driver");
            c = DriverManager.getConnection(url,usuario,senha);
            //c.setAutoCommit(false);
            System.out.println("Banco de dados aberto com sucesso!!");
            stmt = c.createStatement();
            
            ResultSet rs = stmt.executeQuery("SELECT * FROM automovel ;");
            while (rs.next()) {
                Automovel automovel = new Automovel();
                automovel.setIsrefrigerado(rs.getBoolean("isrefrigerado"));
                automovel.setCarga_maxima(rs.getFloat("carga_maxima"));              
                automovel.setModelo(rs.getString("modelo"));
                automovel.setPlaca(rs.getString("placa"));
                automovel.setFk_funcionario_idfuncionario(rs.getInt("fk_funcionario_idfuncionario"));
                automovel.setFk_cidade_id(rs.getInt("fk_cidade_id"));
                automovel.setId(rs.getInt("id"));
                listAutomoveis.add(automovel);
            }
            
            rs.close();
            stmt.close();
            c.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());            
        }
        System.out.println("Operação realizada com sucesso!!");
        return listAutomoveis;
    }
    public  void updateTable(Automovel automovel) {
        Connection c = null;
        Statement stmt = null;
        try {
            Class.forName("org.postgresql.Driver");
            c = DriverManager.getConnection(url,usuario,senha);
            System.out.println("Banco de dados aberto com sucesso!!");
            stmt = c.createStatement();
            
            String sql = "UPDATE automovel SET carga_maxima = " + automovel.getCarga_maxima() + ", placa = '" + automovel.getPlaca()
                    +"',isrefrigerado = "+automovel.getIsrefrigerado()+",modelo =  '"+automovel.getModelo() +
                    "',fk_funcionario_idfuncionario = "+automovel.getFk_funcionario_idfuncionario()+",fk_cidade_id = "+automovel.getFk_cidade_id()+
                     " WHERE id =" + automovel.getId() + ";";
            System.out.println(sql);
            stmt.executeUpdate(sql);            
            stmt.close();
            c.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + 
                    e.getMessage());            
        }
        System.out.println("Dado deletado com sucesso!!");
    }
}