/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author Daniel
 */

/*
public class BDPedido implements BDInterface {

    @Override
    public synchronized void  createTable() {
        Connection c = null;
        Statement stmt = null;
        try {
            Class.forName("org.postgresql.Driver");
            c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/testeJava", "postgres", "serra");
            c.setAutoCommit(false);
            System.out.println("Opened database successfully");
            stmt = c.createStatement();
            
            String comando = "CREATE TABLE VEICULO "
                    + "(ID INT PRIMARY KEY  NOT NULL," //AUTOINCREMENT
                        + " QUILOMETRAGEM   INT  NULL, "
                    + " MARCA            CHAR(40)     NOT NULL, "
                    + " MODELO        CHAR(50) NULL, "
                    + " ANO         INT NOT NULL, "
                    + " TIPO_VEICULO NOT NULL )";
            
            stmt.executeUpdate(comando);
            stmt.close();
            c.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + 
                    e.getMessage());            
        }
        System.out.println("Table created successfully");
    }

    @Override
    public  void insertRecord(Veiculo veiculo) {

        Connection c = null;
        Statement stmt = null;
        try {
            Class.forName("org.postgresql.Driver");
            c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/testeJava", "postgres", "serra");
            c.setAutoCommit(false);
            System.out.println("Opened database successfully");
            stmt = c.createStatement();
            
            String comando = "INSERT INTO VEICULO (ID,QUILOMETRAGEM,MARCA,MODELO,ANO,"
                    + "TIPO_VEICULO) "
                    + "VALUES (" + veiculo.getId() + "," + 
                    veiculo.getQuilometragem() + ",'" +
                    veiculo.getMarca() + "','" +
                    veiculo.getModelo() + "'," +
                    veiculo.getAno() +",'" +
                    veiculo.getTipoVeiculo() + "');";  
            
            stmt.executeUpdate(comando);
            stmt.close();
            //c.commit();
            c.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());            
        }
        System.out.println("Records created successfully");
    }

    @Override
    public  void deleteRecord(int id) {
        Connection c = null;
        Statement stmt = null;
        try {
            Class.forName("org.postgresql.Driver");
            c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/testeJava", "postgres", "serra");
            c.setAutoCommit(false);
            System.out.println("Opened database successfully");
            stmt = c.createStatement();
            
            String comando = "DELETE from VEICULO where ID=" + id +";";
            stmt.executeUpdate(comando);
            
            stmt.close();
            c.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + 
                    e.getMessage());            
        }
        System.out.println(
                "Operation done successfully"); 
    }

    @Override
    public synchronized ArrayList selectTable() {
        ArrayList listVeiculos = new ArrayList();        
        Connection c = null;
        Statement stmt = null;
        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:veiculos.db");            
            System.out.println("Opened database successfully");            
            stmt = c.createStatement();
            
            ResultSet rs = stmt.executeQuery("SELECT * FROM VEICULO;");
            while (rs.next()) {
                Veiculo veiculo = new Veiculo();
                veiculo.setId(rs.getInt("id"));
                veiculo.setQuilometragem(rs.getInt("QUILOMETRAGEM"));
                veiculo.setMarca(rs.getString("MARCA"));
                veiculo.setModelo(rs.getString("MODELO"));
                veiculo.setTipoVeiculo(rs.getString("TIPO_VEICULO"));
                veiculo.setAno(rs.getInt("ANO"));          
                listVeiculos.add(veiculo);
            }
            rs.close();
            stmt.close();
            c.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());            
        }
        System.out.println("Operation done successfully");
        return listVeiculos; 
    }
    
}
*/